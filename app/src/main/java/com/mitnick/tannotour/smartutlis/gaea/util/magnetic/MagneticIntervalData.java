package com.mitnick.tannotour.smartutlis.gaea.util.magnetic;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Pierce on 2016/11/30.
 */
public class MagneticIntervalData implements Parcelable {
    /**
     * 磁场数据点
     */
    ArrayList<MagneticRawData> buffer = new ArrayList<>();
    /**
     * 开始时间
     */
    long startTime;
    /**
     * 结束时间
     */
    long endTime;

    public ArrayList<MagneticRawData> getBuffer() {
        return buffer;
    }

    public void setBuffer(ArrayList<MagneticRawData> buffer) {
        this.buffer = buffer;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.buffer);
        dest.writeLong(this.startTime);
        dest.writeLong(this.endTime);
    }

    public MagneticIntervalData() {
    }

    protected MagneticIntervalData(Parcel in) {
        this.buffer = in.createTypedArrayList(MagneticRawData.CREATOR);
        this.startTime = in.readLong();
        this.endTime = in.readLong();
    }

    public static final Creator<MagneticIntervalData> CREATOR = new Creator<MagneticIntervalData>() {
        @Override
        public MagneticIntervalData createFromParcel(Parcel source) {
            return new MagneticIntervalData(source);
        }

        @Override
        public MagneticIntervalData[] newArray(int size) {
            return new MagneticIntervalData[size];
        }
    };

    public float getMagneticAverage() {
        float square = 0;
        for(MagneticRawData magneticRawData : buffer){
            square += magneticRawData.computeSquare();
        }
        return Double.valueOf(Math.sqrt(square / buffer.size())).floatValue();
    }

    public float getMagneticMin() {
        float min = Float.MAX_VALUE;

        for(MagneticRawData magneticRawData : buffer){
            float value = magneticRawData.computeSqrt();
            if(min > value){min = value;}
        }

        return min;
    }

    public float getMagneticMax() {
        float max = Float.MIN_VALUE;

        for(MagneticRawData magneticRawData : buffer){
            float value = magneticRawData.computeSqrt();
            if(max < value){max = value;}
        }

        return max;
    }
}
