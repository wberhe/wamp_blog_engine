/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.UserDAO;
import cs544.wamp_blog_engine.domain.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Weldino
 */
public class UserDAOImpl implements UserDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void addUser(User user) {
        sf.getCurrentSession().save(user);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void updateUser(User user) {
        sf.getCurrentSession().saveOrUpdate(user);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void removeUser(int id) {
        User u=(User) sf.getCurrentSession().get(User.class, id);
        sf.getCurrentSession().delete(u);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public User getUser(int userid) {
        User user = (User) sf.getCurrentSession().get(User.class, userid);
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<User> getAllUsers() {
        Query query = sf.getCurrentSession().createQuery("from User");
        List<User> users = query.list();
        return users;
    }


}
