/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

/**
 *
 * @author priya
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @SafeHtml
    private String firstname;

    @NotBlank
    @SafeHtml
    private String lastname;

    @NotBlank
    @SafeHtml
    @Email
    private String email;

    private boolean blocked;

    @Past
    @Temporal(TemporalType.DATE)
    private Date dob;

    private byte[] profilepic;

    @OneToOne(cascade = CascadeType.ALL)
    private Credential userCredential;

    @OneToMany(cascade = CascadeType.ALL)
    private List<LoginHistory> userLogins;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Blog> userBlogs;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rating> ratings;

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
        this.userBlogs = userBolgs;
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

    public List<LoginHistory> getUserLogins() {
        return userLogins;
    }

    public void addLoginHistory(LoginHistory loginHistory) {
        this.userLogins.add(loginHistory);
    }

    public List<Blog> getUserBlogs() {
        return userBlogs;
    }

    public void addBlog(Blog blog) {
        this.userBlogs.add(blog);
    }

    public void removeBlog(Blog blog) {
        this.userBlogs.remove(blog);
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void addRating(Rating rating) {
        this.ratings.add(rating);
    }

    public void removeRating(Rating rating) {
        this.ratings.remove(rating);
    }

}
