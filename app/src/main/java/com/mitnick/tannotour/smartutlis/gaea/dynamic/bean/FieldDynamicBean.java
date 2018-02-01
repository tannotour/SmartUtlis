package com.mitnick.tannotour.smartutlis.gaea.dynamic.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.List;

/**
 * Created by mitnick on 2018/1/25.
 * Description
 */

public class FieldDynamicBean implements Parcelable {

    /**
     * address : 中国四川省成都市双流县梓州大道辅路
     * comments : [{"ctime":"2018-01-27 10:08:03","eventId":"7691c98d-d4ec-4b06-a51d-dcced00e4268","id":"300db397-0931-4fe6-8d3e-cc6f27e74d62","message":"海关改革个","user":{"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"},"userId":"90704b00-1853-11e7-9fee-3dc67b13fe13"}]
     * ctime : 2018-01-24 20:03
     * durationHours : 1
     * eventType : 实景
     * id : 7691c98d-d4ec-4b06-a51d-dcced00e4268
     * lat : 30.50409848
     * level : 10
     * lng : 104.0878362
     * message : VV V
     * pictures :
     * thumbs : [{"eventId":"7691c98d-d4ec-4b06-a51d-dcced00e4268","id":"cf9af6f1-765d-47ac-bb10-f890f4779dc8","time":"2018-01-27 10:06:00","type":"1","user":{"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"},"userId":"90704b00-1853-11e7-9fee-3dc67b13fe13"},{"eventId":"7691c98d-d4ec-4b06-a51d-dcced00e4268","id":"f16dad4e-a6cc-4adb-8810-987ddf229e29","time":"2018-01-27 10:05:58","type":"1","user":{"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"},"userId":"90704b00-1853-11e7-9fee-3dc67b13fe13"},{"eventId":"7691c98d-d4ec-4b06-a51d-dcced00e4268","id":"a36bc526-5da2-404e-aa54-dd0c705cd901","time":"2018-01-27 10:05:50","type":"0","user":{"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"},"userId":"90704b00-1853-11e7-9fee-3dc67b13fe13"},{"eventId":"7691c98d-d4ec-4b06-a51d-dcced00e4268","id":"bddd9588-582a-4419-b37a-53b7ebfd1628","time":"2018-01-27 10:04:27","type":"1","user":{"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"},"userId":"90704b00-1853-11e7-9fee-3dc67b13fe13"},{"eventId":"7691c98d-d4ec-4b06-a51d-dcced00e4268","id":"9b7ea395-058d-41e4-86d6-7b97c7fcc2aa","time":"2018-01-27 10:04:25","type":"0","user":{"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"},"userId":"90704b00-1853-11e7-9fee-3dc67b13fe13"},{"eventId":"7691c98d-d4ec-4b06-a51d-dcced00e4268","id":"d083663d-99d4-4434-80ce-ff4ee654c537","time":"2018-01-25 18:15:01","type":"0","user":{"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"},"userId":"90704b00-1853-11e7-9fee-3dc67b13fe13"}]
     * user : {"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"}
     * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
     */

    private String address;
    private String ctime;
    private int durationHours;
    private String eventType;
    private String id;
    private double lat;
    private int level;
    private double lng;
    private String message;
    private String pictures;
    private UserBean user;
    private String userId;
    private List<CommentsBean> comments;
    private List<ThumbsBean> thumbs;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
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

