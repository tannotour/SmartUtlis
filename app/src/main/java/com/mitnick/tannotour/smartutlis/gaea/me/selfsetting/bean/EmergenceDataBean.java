package com.mitnick.tannotour.smartutlis.gaea.me.selfsetting.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.mitnick.tannotour.easylib.cache.CacheBean;

/**
 * Created by mitnick on 2018/2/11.
 * Description
 */
@CacheBean
public class EmergenceDataBean implements Parcelable, Cloneable {

    /**
     * allergy : 1
     * birth : 1
     * bloodType : 1
     * disease : 1
     * height : 1
     * id :
     * operation : 1
     * sex : 1
     * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
     */

    private String allergy = "无";
    private String birth = "不详";
    private String bloodType = "不详";
    private String disease = "无";
    private String height = "不详";
    private String id;
    private String operation = "无";
    private String sex = "不详";
    private String userId;
    private boolean isSetted = false;

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isSetted() {
        return isSetted;
    }

    public void setSetted(boolean setted) {
        isSetted = setted;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.allergy);
        dest.writeString(this.birth);
        dest.writeString(this.bloodType);
        dest.writeString(this.disease);
        dest.writeString(this.height);
        dest.writeString(this.id);
        dest.writeString(this.operation);
        dest.writeString(this.sex);
        dest.writeString(this.userId);
        dest.writeByte(this.isSetted ? (byte) 1 : (byte) 0);
    }

    public EmergenceDataBean() {
    }

    protected EmergenceDataBean(Parcel in) {
        this.allergy = in.readString();
        this.birth = in.readString();
        this.bloodType = in.readString();
        this.disease = in.readString();
        this.height = in.readString();
        this.id = in.readString();
        this.operation = in.readString();
        this.sex = in.readString();
        this.userId = in.readString();
        this.isSetted = in.readByte() != 0;
    }

    public static final Parcelable.Creator<EmergenceDataBean> CREATOR = new Parcelable.Creator<EmergenceDataBean>() {
        @Override
        public EmergenceDataBean createFromParcel(Parcel source) {
            return new EmergenceDataBean(source);
        }

        @Override
        public EmergenceDataBean[] newArray(int size) {
            return new EmergenceDataBean[size];
        }
    };

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
