package com.mitnick.tannotour.smartutlis.gaea.me.mylist.user.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mitnick on 2018/2/1.
 * Description
 */

public class MyListUserBean implements Parcelable, Cloneable {

//    private String deviceId;
//    private long entryDatetime;
    private String headerImg;
    private int id;
    private int integral;
//    private String phone;
//    private String password;
    private String userName;
//    private String uuid;
//    private String livePostNum = "0";
//    private String focusNum = "0";
//    private String loverNum = "0";
//    private String liveEventNum = "0";
//    private String collectionNum = "0";
//    private String citySafeNumber = "0";
//    private String address = "正在确定位置...";
//    private double lon = 0.0;
//    private double lat = 0.0;

    private String cityName;
    private String cityRank;
    private String cityRate;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityRank() {
        return cityRank;
    }

    public void setCityRank(String cityRank) {
        this.cityRank = cityRank;
    }

    public String getCityRate() {
        return cityRate;
    }

    public void setCityRate(String cityRate) {
        this.cityRate = cityRate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.headerImg);
        dest.writeInt(this.id);
        dest.writeInt(this.integral);
        dest.writeString(this.userName);
        dest.writeString(this.cityName);
        dest.writeString(this.cityRank);
        dest.writeString(this.cityRate);
    }

    public MyListUserBean() {
    }

    protected MyListUserBean(Parcel in) {
        this.headerImg = in.readString();
        this.id = in.readInt();
        this.integral = in.readInt();
        this.userName = in.readString();
        this.cityName = in.readString();
        this.cityRank = in.readString();
        this.cityRate = in.readString();
    }

    public static final Creator<MyListUserBean> CREATOR = new Creator<MyListUserBean>() {
        @Override
        public MyListUserBean createFromParcel(Parcel source) {
            return new MyListUserBean(source);
        }

        @Override
        public MyListUserBean[] newArray(int size) {
            return new MyListUserBean[size];
        }
    };
}
