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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Weldino
 */
public class UserService implements IUserService {

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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addUser(User user) {

        try {
            this.userDAO.addUser(user);
        } catch (Exception e) {
                e.printStackTrace();
        }

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserInfo(int Id, User user) {

        
        User blogger = (User) userDAO.getUser(Id);
        blogger.setFirstname(user.getFirstname());
        blogger.setLastname(user.getLastname());
        blogger.setDob(user.getDob());
        blogger.setEmail(user.getEmail());
        blogger.setProfilepic(user.getProfilepic());
        blogger.getUserCredential().setBlocked(user.getUserCredential().isBlocked());

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void modifyCredential(Credential credential) {
        this.credentialDAO.updateCredential(credential);

    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public User getUser(int userId) {
        try {
            User user = this.userDAO.getUser(userId);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<User> getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void notifyBlogger(List<User> user, String message) {
        notificationSevice.notifyBlogger(user, message);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void contactAdmin(User user, String message) {
        notificationSevice.contactAdmin(user, message);
    }

    public boolean checkUserName(String userName) {
        if(credentialDAO.getCredentialByUserName(userName)!=null){
            return true;
        }
        return false;
    }

    @Override
    public void deleteUser(int id) {
        try{
            userDAO.removeUser(id);
        }catch(Exception e){
            
        }
    }
}
