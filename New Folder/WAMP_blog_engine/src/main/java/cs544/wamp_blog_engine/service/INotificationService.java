/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.service;

import cs544.wamp_blog_engine.domain.User;
import java.util.List;

/**
 *
 * @author priya
 */
public interface INotificationService {

    public void notifyFollowers(List<User> followers);

    public void notifyBlogger(User user);

    public void contactAdmin();

}
