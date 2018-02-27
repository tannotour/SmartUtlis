package com.mitnick.tannotour.smartutlis.gaea.util.config;

import org.json.JSONObject;

/**
 * Created by suke on 2017/1/13.
 */

public class ConfigEvent {
    public final String id;
    public final JSONObject config;

    public ConfigEvent(String id, JSONObject config) {
        this.id = id;
        this.config = config;
    }
}
