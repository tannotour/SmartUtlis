package com.mitnick.tannotour.smartutlis.gaea.me.mylist.bean;

/**
 * Created by mitnick on 2018/2/5.
 * Description
 */

public class MyListBean {

    private String id;
    private String pictures;
    private String ctime;
    private String address;
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFirstPicture(){
        if(pictures.isEmpty()){
            return "";
        }else{
            return pictures.split(",")[0];
        }
    }
}
