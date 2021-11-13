package com.controller;

import org.junit.Test;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/")
public class LeaveRoom {
    private RedisTemplate redisTemplate;
    @RequestMapping("/leave")
    @Test
    public void leaveRoom(String userId,String roomId){
        BoundSetOperations ops = redisTemplate.boundSetOps(roomId);
        ops.remove(userId);
        Set members = ops.members();
        for (Object member : members) {
            System.out.println(member);
        }

    }
}
