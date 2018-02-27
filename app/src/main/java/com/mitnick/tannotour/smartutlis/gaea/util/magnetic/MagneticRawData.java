package com.mitnick.tannotour.smartutlis.gaea.util.magnetic;

import android.hardware.SensorEvent;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * 一个磁场传感器发出的一个数据
 * Created by Pierce on 2016/11/20.
 */
public class MagneticRawData implements Parcelable {
    int accuracy;
    long timestamp;
    float[] values;

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public float[] getValues() {
        return values;
    }

    public void setValues(float[] values) {
        this.values = values;
    }

    public MagneticRawData() {
    }

    public float computeSquare(){
        return Double.valueOf(
                values[0]*values[0]
                        +values[1]*values[1]
                        +values[2]*values[2]
        ).floatValue();
    }

    public float computeSqrt(){
        return Double.valueOf(Math.sqrt(
                values[0]*values[0]
                +values[1]*values[1]
                +values[2]*values[2])
        ).floatValue();
    }

    public String formateTotalValue(){
        return  String.format("%03.1f", computeSqrt());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.accuracy);
        dest.writeLong(this.timestamp);
        dest.writeFloatArray(this.values);
    }

    protected MagneticRawData(Parcel in) {
        this.accuracy = in.readInt();
        this.timestamp = in.readLong();
        this.values = in.createFloatArray();
    }

    public static final Creator<MagneticRawData> CREATOR = new Creator<MagneticRawData>() {
        @Override
        public MagneticRawData createFromParcel(Parcel source) {
            return new MagneticRawData(source);
        }

        @Override
        public MagneticRawData[] newArray(int size) {
            return new MagneticRawData[size];
        }
    };

    public static MagneticRawData obtain(SensorEvent event){
        MagneticRawData magneticRawData = new MagneticRawData();
        magneticRawData.accuracy = event.accuracy;
        magneticRawData.timestamp = event.timestamp;
        magneticRawData.values = new float[]{
                event.values[0],
                event.values[1],
                event.values[2]
        };

        return magneticRawData;
    }
}
