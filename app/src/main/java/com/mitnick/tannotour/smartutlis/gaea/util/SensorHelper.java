package com.mitnick.tannotour.smartutlis.gaea.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Log;

import com.mitnick.tannotour.smartutlis.gaea.util.config.ConfigChangeListener;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pierce on 2016/12/4.
 */
public abstract class SensorHelper implements SensorEventListener, ConfigChangeListener {
    protected SensorManager sensorManager;
    final Sensor sensor;
    /**
     * 采样率
     */
    int samplingPeriodUs = getDefaultSamplingPeriodUs();
    /**
     * 最大延迟采样
     */
    int maxReportLatencyUs = getDefaultMaxReportLatencyUs();
    boolean working = false;


    public SensorHelper(SensorManager sensorManager, int type){
        this(sensorManager.getDefaultSensor(type));
    }

    public SensorHelper(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public final void onSensorChanged(SensorEvent sensorEvent) {
        if(sensor.getType() != sensorEvent.sensor.getType()){return;}
        sensorChanged(sensorEvent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        if(this.sensor.getType() != sensor.getType()){return;}
        accuracyChanged(sensor, accuracy);
    }

    /**
     * @param sensorManager
     * @throws Throwable
     */
    public void start(SensorManager sensorManager) throws Throwable{
        if(working){
            if(sensorManager == this.sensorManager){
                return;
            }else{
                restart(sensorManager);
                return;
            }
        }
        working = true;

        this.sensorManager = sensorManager;
        Log.d(SensorHelper.class.getSimpleName(), "启动磁场传感器：采样率="+samplingPeriodUs);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            sensorManager.registerListener(this,
                    sensor,
                    samplingPeriodUs,
                    maxReportLatencyUs,
                    null);
        }else {
            sensorManager.registerListener(this,
                    sensor,
                    samplingPeriodUs);
        }
    }

    public void stop(SensorManager sensorManager) throws Throwable{
        if(!working
                || sensorManager == null){return;}
        if(this.sensorManager != sensorManager){
            return;
        }
        working = false;

        Log.d(SensorHelper.class.getSimpleName(), "停止磁场传感器");
        sensorManager
                .unregisterListener(this, sensor);
        this.sensorManager = null;
    }

    /**
     * @param sensorManager
     */
    private void restart(SensorManager sensorManager) throws Throwable {
        stop(sensorManager);
        start(sensorManager);
    }

    public boolean onConfigChanged(String id, JSONObject config){
        int tmpSamplingPeriodUs = config.optInt("samplingPeriodUs", samplingPeriodUs);
        int tmpMaxReportLatencyUs = config.optInt("maxReportLatencyUs", maxReportLatencyUs);

        boolean changed = (tmpMaxReportLatencyUs != maxReportLatencyUs
                        || tmpSamplingPeriodUs != samplingPeriodUs);
        samplingPeriodUs = tmpSamplingPeriodUs;
        maxReportLatencyUs = tmpMaxReportLatencyUs;

        return changed;
    }

    public void getConfig(JSONObject config) throws JSONException {
        config.put("samplingPeriodUs", samplingPeriodUs);
        config.put("maxReportLatencyUs", maxReportLatencyUs);
    }

    protected void restartIfRuning() {
        if(working){
            SensorManager sensorManager = this.sensorManager;
            try {
                restart(sensorManager);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    protected abstract int getDefaultMaxReportLatencyUs();
    protected abstract int getDefaultSamplingPeriodUs();

    protected abstract void sensorChanged(SensorEvent sensorEvent);
    protected abstract void accuracyChanged(Sensor sensor, int accuracy);


    protected SensorManager getSensorManager() {
        return sensorManager;
    }
}
