package com.txd.hzj.wujie_backkitchen.Bean;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：下午 04:31 2019/4/19 019
 * <br>功能描述：
 */
public class TimeLineDate {
    private String userIcon;
    private String message;
    private String time;

    public TimeLineDate(String userIcon, String message, String time) {
        this.userIcon = userIcon;
        this.message = message;
        this.time = time;
    }

    @Override
    public String toString() {
        return "TimeLineDate{" +
                "userIcon='" + userIcon + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
