/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao;


import cs544.wamp_blog_engine.domain.LoginHistory;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface LoginHistoryDAO {
    public void addLoginHistory(LoginHistory history);
    public void updateLoginHistory(LoginHistory history);
    public void removeLoginHistory(LoginHistory history);
    public LoginHistory getLoginHistory(int id);
    public List<LoginHistory> getAllLoginHistory();
}
