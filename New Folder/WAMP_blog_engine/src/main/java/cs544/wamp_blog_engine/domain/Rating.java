/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

    @Range(min = 1, max = 5)
    private int rate;

    @OneToOne
    private User user;
    @OneToOne
    private Post post;
    public Rating() {
    }

    public Rating(int rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
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
