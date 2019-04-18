package com.txd.hzj.wujie_backkitchen.Bean;

/**
 * 创建者：Sunzeyu
 * <br>创建时间：上午 10:12 2019/4/18 018
 * <br>功能描述：
 */
public class MyAllChildItemBean {
    private String name;
    private String time;
    private String note;
    private String type;

    @Override
    public String toString() {
        return "MyAllChildItemBean{" +
                "name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", note='" + note + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
