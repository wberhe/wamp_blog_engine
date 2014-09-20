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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

/**
 *
 * @author priya
 */
@Entity
public class Blog {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @SafeHtml
    private String name;

    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date creationg_time;

    @SafeHtml
    private String description;

    private boolean comm_approval;

    private boolean blocked;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> blogPosts;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy ="follows" )
    private List<User> followers;
    public Blog() {
    }

    public Blog(String name, Date creationg_time, String description, boolean comm_approval, ArrayList<Post> blogPosts) {
        this.name = name;
        this.creationg_time = creationg_time;
        this.description = description;
        this.comm_approval = comm_approval;
        this.blogPosts = blogPosts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationg_time() {
        return creationg_time;
    }

    public void setCreationg_time(Date creationg_time) {
        this.creationg_time = creationg_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComm_approval() {
        return comm_approval;
    }

    public void setComm_approval(boolean comm_approval) {
        this.comm_approval = comm_approval;
    }

    public List<Post> getBlogPosts() {
        return blogPosts;
    }

    public void addBlogPost(Post post) {
        this.blogPosts.add(post);
    }

    public void removeBlogPost(Post post) {
        this.blogPosts.remove(post);
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }
    public void addFollower(User user){
        getFollowers().add(user);
    }
    public void removeFollwoer(User user){
        getFollowers().remove(user);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlogPosts(List<Post> blogPosts) {
        this.blogPosts = blogPosts;
    }

    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 29 * hash + (this.creationg_time != null ? this.creationg_time.hashCode() : 0);
        hash = 29 * hash + (this.description != null ? this.description.hashCode() : 0);
        hash = 29 * hash + (this.comm_approval ? 1 : 0);
        hash = 29 * hash + (this.blocked ? 1 : 0);
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
        final Blog other = (Blog) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.creationg_time != other.creationg_time && (this.creationg_time == null || !this.creationg_time.equals(other.creationg_time))) {
            return false;
        }
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        if (this.comm_approval != other.comm_approval) {
            return false;
        }
        if (this.blocked != other.blocked) {
            return false;
        }
        return true;
    }
    
    
}
