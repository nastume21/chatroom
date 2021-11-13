package com.controller;

import org.junit.Test;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/")
public class JoinRoom {
    private RedisTemplate redisTemplate;
    @RequestMapping("/join")
    @Test
    public void joinRoom(String userId,String roomId){
        BoundSetOperations ops = redisTemplate.boundSetOps(roomId);
        ops.add(userId);
        Set members = ops.members();
        for (Object member : members) {
            if(!member.equals(userId)){
                System.out.println(member);
            }else{
                continue;
            }
        }

    }
}
