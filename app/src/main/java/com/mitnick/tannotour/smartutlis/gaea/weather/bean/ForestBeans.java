package com.mitnick.tannotour.smartutlis.gaea.weather.bean;

/**
 * Created by CS on 2017/8/16.
 */

public class ForestBeans {
    private String time;
    private String img_url;
    private String weather;
    private String temp;

    public ForestBeans(String time, String img_url, String weather, String temp) {
        this.time = time;
        this.img_url = img_url;
        this.weather = weather;
        this.temp = temp;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
