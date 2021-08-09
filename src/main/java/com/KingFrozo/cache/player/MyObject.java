package com.KingFrozo.cache.player;

import org.redisson.api.RLiveObjectService;
import org.redisson.api.RedissonClient;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.api.annotation.RIndex;
import org.redisson.api.condition.Conditions;

import java.util.Collection;

// EXAMPLE OF LIVE OBJECTS (RLO) IN REDISSON
@REntity
public class MyObject {

    @RId
    private String name;

    private String value;

    public MyObject(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public MyObject() {
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }


}


           // LIVE OBJECT EXAMPLE
//    public static void main(String[] args) {
//        RedissonClient redisson = redis.redisson;
//
//        RLiveObjectService service = redisson.getLiveObjectService();
//
//        service.persist(new MyObject());
//
//        Collection<MyObject> objects = service.find(MyObject.class,
//                Conditions.or(Conditions.and(Conditions.eq("field1", "value"), Conditions.lt("field2", 12)),
//                        Conditions.and(Conditions.eq("field1", "value2"), Conditions.gt("field2", 23)),
//                        Conditions.in("field3", 1L, 2L)));
//    }
