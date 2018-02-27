package com.mitnick.tannotour.smartutlis.gaea.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pierce on 2016/12/4.
 */
public class ShakeHelper extends SensorHelper {
    // 速度阈值，当摇晃速度达到这值后产生作用
    private static final int SPEED_SHRESHOLD = 5000;
    // 两次检测的时间间隔
    private static final int UPTATE_INTERVAL_TIME = 50;

    // 手机上一个位置时重力感应坐标
    private float lastX;
    private float lastY;
    private float lastZ;
    // 上次检测时间
    private long lastUpdateTime;

    public ShakeHelper(SensorManager sensorManager) {
        super(sensorManager, Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected int getDefaultMaxReportLatencyUs() {
        return SensorManager.SENSOR_DELAY_NORMAL;
    }

    @Override
    protected int getDefaultSamplingPeriodUs() {
        return SensorManager.SENSOR_DELAY_NORMAL;
    }

    @Override
    protected void sensorChanged(SensorEvent event) {
        // 现在检测时间
        long currentUpdateTime = System.currentTimeMillis();
        // 两次检测的时间间隔
        long timeInterval = currentUpdateTime - lastUpdateTime;
        // 判断是否达到了检测时间间隔
        if (timeInterval < UPTATE_INTERVAL_TIME) return;
        // 现在的时间变成last时间
        lastUpdateTime = currentUpdateTime;
        // 获得x,y,z坐标
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];
        // 获得x,y,z的变化值
        float deltaX = x - lastX;
        float deltaY = y - lastY;
        float deltaZ = z - lastZ;
        // 将现在的坐标变成last坐标
        lastX = x;
        lastY = y;
        lastZ = z;
        double speed = Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ
                * deltaZ)
                / timeInterval * 10000;
        // 达到速度阀值，发出提示
        if (speed >= SPEED_SHRESHOLD){
            onShake();
        }
    }

    private void onShake() {
        EventBus.getDefault().post(ShakeEvent.INSTANCE);
    }

    @Override
    protected void accuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public boolean onConfigChanged(String id, JSONObject config) {
        boolean changed = super.onConfigChanged(id, config);
        if(changed)
            restartIfRuning();
        return changed;
    }

    public static JSONObject buildDefConfig() throws JSONException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("samplingPeriodUs", SensorManager.SENSOR_DELAY_NORMAL);
        jsonObject.put("maxReportLatencyUs", SensorManager.SENSOR_DELAY_NORMAL);

        return jsonObject;
    }
}
