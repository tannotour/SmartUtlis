package com.mitnick.tannotour.smartutlis.gaea.login;

import com.mitnick.tannotour.easylib.cache.CacheBean;

/**
 * Created by mitnick on 2018/2/1.
 * Description
 */

@CacheBean(memoryResident = true)
public class UserBean {

    /**
     * deviceId : ffffffffe2de9e9acf43c7b75dee2c56
     * entryDatetime : 1491213284000
     * headerImg : /header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg
     * id : 18
     * integral : 0
     * phone : 18428323819
     * userName : tannotour
     * uuid : 90704b00-1853-11e7-9fee-3dc67b13fe13
     */

    private String deviceId;
    private long entryDatetime;
    private String headerImg;
    private int id;
    private int integral;
    private String phone;
    private String password;
    private String userName;
    private String uuid;
    private String livePostNum = "0";
    private String focusNum = "0";
    private String loverNum = "0";
    private String liveEventNum = "0";
    private String collectionNum = "0";

    private boolean isLogined = false;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public long getEntryDatetime() {
        return entryDatetime;
    }

    public void setEntryDatetime(long entryDatetime) {
        this.entryDatetime = entryDatetime;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLivePostNum() {
        return livePostNum;
    }

    public void setLivePostNum(String livePostNum) {
        this.livePostNum = livePostNum;
    }

    public String getFocusNum() {
        return focusNum;
    }

    public void setFocusNum(String focusNum) {
        this.focusNum = focusNum;
    }

    public String getLoverNum() {
        return loverNum;
    }

    public void setLoverNum(String loverNum) {
        this.loverNum = loverNum;
    }

    public String getLiveEventNum() {
        return liveEventNum;
    }

    public void setLiveEventNum(String liveEventNum) {
        this.liveEventNum = liveEventNum;
    }

    public String getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(String collectionNum) {
        this.collectionNum = collectionNum;
    }

    public boolean isLogined() {
        return isLogined;
    }

    public void setLogined(boolean logined) {
        isLogined = logined;
    }
}
