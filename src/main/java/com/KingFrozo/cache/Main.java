package com.KingFrozo.cache;

import com.KingFrozo.cache.redis.RedisClient;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    }

    public static void writeToFile(String fileName, String text) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(text);
        printWriter.close();
    }



}
