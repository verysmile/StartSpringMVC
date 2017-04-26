package com.chenyufeng.springmvc.dao;

import com.chenyufeng.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * by chenyufeng on 2017/4/26 .
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{

    @Override
    public User findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveUser(User user) {
        persist(user);
    }

    @Override
    public void updateUser(User user) {
        User entity = findById(user.getId());
        if(entity != null) {
            entity.setUsername(user.getUsername());
            entity.setPassword(user.getPassword());
        }
    }

    @Override
    public void deleteUserById(int id) {
        Query query = getSession().createSQLQuery("DELETE FROM USER WHERE id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    @Override
    public User findUserById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (User) criteria.uniqueResult();
    }
}
