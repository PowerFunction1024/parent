//package com.jadd.controller;
//
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author : _xu_
// * @desc : TODO
// * @date : 2020/3/8
// */
//@RestController("/redis")
//public class TestRedisson {
//
//    /** logger */
//    private static final Logger log = LoggerFactory.getLogger(TestRedisson.class);
//    @Resource
//    private RedissonClient redissonClient;
//    @GetMapping
//    public void create() {
//
//        boolean getLock=false;
//        RLock rLock = redissonClient.getReadWriteLock("sssa").writeLock();
//
//        try {
//            getLock = rLock.tryLock(0, 20, TimeUnit.SECONDS);
//            if (getLock){
//                log.info("获得了分布式锁");
//            }else {
//                log.info("没有获取到分布锁");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (getLock){
//                rLock.unlock();
//                log.info("释放锁");
//            }
//        }
//
//
//    }
//
//}
