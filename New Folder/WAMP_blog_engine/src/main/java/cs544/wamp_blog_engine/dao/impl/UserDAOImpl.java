/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.UserDAO;
import cs544.wamp_blog_engine.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Weldino
 */
public class UserDAOImpl implements UserDAO{
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }
    
    

    @Override
    public void addUser(User user) {
         sf.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
         sf.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void removeUser(User user) {
            sf.getCurrentSession().delete(user);
     
    }

    @Override
    public User getUser(int userid) {
        User user=(User) sf.getCurrentSession().get(User.class,userid);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Query query= sf.getCurrentSession().createQuery("from User");
        List<User> users =new ArrayList<User>();
        users=query.list();
        return users;
    }
    
}