    public String getLevel() {
        String result = "";
        switch (level){
            case 10:
                result = "注意";
                break;
            case 20:
                result = "较紧急";
                break;
            case 30:
                result = "紧急";
                break;
            case 40:
                result = "危险";
                break;

        }
        return result;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public List<ThumbsBean> getThumbs() {
        return thumbs;
    }

    public void setThumbs(List<ThumbsBean> thumbs) {
        this.thumbs = thumbs;
    }

    public static class UserBean implements Parcelable {
        /**
         * headerImg : /header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg
         * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
         * userName : tannotour
         */

        private String headerImg;
        private String userId;
        private String userName;

        public String getHeaderImg() {
            return headerImg;
        }

        public void setHeaderImg(String headerImg) {
            this.headerImg = headerImg;
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
            dest.writeString(this.headerImg);
            dest.writeString(this.userId);
            dest.writeString(this.userName);
        }

        public UserBean() {
        }

        protected UserBean(Parcel in) {
            this.headerImg = in.readString();
            this.userId = in.readString();
            this.userName = in.readString();
        }

        public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() {
            @Override
            public UserBean createFromParcel(Parcel source) {
                return new UserBean(source);
            }

            @Override
            public UserBean[] newArray(int size) {
                return new UserBean[size];
            }
        };
    }

    public static class CommentsBean implements Parcelable {
        /**
         * ctime : 2018-01-27 10:08:03
         * eventId : 7691c98d-d4ec-4b06-a51d-dcced00e4268
         * id : 300db397-0931-4fe6-8d3e-cc6f27e74d62
         * message : 海关改革个
         * user : {"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"}
         * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
         */

        private String ctime;
        private String eventId;
        private String id;
        private String message;
        private UserBean user;
        private String userId;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.ctime);
            dest.writeString(this.eventId);
            dest.writeString(this.id);
            dest.writeString(this.message);
            dest.writeParcelable(this.user, flags);
            dest.writeString(this.userId);
        }

        public CommentsBean() {
        }

        protected CommentsBean(Parcel in) {
            this.ctime = in.readString();
            this.eventId = in.readString();
            this.id = in.readString();
            this.message = in.readString();
            this.user = in.readParcelable(UserBean.class.getClassLoader());
            this.userId = in.readString();
        }

        public static final Parcelable.Creator<CommentsBean> CREATOR = new Parcelable.Creator<CommentsBean>() {
            @Override
            public CommentsBean createFromParcel(Parcel source) {
                return new CommentsBean(source);
            }

            @Override
            public CommentsBean[] newArray(int size) {
                return new CommentsBean[size];
            }
        };
    }

    public static class ThumbsBean implements Parcelable {
        /**
         * eventId : 7691c98d-d4ec-4b06-a51d-dcced00e4268
         * id : cf9af6f1-765d-47ac-bb10-f890f4779dc8
         * time : 2018-01-27 10:06:00
         * type : 1
         * user : {"headerImg":"/header/a2be4ae7-6e48-468b-9f89-a8552a6bcd2a.jpg","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":"tannotour"}
         * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
         */

        private String eventId;
        private String id;
        private String time;
        private String type;
        private UserBean user;
        private String userId;

        public String getEventId() {
            return eventId;
        }

        public void setEventId(String eventId) {
            this.eventId = eventId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.eventId);
            dest.writeString(this.id);
            dest.writeString(this.time);
            dest.writeString(this.type);
            dest.writeParcelable(this.user, flags);
            dest.writeString(this.userId);
        }

        public ThumbsBean() {
        }

        protected ThumbsBean(Parcel in) {
            this.eventId = in.readString();
            this.id = in.readString();
            this.time = in.readString();
            this.type = in.readString();
            this.user = in.readParcelable(UserBean.class.getClassLoader());
            this.userId = in.readString();
        }

        public static final Parcelable.Creator<ThumbsBean> CREATOR = new Parcelable.Creator<ThumbsBean>() {
            @Override
            public ThumbsBean createFromParcel(Parcel source) {
                return new ThumbsBean(source);
            }

            @Override
            public ThumbsBean[] newArray(int size) {
                return new ThumbsBean[size];
            }
        };
    }




