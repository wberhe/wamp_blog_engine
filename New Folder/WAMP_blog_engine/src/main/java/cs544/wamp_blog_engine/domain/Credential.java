/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

/**
 *
 * @author priya
 */
@Entity
public class Credential {

    @Id
    @GeneratedValue
    private int id;
    
    //
    //create validation
    @NotBlank
    private String previledge;
    
    @NotBlank
    @SafeHtml
    private String username;

//    (			# Start of group
//  (?=.*\d)		#   must contains one digit from 0-9
//  (?=.*[a-z])		#   must contains one lowercase characters
//  (?=.*[A-Z])		#   must contains one uppercase characters
//  (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
//              .		#     match anything with previous condition checking
//                {6,20}	#        length at least 6 characters and maximum of 20	
//)	
    @NotBlank
    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")
    private String password;

    public Credential() {
    }

    public Credential(String previledge, String username, String password) {
        this.previledge = previledge;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPreviledge() {
        return previledge;
    }

    public void setPreviledge(String previledge) {
        this.previledge = previledge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.previledge != null ? this.previledge.hashCode() : 0);
        hash = 37 * hash + (this.username != null ? this.username.hashCode() : 0);
        hash = 37 * hash + (this.password != null ? this.password.hashCode() : 0);
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
        final Credential other = (Credential) obj;
        if ((this.previledge == null) ? (other.previledge != null) : !this.previledge.equals(other.previledge)) {
            return false;
        }
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        return true;
    }

}
