/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao;

import cs544.wamp_blog_engine.domain.User;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface UserDAO {
    public void addUser(User user);
    public void updateUser(User user);
    public void removeUser(User user);
    public User getUser(int userid);
    public List<User> getAllUsers();
}
