package com.KingFrozo.cache.player;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.api.annotation.RIndex;

import java.io.Serializable;

@REntity
public class PlayerData implements Serializable {

    @RIndex
    private String uuid;
    @RIndex
    private String name;
    @RId
    private String inv;
    private String title;


    public PlayerData(String uuid, String name, String inv, String title) {
        this.uuid = uuid;
        this.name = name;
        this.inv = inv;
        this.title = title;
    }

    public String getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getInv() {
        return inv;
    }

    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInv(String inv) {
        this.inv = inv;
    }

    @Override
    public String toString() {
        return "[" + uuid + "]" + " Name: " + name + " | Inv: " + inv;
    }

}
