package com.example.nosqlredis01.model;

import java.io.Serializable;

public class Template implements Serializable {
    private static final long serialVersionID=1L;
    private int id;
    private String name,script;

    public static long getSerialVersionID() {
        return serialVersionID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }
}
