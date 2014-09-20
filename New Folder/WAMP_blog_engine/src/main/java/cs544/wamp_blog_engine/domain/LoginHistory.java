/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

/**
 *
 * @author priya
 */
@Entity
public class LoginHistory {

    @Id
    @GeneratedValue
    private int id;
    
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date login_time;
    
    //what to do with this when we add remember me feature?
    @Past
    @Temporal(TemporalType.TIMESTAMP)
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

    public void setId(int id) {
        this.id = id;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.login_time != null ? this.login_time.hashCode() : 0);
        hash = 67 * hash + (this.logout_time != null ? this.logout_time.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LoginHistory other = (LoginHistory) obj;
        if (this.login_time != other.login_time && (this.login_time == null || !this.login_time.equals(other.login_time))) {
            return false;
        }
        if (this.logout_time != other.logout_time && (this.logout_time == null || !this.logout_time.equals(other.logout_time))) {
            return false;
        }
        return true;
    }

}
