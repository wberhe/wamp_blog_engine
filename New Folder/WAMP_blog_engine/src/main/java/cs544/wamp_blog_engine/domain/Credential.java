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

}
