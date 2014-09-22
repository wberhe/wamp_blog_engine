/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author priya
 */
@Entity
public class Rating {

    @Id
    @GeneratedValue
    private int id;

    
    private double rate;

    @ManyToOne(cascade =CascadeType.ALL)
    private User user;
    
    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
    public Rating() {
    }

    public Rating(double rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.user != null ? this.user.hashCode() : 0);
        hash = 89 * hash + (this.post != null ? this.post.hashCode() : 0);
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
        final Rating other = (Rating) obj;
        if (this.user != other.user && (this.user == null || !this.user.equals(other.user))) {
            return false;
        }
        if (this.post != other.post && (this.post == null || !this.post.equals(other.post))) {
            return false;
        }
        return true;
    }
    
    

  
}
