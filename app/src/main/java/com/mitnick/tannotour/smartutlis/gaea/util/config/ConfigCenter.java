package com.mitnick.tannotour.smartutlis.gaea.util.config;

import android.content.Context;
import android.text.TextUtils;

import org.json.JSONObject;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by suke on 2016/12/9.
 */

public class ConfigCenter {
    private Context context;
    private File cacheFile;

    private static final ConfigCenter INSTANCE = new ConfigCenter();

    JSONObject configs;
    Map<String, List<WeakReference<ConfigChangeListener>>> subscribers;


    private ConfigCenter(){
        subscribers = new HashMap<String, List<WeakReference<ConfigChangeListener>>>();
    }

    public static void init(Context context){
        INSTANCE.context = context;
    }

    public static ConfigCenter getInstance(){
        return INSTANCE;
    }

    public void loadFromCache(){
        if(cacheFile == null || !cacheFile.exists()){return;}

        JSONObject jsonObject = new JSONObject();
        configs = jsonObject;
        broadcastConfig(jsonObject);
    }

    private void broadcastConfig(JSONObject configs) {
        for(Map.Entry<String, List<WeakReference<ConfigChangeListener>>> entry : subscribers.entrySet()){
            String id = entry.getKey();

            JSONObject jsonObject = configs.optJSONObject(id);
            if(jsonObject == null){continue;}

            List<WeakReference<ConfigChangeListener>> referenceList = entry.getValue();
            Iterator<WeakReference<ConfigChangeListener>> iterator = referenceList.iterator();
            while (iterator.hasNext()){
                WeakReference<ConfigChangeListener> weakReference = iterator.next();
                ConfigChangeListener configChangeListener = weakReference.get();

                if(configChangeListener != null){
                    configChangeListener.onConfigChanged(id, jsonObject);
                }else {
                    referenceList.remove(weakReference);
                }
            }
        }
    }

    public void subscribe(ConfigChangeListener listener, String id){
        if(listener == null || TextUtils.isEmpty(id)){return;}

        List<WeakReference<ConfigChangeListener>> referenceList = subscribers.get(id);
        if(referenceList == null){
            referenceList = new ArrayList<>();
            subscribers.put(id, referenceList);
        }
        if(referenceList.contains(listener)){return;}
        referenceList.add(new WeakReference<>(listener));

        // 获取配置
        if(configs == null){
            return;
        }
        JSONObject jsonObject = configs.optJSONObject(id);
        listener.onConfigChanged(id, jsonObject);
    }


}
