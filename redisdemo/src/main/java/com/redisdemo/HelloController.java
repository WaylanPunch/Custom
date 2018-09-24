package com.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class HelloController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/msg")
    public String msg() {
        System.out.println("insert string to redis");
        String value = stringRedisTemplate.opsForValue().get("msg");
        return value;
    }

    @PostMapping("/user")
    public String postUser(@RequestBody User user) {
        System.out.println("insert user to redis");
        redisTemplate.opsForValue().set("user-" + user.getId().toString(), user);
        return "success";
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        System.out.println("get user from redis");
        User user = (User) redisTemplate.opsForValue().get("user-" + id.toString());
        //User user = new User(id, "aa", "123456", "aa@163.com");
        return user;
    }

    @DeleteMapping("/user/{id}")
    public Integer deleteUser(@PathVariable Integer id) {
        System.out.println("delete user from redis");
        redisTemplate.delete("user-" + id.toString());
        //User user = new User(id, "aa", "123456", "aa@163.com");
        return id;
    }

}
