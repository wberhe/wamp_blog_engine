/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.Date;

/**
 *
 * @author priya
 */
public class LoginHistory {

    private int id;
    private Date login_time;
    private Date logout_time;

    public LoginHistory() {
    }

    public LoginHistory(Date login_time) {
        this.login_time = login_time;
       
    }

    public int getId() {
        return id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }

}
