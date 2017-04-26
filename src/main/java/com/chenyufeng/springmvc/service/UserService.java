package com.chenyufeng.springmvc.service;

import com.chenyufeng.springmvc.model.User;

import java.util.List;

/**
 * by chenyufeng on 2017/4/26 .
 */
public interface UserService {

    User findById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    void deleteUserByUsername(String username);

    List<User> findAllUsers();

    User findUserById(int id);

}
