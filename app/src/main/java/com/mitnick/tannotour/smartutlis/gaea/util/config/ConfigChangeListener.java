package com.mitnick.tannotour.smartutlis.gaea.util.config;

import org.json.JSONObject;

/**
 * Created by Pierce on 2016/11/27.
 */
public interface ConfigChangeListener {
    boolean onConfigChanged(String id, JSONObject config);
}
