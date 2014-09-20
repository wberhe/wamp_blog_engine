/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.service;

import cs544.wamp_blog_engine.domain.Credential;
import cs544.wamp_blog_engine.domain.User;
import java.util.List;

/**
 *
 * @author priya
 */
public interface IUserService {

    public void addUser(User user);

    public void updateUserInfo(User user);

    public void modifyCredential(Credential credential);

    public User getUser(int userId);

    public List<User> getAllUsers();

    public void notifyBlogger(User user);

    public void contactAdmin();

}