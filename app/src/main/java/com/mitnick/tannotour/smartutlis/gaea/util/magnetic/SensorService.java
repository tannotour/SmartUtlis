package com.mitnick.tannotour.smartutlis.gaea.util.magnetic;

import android.app.Service;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mitnick.tannotour.smartutlis.BuildConfig;
import com.mitnick.tannotour.smartutlis.gaea.util.MagneticHelper;
import com.mitnick.tannotour.smartutlis.gaea.util.ShakeEvent;
import com.mitnick.tannotour.smartutlis.gaea.util.ShakeHelper;
import com.mitnick.tannotour.smartutlis.gaea.util.config.ConfigCenter;
import com.mitnick.tannotour.smartutlis.gaea.util.config.ConfigChangeListener;
import com.mitnick.tannotour.smartutlis.gaea.util.config.ConfigEvent;
import com.mitnick.tannotour.smartutlis.test.MyApp;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Pierce on 2016/12/4.
 */
public class SensorService extends Service implements ConfigChangeListener {
    private SensorManager sensorManager;
    /**
     * 两次磁场采集默认休眠间隔时间ms
     */
    private static final int defaultSleepInterval = BuildConfig.DEBUG
            ? 5 * 60 * 1000
            : 5 * 60 * 1000;
    /**
     * 默认采集磁场时间长度ms,0一直采集
     */
    public static final int defaultMagneticDuration = BuildConfig.DEBUG
            ? 40 * 1000
            : 20 * 1000;
    /**
     * 测试静止状态时长
     */
    private static final int defaultShakeTestDuration = BuildConfig.DEBUG
            ? 5 * 1000
            : 5 * 1000;
    /**
     * 摇晃之后多久再次检测
     */
    private static final int defaultWakeupDelay = BuildConfig.DEBUG
            ? 1 * 1000
            : 10 * 1000;

    private MagneticHelper magneticHelper;
    private ShakeHelper shakeHelper;
    private Handler handler;

    private int sleepInterval = defaultSleepInterval;
    private int magneticDuration = defaultMagneticDuration;
    private int shakeTestDuration = defaultShakeTestDuration;
    private int wakeupDelay = defaultWakeupDelay;

    private static final String CONFIG_ID = "SensorService";
    private static final String MAGNETIC_HELPER_CONFIG_ID = "MagneticHelper";
    private static final String SHAKE_HELPER_CONFIG_ID = "ShakeHelper";

    private final String TAG = "SensorService";


    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");

        handler = new Handler();
//        onConfigChanged(CONFIG_ID, new JSONObject());

        EventBus.getDefault()
                .register(this);

