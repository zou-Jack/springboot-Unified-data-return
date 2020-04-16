package com.zoutao.web.controller;

import com.zoutao.web.entity.User;
import com.zoutao.web.exception.BaseException;
import com.zoutao.web.response.BaseResponse;
import com.zoutao.web.response.ResponseCode;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;



/**
 * @title: UserController
 * @Description:  8.测试用的Controller
 * 用了一些高并发场景下的类型
 * @Author: ZouTao
 * @Date: 2020/4/15
 */
@BaseResponse
@RestController
@RequestMapping("users")
public class UserController {
    /**
     * 当前ID
     * AtomicInteger 并发下保证原子性
     */
    private AtomicInteger currentId = new AtomicInteger(1);
    /**
     * 用户列表
     * ConcurrentHashMap 并发散列映射表
     * 在并发情况下不能使用HashMap。
     * https://www.jianshu.com/p/d0b37b927c48
     */
    private Map<Integer,User> users = new ConcurrentHashMap<>();

    /**
     * 根据用户ID获取用户
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){

        // 用的是json的containsKey()函数来判断json串中是否存在key
//        if(users.containsKey(userId)){
//            return users.get(userId);
//        }else{
//            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
//        }

        // 测试用的
        if(userId.equals(0)){
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
        if(userId.equals(1)){
            throw new RuntimeException();
        }
        User user=new User();
        user.setId(userId);
        user.setName("test");
        return user;
    }

    /**
     * 列出所有用户
     * @return
     */
    @GetMapping("/allUser")
    public Map<String, List<User>> listAllUsers(){
        System.out.println("进入列出所有用户"+users.values()); ////获取Map的value集合

        User user1 = new User();
        user1.setId(1);
        user1.setName("张三");

        User user2 = new User();
        user2.setId(2);
        user2.setName("李四");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        Map<String, List<User>> map = new HashMap<>();
        map.put("items", list);

        return map;
    }

    /**
     * 新增用户
     * @param user 用户实体
     * @return
     */
    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        System.out.println("进入新增用户"+currentId.getAndIncrement());
        user.setId(currentId.getAndIncrement());
        users.put(user.getId(),user);
        return user;
    }

    /**
     * 更新用户信息
     * @param userId
     * @param user
     * @return
     */
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Integer userId,@RequestBody User user){
        if(users.containsKey(userId)){
           User newUser=users.get(userId);
           newUser.setName(user.getName());
           return newUser;
        }else{
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
    }

    /**
     * 删除用户
     * @param userId 用户ID
     * @return
     */
    @DeleteMapping("/{userId}")
    public User deleteUserById(@PathVariable Integer userId){
        User user=users.remove(userId);
        if(user!=null){
            return user;
        }else{
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
    }
}
