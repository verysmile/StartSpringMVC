package com.chenyufeng.springmvc.service;

import com.chenyufeng.springmvc.dao.UserDao;
import com.chenyufeng.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * by chenyufeng on 2017/4/26 .
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void deleteUserByUsername(String username) {
        userDao.deleteUserByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
