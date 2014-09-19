/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author priya
 */

public class Blog {

    private int id;
    private String name;
    private Date creationg_time;
    private String description;
    private String comm_approval;

    private ArrayList<Post> blogPosts;

    public Blog() {
    }

    public Blog(String name, Date creationg_time, String description, String comm_approval, ArrayList<Post> blogPosts) {
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

    public String getComm_approval() {
        return comm_approval;
    }

    public void setComm_approval(String comm_approval) {
        this.comm_approval = comm_approval;
    }

    public ArrayList<Post> getBlogPosts() {
        return blogPosts;
    }

    public void addBlogPost(Post post) {
        this.blogPosts.add(post);
    }

    public void removeBlogPost(Post post) {
        this.blogPosts.remove(post);
    }

}
