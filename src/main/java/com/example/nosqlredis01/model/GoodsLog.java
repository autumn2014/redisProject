package com.example.nosqlredis01.model;

import java.util.Date;

/**
 * Created by raoxiaokang on 2019/6/14.
 */
public class GoodsLog {
    private String uuid,ip;
    private Date clickDate;
    private int id;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getClickDate() {
        return clickDate;
    }

    public void setClickDate(Date clickDate) {
        this.clickDate = clickDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
