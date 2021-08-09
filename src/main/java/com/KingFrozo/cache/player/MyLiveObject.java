package com.KingFrozo.cache.player;

import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;

@REntity
public class MyLiveObject {
    @RId
    private String name;
    private String id;
    // private MyOtherObject value;

    public MyLiveObject(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public MyLiveObject() { // MUST HAVE A DEFAULT CONSTRUCTOR FOR RLO TO WORK
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
