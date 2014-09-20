/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service.impl;

import cs544.wamp_blog_engine.dao.UserDAO;
import cs544.wamp_blog_engine.domain.Credential;
import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.IUserService;
import java.util.List;

/**
 *
 * @author Weldino
 */
public class UserService implements IUserService{
    private UserDAO userDAO;
    
    

    public UserService() {
    }

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void addUser(User user) {
        if(user!=null){
            this.userDAO.addUser(user);
        }
            
    }

    @Override
    public void updateUserInfo(User user) {
        this.userDAO.updateUser(user);
    }

    @Override
    public void modifyCredential(Credential credential) {
         //TODO
    }

    @Override
    public User getUser(int userId) {
         //TODO
        return null;
    }

    @Override
    public List<User> getAllUsers() {
         //TODO
        return null;
    }

    @Override
    public void notifyBlogger(User user) {
        //TODO
    }

    @Override
    public void contactAdmin() {
         //TODO
    }
    
}
