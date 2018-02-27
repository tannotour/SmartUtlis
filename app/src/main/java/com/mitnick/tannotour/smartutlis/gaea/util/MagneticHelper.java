package com.mitnick.tannotour.smartutlis.gaea.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

import com.mitnick.tannotour.smartutlis.gaea.util.magnetic.HighMagneticEvent;
import com.mitnick.tannotour.smartutlis.gaea.util.magnetic.MagneticIntervalData;
import com.mitnick.tannotour.smartutlis.gaea.util.magnetic.MagneticRawData;
import com.mitnick.tannotour.smartutlis.gaea.util.magnetic.SensorService;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pierce on 2016/12/4.
 * 1ut=1000nt
 */
public class MagneticHelper extends SensorHelper{
    /**
     * 磁场干扰阀值
     * uT
     */
    static final int disturbMagneticUT = 70;

    /**
     * 默认采样率us
     */
    public static final int defaultSamplingPeriodUs = 1*200*1000;
    /**
     * 默认数据发送间隔时间（毫秒）
     */
    public static final int defaultReportInterval = SensorService.defaultMagneticDuration;
    /**
     * 默认最大延迟采样us
     */
    public static final int defaultMaxReportLatencyUs =
            Math.max(defaultReportInterval,
            10 * defaultSamplingPeriodUs);


    int samplingPeriodUs = defaultSamplingPeriodUs;
    int maxReportLatencyUs = defaultMaxReportLatencyUs;

    /**
     * 数据发送间隔
     */
    int reportInterval = defaultReportInterval;
    ArrayList<MagneticRawData> dataBuffer = new ArrayList<>();
    /**
     * 最近一次采样值
     */
    SensorEvent lastEvent;
    long lastReportTime = 0;


    /**
     * 传感器能否休眠
     */
    boolean canSleep = true;
    /**
     * 是否需要定时发送数据
     */
    boolean shouldReportInterval = true;

    public MagneticHelper(SensorManager sensorManager) {
        super(sensorManager, Sensor.TYPE_MAGNETIC_FIELD);
    }

    @Override
    protected int getDefaultMaxReportLatencyUs() {
        return maxReportLatencyUs;
    }

    @Override
    protected int getDefaultSamplingPeriodUs() {
        return samplingPeriodUs;
    }


    @Override
    protected void sensorChanged(SensorEvent event) {
//        Log.d(getClass().getSimpleName(), "sensorChanged");
        MagneticRawData magneticRawData = MagneticRawData.obtain(event);

        //立即发送磁场传感器数据
        EventBus.getDefault().post(magneticRawData);

        // 判断采集周期，
        if(!shouldReportInterval){return;}
        dataBuffer.add(magneticRawData);

        if(lastEvent == null){
            lastReportTime = System.currentTimeMillis();
        }else if(reportInterval > 0
                && System.currentTimeMillis() - lastReportTime >=
                (
//                        MainApp.visible
//                        ? 100 :
                        reportInterval
                )){
            //该是时候发送数据了
            sendData();
        }else {
            float square = magneticRawData.computeSquare();
            //大于70ut
            if(square > (disturbMagneticUT * disturbMagneticUT)){
                //靠近磁场附近，磁场异常
                EventBus.getDefault()
                        .post(HighMagneticEvent.EVENT);

            }
        }
        lastEvent = event;
    }

    private void sendData() {
        if(dataBuffer.isEmpty()){return;}
        MagneticIntervalData magneticIntervalData = new MagneticIntervalData();
        magneticIntervalData.getBuffer().addAll(dataBuffer);
        magneticIntervalData.setStartTime(lastReportTime);
        magneticIntervalData.setEndTime(System.currentTimeMillis());

        EventBus.getDefault()
                .post(magneticIntervalData);

        lastReportTime = System.currentTimeMillis();
        dataBuffer.clear();
//        Log.d(getClass().getSimpleName(), "------shoot data-------->>>");

    }

    @Override
    public void start(SensorManager sensorManager) throws Throwable {
        shouldReportInterval = true;
        super.start(sensorManager);
    }

    @Override
    public void stop(SensorManager sensorManager) throws Throwable {
        shouldReportInterval = false;//标记不需要发送数据

        if(canSleep){
            super.stop(sensorManager);
            sendData();
        }
    }

    @Override
    protected void accuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public boolean onConfigChanged(String id, JSONObject config) {
        boolean changed = super.onConfigChanged(id, config);

//        samplingPeriodUs = config.optInt("samplingPeriodUs", samplingPeriodUs);
//        maxReportLatencyUs = config.optInt("maxReportLatencyUs", maxReportLatencyUs);

        int tmpReportInterval = config.optInt("reportInterval", reportInterval);
        changed = changed || tmpReportInterval != reportInterval;
        reportInterval = tmpReportInterval;

        if(changed){
            restartIfRuning();
        }

        return changed;
    }

    public void getConfig(JSONObject config) throws JSONException {
        super.getConfig(config);
        config.put("reportInterval", reportInterval);

//        config.put("samplingPeriodUs", samplingPeriodUs);
//        config.put("maxReportLatencyUs", maxReportLatencyUs);
    }

    public static JSONObject buildDefConfig() throws JSONException {
        JSONObject config = new JSONObject();
        config.put("reportInterval", defaultReportInterval);
        config.put("samplingPeriodUs", defaultSamplingPeriodUs);
        config.put("maxReportLatencyUs", defaultMaxReportLatencyUs);
        return config;
    }

    /**
     * 一个比较特殊的方法，设置传感器是否可以休眠
     * 因为主页面传感器不能休眠，
     * 其他页面或者后天又需要保持休眠
     * @param canSleep
     */
    public void setCanSleep(boolean canSleep) {
        if(this.canSleep == canSleep)return;

        this.canSleep = canSleep;

        if(canSleep && !shouldReportInterval){
            //关闭传感器
            try {
                super.stop(getSensorManager());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            sendData();
        }
    }
}
