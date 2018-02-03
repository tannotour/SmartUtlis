package com.mitnick.tannotour.smartutlis.gaea.coterie.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by mitnick on 2018/2/2.
 * Description
 */

public class CoterieBean implements Parcelable {

    private String address;
    private int comments;
    private String ctime;
    private String headerImg;
    private String id;
    private double lat;
    private int likes;
    private double lng;
    private String message;
    private String pictures;
    private String userId;
    private String userName;
    private List<CommentBean> comment;
    private List<LikeBean> like;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<CommentBean> getComment() {
        return comment;
    }

    public void setComment(List<CommentBean> comment) {
        this.comment = comment;
    }

    public void addComment(CommentBean commentBean){
        this.comment.add(commentBean);
    }

    public List<LikeBean> getLike() {
        return like;
    }

    public void setLike(List<LikeBean> like) {
        this.like = like;
    }

    public void addLike(LikeBean likeBean){
        this.like.add(likeBean);
    }

    public static class CommentBean implements Parcelable {
        /**
         * ctime : 2017-04-05 16:02:58
         * headerImg :
         * message : 我是评论
         * postId : 9ae2591c-0954-42cc-91e0-77567f2a488f
         * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
         * userName : 18428323819
         */

        private String ctime;
        private String headerImg;
        private String message;
        private String postId;
        private String userId;
        private String userName;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getHeaderImg() {
            return headerImg;
        }

        public void setHeaderImg(String headerImg) {
            this.headerImg = headerImg;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.ctime);
            dest.writeString(this.headerImg);
            dest.writeString(this.message);
            dest.writeString(this.postId);
            dest.writeString(this.userId);
            dest.writeString(this.userName);
        }

        public CommentBean() {
        }

        protected CommentBean(Parcel in) {
            this.ctime = in.readString();
            this.headerImg = in.readString();
            this.message = in.readString();
            this.postId = in.readString();
            this.userId = in.readString();
            this.userName = in.readString();
        }

        public static final Parcelable.Creator<CommentBean> CREATOR = new Parcelable.Creator<CommentBean>() {
            @Override
            public CommentBean createFromParcel(Parcel source) {
                return new CommentBean(source);
            }

            @Override
            public CommentBean[] newArray(int size) {
                return new CommentBean[size];
            }
        };
    }

    public static class LikeBean implements Parcelable {
        /**
         * ctime : 2017-04-05 16:03:36
         * headerImg :
         * postId : 7215b751-45de-4c5a-9bed-b639d46f8430
         * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
         * userName : 18428323819
         */

        private String ctime;
        private String headerImg;
        private String postId;
        private String userId;
        private String userName;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getHeaderImg() {
            return headerImg;
        }

        public void setHeaderImg(String headerImg) {
            this.headerImg = headerImg;
        }

        public String getPostId() {
            return postId;
        }

        public void setPostId(String postId) {
            this.postId = postId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.ctime);
            dest.writeString(this.headerImg);
            dest.writeString(this.postId);
            dest.writeString(this.userId);
            dest.writeString(this.userName);
        }

        public LikeBean() {
        }

        protected LikeBean(Parcel in) {
            this.ctime = in.readString();
            this.headerImg = in.readString();
            this.postId = in.readString();
            this.userId = in.readString();
            this.userName = in.readString();
        }

        public static final Parcelable.Creator<LikeBean> CREATOR = new Parcelable.Creator<LikeBean>() {
            @Override
            public LikeBean createFromParcel(Parcel source) {
                return new LikeBean(source);
            }

            @Override
            public LikeBean[] newArray(int size) {
                return new LikeBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeInt(this.comments);
        dest.writeString(this.ctime);
        dest.writeString(this.headerImg);
        dest.writeString(this.id);
        dest.writeDouble(this.lat);
        dest.writeInt(this.likes);
        dest.writeDouble(this.lng);
        dest.writeString(this.message);
        dest.writeString(this.pictures);
        dest.writeString(this.userId);
        dest.writeString(this.userName);
        dest.writeTypedList(this.comment);
        dest.writeTypedList(this.like);
    }

    public CoterieBean() {
    }

    protected CoterieBean(Parcel in) {
        this.address = in.readString();
        this.comments = in.readInt();
        this.ctime = in.readString();
        this.headerImg = in.readString();
        this.id = in.readString();
        this.lat = in.readDouble();
        this.likes = in.readInt();
        this.lng = in.readDouble();
        this.message = in.readString();
        this.pictures = in.readString();
        this.userId = in.readString();
        this.userName = in.readString();
        this.comment = in.createTypedArrayList(CommentBean.CREATOR);
        this.like = in.createTypedArrayList(LikeBean.CREATOR);
    }

    public static final Parcelable.Creator<CoterieBean> CREATOR = new Parcelable.Creator<CoterieBean>() {
        @Override
        public CoterieBean createFromParcel(Parcel source) {
            return new CoterieBean(source);
        }

        @Override
        public CoterieBean[] newArray(int size) {
            return new CoterieBean[size];
        }
    };
}