        onWakeUp();
        ConfigCenter.getInstance()
                .subscribe(this, CONFIG_ID);
    }


    boolean forceWakeup = false;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!forceWakeup
                && forceWakeup != MyApp.getVisible()){
            //进入主页面，开始不停刷新
            forceWakeup = true;

            if(shakeTesting){
                //停止晃动测试
                try {
                    getShakeHelper().stop(getSensorManager());
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                //停止各种延迟timer
                handler.removeCallbacks(startMagneticRunner);
                handler.removeCallbacks(wakeupRunnable);
                handler.removeCallbacks(stopMagneticRunner);
                //立即开始收集磁场
                startMagneticRunner.run();
            }else if(magneticCollecting){
                //正在收集磁场。。。

                //停止各种延迟timer
                handler.removeCallbacks(startMagneticRunner);
                handler.removeCallbacks(wakeupRunnable);
                handler.removeCallbacks(stopMagneticRunner);
            }else{
                //停止各种延迟timer
                handler.removeCallbacks(startMagneticRunner);
                handler.removeCallbacks(wakeupRunnable);
                handler.removeCallbacks(stopMagneticRunner);
                //立即开始收集磁场
                startMagneticRunner.run();
            }
            //定时检查是否取消
            handler.postDelayed(checkAppVisibleRunner, 3_000);

            //设置不需要停止传感器
            magneticHelper.setCanSleep(false);

            //改变磁场采集频率
//            MagneticHelper magneticHelper = getMagneticHelper();
//            try {
//                JSONObject config = new JSONObject();
//                magneticHelper.getConfig(config);
//                config.put("reportInterval", 1);
//                config.put("samplingPeriodUs", SensorManager.SENSOR_DELAY_FASTEST);
//                config.put("maxReportLatencyUs", 100*1000);
//                magneticHelper.onConfigChanged("", config);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

        }

        return super.onStartCommand(intent, flags, startId);
    }


    /**
     * 定时检查app是否在前台显示，
     * 前台显示的时候最快的频率发送数据
     */
    Runnable checkAppVisibleRunner = new Runnable() {
        @Override
        public void run() {
            if(forceWakeup != MyApp.getVisible()
                    && forceWakeup){
                //离开主界面了
                forceWakeup = false;
                magneticHelper.setCanSleep(true);
                //停止磁场收集
                handler.postDelayed(stopMagneticRunner,
                        3_000);
//                //恢复磁场采集频率
//                MagneticHelper magneticHelper = getMagneticHelper();
//                try {
//                    JSONObject config = new JSONObject();
//                    magneticHelper.getConfig(config);
//                    config.put("reportInterval", MagneticHelper.defaultReportInterval);
//                    config.put("samplingPeriodUs", MagneticHelper.defaultSamplingPeriodUs);
//                    config.put("maxReportLatencyUs", MagneticHelper.defaultMaxReportLatencyUs);
//                    magneticHelper.onConfigChanged("", config);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }

            }else {
                //延迟继续监测
                handler.postDelayed(checkAppVisibleRunner, 3_000);
            }
        }
    };


    public static JSONObject buildDefConfig() throws JSONException {
        JSONObject config = new JSONObject();
        config.put("sleepInterval", defaultSleepInterval);
        config.put("magneticDuration", defaultMagneticDuration);
        config.put("shakeTestDuration", defaultShakeTestDuration);
        config.put("wakeupDelay", defaultWakeupDelay);

        config.put(MAGNETIC_HELPER_CONFIG_ID,
                MagneticHelper.buildDefConfig());

        config.put(SHAKE_HELPER_CONFIG_ID,
                ShakeHelper.buildDefConfig());

        return config;
    }

    /**
     * @param id === SensorService
     * @param config
     */
    @Override
    public boolean onConfigChanged(String id, JSONObject config) {
        if(!CONFIG_ID.equals(id)){
            Log.w(TAG, "config with ID["+id+"] MISS-MATCH!!!");
            return false;
        }
        Log.i(TAG, "onConfigChanged");

        sleepInterval = config.optInt("sleepInterval", sleepInterval);
        magneticDuration = config.optInt("magneticDuration", magneticDuration);
        shakeTestDuration = config.optInt("shakeTestDuration", shakeTestDuration);
        wakeupDelay = config.optInt("wakeupDelay", wakeupDelay);


        boolean changed = false;

        JSONObject magneticHelperConfig = config.optJSONObject(MAGNETIC_HELPER_CONFIG_ID);
        if(magneticHelperConfig != null){
            changed = changed || getMagneticHelper()
                    .onConfigChanged(MAGNETIC_HELPER_CONFIG_ID, magneticHelperConfig);
        }

        JSONObject shakeHelperConfig = config.optJSONObject(SHAKE_HELPER_CONFIG_ID);
        if(shakeHelperConfig != null){
            changed = changed || getShakeHelper()
                    .onConfigChanged(SHAKE_HELPER_CONFIG_ID, shakeHelperConfig);
        }
        return changed;
    }


    boolean shakeTesting = false;

    /**
     * 唤醒，开始检测是否摇晃
     */
    void onWakeUp(){
        Log.i(TAG, "onWakeUp");

        if(shakeTestDuration > 0
                && !forceWakeup){
            try {
                //启动晃动检测
                getShakeHelper()
                        .start(getSensorManager());
                shakeTesting = true;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return;
            }
            //延迟启动
            handler.postDelayed(startMagneticRunner,
                    shakeTestDuration);
        }else{
            handler.postDelayed(startMagneticRunner,
                    0);
        }
    }


    /**
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ShakeEvent event){
//        Logger.i("onEvent--->ShakeEvent");
        handler.removeCallbacks(startMagneticRunner);

        if(wakeupDelay > 0){
            handler.postDelayed(wakeupRunnable,
                    wakeupDelay);
        }
    }


    /**
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ConfigEvent event){
        onConfigChanged(event.id, event.config);
    }


    boolean magneticCollecting = false;
    /**
     * 启动磁场采集定时任务
     */
    Runnable startMagneticRunner = new Runnable(){
        @Override
        public void run() {
            shakeTesting = false;
//            Logger.i("startMagneticRunner-->run");
            try {
//                LocationHelper.getInstance()
//                        .listen();
                getShakeHelper()
                        .stop(getSensorManager());
                getMagneticHelper()
                        .start(getSensorManager());
                magneticCollecting = true;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            if(magneticDuration > 0
                    || !forceWakeup){
                //延迟停止磁场检测
                handler.postDelayed(stopMagneticRunner,
                        magneticDuration);
            }
        }
    };

    /**
     * 停止收集磁场
     */
    Runnable stopMagneticRunner = new Runnable(){
        @Override
        public void run() {
//            Logger.i("stopMagneticRunner-->run");
            if(forceWakeup){return;}

            try {
//                LocationHelper.getInstance()
//                        .unlisten();
                getMagneticHelper()
                        .stop(getSensorManager());

                magneticCollecting = false;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

            if(sleepInterval > 0
                    && !forceWakeup){
                handler.postDelayed(wakeupRunnable,
                        sleepInterval);
            }
        }
    };

    /**
     * 定时唤醒
     */
    Runnable wakeupRunnable = new Runnable(){
        @Override
        public void run() {
            onWakeUp();
        }
    };

    private SensorManager getSensorManager() {
        if(sensorManager == null){
            sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        }
        return sensorManager;
    }

    private ShakeHelper getShakeHelper() {
        if(shakeHelper == null){
            shakeHelper = new ShakeHelper(getSensorManager());
        }
        return shakeHelper;
    }

    private MagneticHelper getMagneticHelper() {
        if(magneticHelper == null){
            magneticHelper = new MagneticHelper(getSensorManager());
        }
        return magneticHelper;
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");

        EventBus.getDefault().unregister(this);
//        LocationHelper.getInstance().unlisten();

        if(magneticHelper != null){
            try {
                magneticHelper.stop(getSensorManager());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        if(shakeHelper != null){
            try {
                shakeHelper.stop(getSensorManager());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        handler.removeCallbacks(wakeupRunnable);
        handler.removeCallbacks(startMagneticRunner);
        handler.removeCallbacks(stopMagneticRunner);

        super.onDestroy();
    }
}
