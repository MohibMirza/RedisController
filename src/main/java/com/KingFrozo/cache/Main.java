// REDISSON EXAMPLE GIT REPO: https://github.com/redisson/redisson-examples/blob/master/collections-examples/src/main/java/org/redisson/example/collections/BucketExamples.java
// A GUIDE TO REDISSON: https://www.baeldung.com/redis-redisson

package com.KingFrozo.cache;

import com.KingFrozo.cache.player.MyObject;
import com.KingFrozo.cache.player.PlayerData;
import com.KingFrozo.cache.redis.RedisClient;
import org.redisson.api.RLiveObjectService;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.api.condition.Conditions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class Main {

    private static final int REDIS_PORT = 8998;

//                  <---EXAMPLE CODE--->
//    public static void main(String[] args) throws Exception {
//        Config config = new Config();
//
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//
//        RedissonClient redisson = Redisson.create(config);
//
//        System.out.println(config.toJSON());
//
//        RBucket<String> bucket = redisson.getBucket("Simple Object");
//        bucket.set("This is object value");
//
//        RMap<String, String> map = redisson.getMap("simpleMap");
//        map.put("MapKey", "This is map value");
//
//        String objectValue = bucket.get();
//        System.out.println("stored object value: " + objectValue);
//
//        String mapValue = map.get("MapKey");
//        System.out.println("stored map value: " + mapValue);
//
//        redisson.shutdown();
//    }

    public static void main(String[] args) throws IOException {
        RedisClient redis = new RedisClient("redis://127.0.0.1:6379");
        redis.loadConfig("config.yml");
        redis.start();

        RedissonClient redisson = redis.redisson;

        RLiveObjectService service = redisson.getLiveObjectService();

        service.registerClass(MyObject.class);
        System.out.println("CLASS REGISTERED: " + service.isClassRegistered(MyObject.class));

        MyObject myObj1 = new MyObject("standard3", "yo yoy o");

        MyObject myObj2 = new MyObject("standard4", "yo mama");
        // service.persist(myObj1);
        // service.persist(myObj2);

        MyObject liveObj = service.get(MyObject.class, "standard4");

        System.out.println(liveObj.getValue());
        liveObj.setValue("yooaslfksaf");
        System.out.println(liveObj.getValue());

        MyObject unfound = service.get(MyObject.class, "random");

        if(unfound == null) {
            System.out.println("Not found! Creating new instance...");
            service.persist(new MyObject("random", "tester"));
        }


        redis.shutdown();

    }

    public static void writeToFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(text);
        printWriter.close();
    }



}