//    private int rawId = -1;
//    private String id = "0";
//    private String userName = "";
//    private String userId = "";
//    private String type = "热点";
//    private String level = "较紧急";
//    private String duration = "2";
//    private String time = "2017-08-29 13:21";
//    private String context = "这是一个现场事件的内容文本，这是一个现场事件的内容文本，这是一个现场事件的内容文本，这是一个现场事件的内容文本。";
//    private List<String> imgs = new LinkedList<>();
//    private String location = "四川省成都市成华区二仙桥东三路1号";
//    private List<CommentsBean> comments = new LinkedList<>();
//    private List<LikeBean> thumbups = new LinkedList<>();
//    private List<LikeBean> thumbdowns = new LinkedList<>();
//
//    public FieldDynamicBean() {
//        imgs.add("http://www.people.com.cn/media/200303/05/NewsMedia_245129.jpg");
//        imgs.add("http://www.people.com.cn/media/200303/05/NewsMedia_245129.jpg");
//        imgs.add("http://www.people.com.cn/media/200303/05/NewsMedia_245129.jpg");
//        imgs.add("http://www.people.com.cn/media/200303/05/NewsMedia_245129.jpg");
//        imgs.add("http://www.people.com.cn/media/200303/05/NewsMedia_245129.jpg");
//        for(int i = 0;i<10;i++){
//            CommentsBean commentsBean = new CommentsBean();
//            commentsBean.message = "我是评论";
//            CommentsBean.UserBean userBean = new CommentsBean.UserBean();
//            userBean.setUserName("小明");
//            commentsBean.setUser(userBean);
//            comments.add(commentsBean);
//            LikeBean likeBean = new LikeBean();
//            likeBean.setCtime("2017-10-21");
//            likeBean.setUserName("小明");
//            thumbups.add(likeBean);
//            thumbdowns.add(likeBean);
//        }
//    }
//
//    public static class CommentsBean {
//        /**
//         * ctime : 2017-04-14 21:11:38
//         * eventId : b41bea72-50b2-4d00-a40e-75a6b7434fbe
//         * id : 3bfcd350-3d44-42ed-b9a1-9d669526ef09
//         * message : 萨达
//         * user : {"headerImg":"","userId":"90704b00-1853-11e7-9fee-3dc67b13fe13","userName":""}
//         * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
//         */
//        private String ctime;
//        private String eventId;
//        private String id;
//        private String message;
//        private UserBean user;
//        private String userId;
//        public String getCtime() {
//            return ctime;
//        }
//        public void setCtime(String ctime) {
//            this.ctime = ctime;
//        }
//        public String getEventId() {
//            return eventId;
//        }
//        public void setEventId(String eventId) {
//            this.eventId = eventId;
//        }
//        public String getId() {
//            return id;
//        }
//        public void setId(String id) {
//            this.id = id;
//        }
//        public String getMessage() {
//            return message;
//        }
//        public void setMessage(String message) {
//            this.message = message;
//        }
//        public UserBean getUser() {
//            return user;
//        }
//        public void setUser(UserBean user) {
//            this.user = user;
//        }
//        public String getUserId() {
//            return userId;
//        }
//        public void setUserId(String userId) {
//            this.userId = userId;
//        }
//        public static class UserBean {
//            /**
//             * headerImg :
//             * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
//             * userName :
//             */
//            private String headerImg;
//            private String userId;
//            private String userName;
//            public String getHeaderImg() {
//                return headerImg;
//            }
//            public void setHeaderImg(String headerImg) {
//                this.headerImg = headerImg;
//            }
//            public String getUserId() {
//                return userId;
//            }
//            public void setUserId(String userId) {
//                this.userId = userId;
//            }
//            public String getUserName() {
//                return userName;
//            }
//            public void setUserName(String userName) {
//                this.userName = userName;
//            }
//        }
//    }
//    public static class LikeBean {
//        /**
//         * ctime : 2017-04-05 16:03:36
//         * headerImg :
//         * postId : 7215b751-45de-4c5a-9bed-b639d46f8430
//         * userId : 90704b00-1853-11e7-9fee-3dc67b13fe13
//         * userName : 18428323819
//         */
//        private String ctime;
//        private String headerImg;
//        private String postId;
//        private String userId;
//        private String userName;
//        public String getCtime() {
//            return ctime;
//        }
//        public void setCtime(String ctime) {
//            this.ctime = ctime;
//        }
//        public String getHeaderImg() {
//            return headerImg;
//        }
//        public void setHeaderImg(String headerImg) {
//            this.headerImg = headerImg;
//        }
//        public String getPostId() {
//            return postId;
//        }
//        public void setPostId(String postId) {
//            this.postId = postId;
//        }
//        public String getUserId() {
//            return userId;
//        }
//        public void setUserId(String userId) {
//            this.userId = userId;
//        }
//        public String getUserName() {
//            return userName;
//        }
//        public void setUserName(String userName) {
//            this.userName = userName;
//        }
//    }
//    public LinkedList<String> getCommentList(){
//        LinkedList<String> list = new LinkedList<>();
//        for (CommentsBean comment : comments) {
//            list.add(comment.getMessage());
//        }
//        return list;
//    }
//    public String getUserId() {
//        return userId;
//    }
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//    public String getUserName() {
//        return userName;
//    }
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//    public String getType() {
//        return type;
//    }
//    public void setType(String type) {
//        this.type = type;
//    }
//    public String getLevel() {
//        return level;
//    }
//    public void setLevel(String level) {
//        this.level = level;
//    }
//    public String getDuration() {
//        return duration;
//    }
//    public void setDuration(String duration) {
//        this.duration = duration;
//    }
//    public String getTime() {
//        return time;
//    }
//    public void setTime(String time) {
//        this.time = time;
//    }
//    public String getContext() {
//        return context;
//    }
//    public void setContext(String context) {
//        this.context = context;
//    }
//    public List<String> getImgs() {
//        return imgs;
//    }
//    public void setImgs(List<String> imgs) {
//        this.imgs = imgs;
//    }
//    public String getLocation() {
//        return location;
//    }
//    public void setLocation(String location) {
//        this.location = location;
//    }
//    public List<CommentsBean> getComments() {
//        return comments;
//    }
//    public void setComments(List<CommentsBean> comments) {
//        this.comments = comments;
//    }
//    public List<LikeBean> getThumbups() {
//        return thumbups;
//    }
//    public void setThumbups(List<LikeBean> thumbups) {
//        this.thumbups = thumbups;
//    }
//    public List<LikeBean> getThumbdowns() {
//        return thumbdowns;
//    }
//    public void setThumbdowns(List<LikeBean> thumbdowns) {
//        this.thumbdowns = thumbdowns;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.address);
        dest.writeString(this.ctime);
        dest.writeInt(this.durationHours);
        dest.writeString(this.eventType);
        dest.writeString(this.id);
        dest.writeDouble(this.lat);
        dest.writeInt(this.level);
        dest.writeDouble(this.lng);
        dest.writeString(this.message);
        dest.writeString(this.pictures);
        dest.writeParcelable(this.user, flags);
        dest.writeString(this.userId);
        dest.writeTypedList(this.comments);
        dest.writeTypedList(this.thumbs);
    }

    protected FieldDynamicBean(Parcel in) {
        this.address = in.readString();
        this.ctime = in.readString();
        this.durationHours = in.readInt();
        this.eventType = in.readString();
        this.id = in.readString();
        this.lat = in.readDouble();
        this.level = in.readInt();
        this.lng = in.readDouble();
        this.message = in.readString();
        this.pictures = in.readString();
        this.user = in.readParcelable(UserBean.class.getClassLoader());
        this.userId = in.readString();
        this.comments = in.createTypedArrayList(CommentsBean.CREATOR);
        this.thumbs = in.createTypedArrayList(ThumbsBean.CREATOR);
    }

    public static final Parcelable.Creator<FieldDynamicBean> CREATOR = new Parcelable.Creator<FieldDynamicBean>() {
        @Override
        public FieldDynamicBean createFromParcel(Parcel source) {
            return new FieldDynamicBean(source);
        }

        @Override
        public FieldDynamicBean[] newArray(int size) {
            return new FieldDynamicBean[size];
        }
    };
}
