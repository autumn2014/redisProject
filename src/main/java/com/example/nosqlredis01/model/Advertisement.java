package com.example.nosqlredis01.model;

import java.io.Serializable;
import java.util.List;

public class Advertisement implements Serializable {
    private static final long serialVersionID=1L;
    private int id;
    private String positionCode;
    private int tid;
    private List<AdContent> adContentList;

    public static long getSerialVersionID() {
        return serialVersionID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public List<AdContent> getAdContentList() {
        return adContentList;
    }

    public void setAdContentList(List<AdContent> adContentList) {
        this.adContentList = adContentList;
    }
}
