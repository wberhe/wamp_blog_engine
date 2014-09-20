/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service.impl;

import cs544.wamp_blog_engine.dao.CredentialDAO;
import cs544.wamp_blog_engine.dao.UserDAO;
import cs544.wamp_blog_engine.domain.Credential;
import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.INotificationService;
import cs544.wamp_blog_engine.service.IUserService;
import java.util.List;

/**
 *
 * @author Weldino
 */
public class UserService implements IUserService{
    private UserDAO userDAO;
    private CredentialDAO credentialDAO;
    private INotificationService notificationSevice;
    
    

    public UserService() {
    }

    public UserService(UserDAO userDAO, CredentialDAO credentialDAO, INotificationService notificationSevice) {
        this.userDAO = userDAO;
        this.credentialDAO = credentialDAO;
        this.notificationSevice = notificationSevice;
    }

    

   

    @Override
    public void addUser(User user) {
        
        try{
            this.userDAO.addUser(user);
        }
        catch(Exception e){
            
        }
         
    }

    @Override
    public void updateUserInfo(User user) {
        if(user!=null)
            this.userDAO.updateUser(user);
    }

    @Override
    public void modifyCredential(Credential credential) {
          this.credentialDAO.updateCredential(credential);
        
         
    }

    @Override
    public User getUser(int userId) {
        try{
            User user= this.userDAO.getUser(userId);
            return user;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
         List<User> users=userDAO.getAllUsers();
        return users;
    }

    @Override
    public void notifyBlogger(User user) {
        notificationSevice.notifyBlogger(user);
        
    }

    @Override
    public void contactAdmin() {
         notificationSevice.contactAdmin();
    }
    
}
