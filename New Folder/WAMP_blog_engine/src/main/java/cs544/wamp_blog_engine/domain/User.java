/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.ArrayList;
import java.util.Date;
import javax.print.DocFlavor;

/**
 *
 * @author priya
 */
public class User {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private Date dob;
    private byte[] profilepic;

    private Credential userCredential;

    private ArrayList<LoginHistory> userLogins;

    private ArrayList<Blog> userBolgs;

    public User() {
    }

    public User(String firstname, String lastname, String email, Date dob, byte[] profilepic, Credential userCredential, ArrayList<LoginHistory> userLogins, ArrayList<Blog> userBolgs) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.profilepic = profilepic;
        this.userCredential = userCredential;
        this.userLogins = userLogins;
        this.userBolgs = userBolgs;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public byte[] getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(byte[] profilepic) {
        this.profilepic = profilepic;
    }

    public Credential getUserCredential() {
        return userCredential;
    }

    public void setUserCredential(Credential userCredential) {
        this.userCredential = userCredential;
    }

    public ArrayList<LoginHistory> getUserLogins() {
        return userLogins;
    }

    public void addLoginHistory(LoginHistory loginHistory) {
        this.userLogins.add(loginHistory);
    }

    public ArrayList<Blog> getUserBolgs() {
        return userBolgs;
    }

    public void addBlog(Blog blog) {
        this.userBolgs.add(blog);
    }

    public void removeBlog(Blog blog) {
        this.userBolgs.remove(blog);
    }
}
