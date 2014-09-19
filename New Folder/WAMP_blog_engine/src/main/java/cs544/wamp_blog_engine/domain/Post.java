/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author priya
 */
public class Post {

    private int id;
    private String title;
    private String status;
    private String body;
    private Date creation_time;
    private byte[] image;

    private List<Category> categories;

    private List<Rating> postRatings;

    private List<Comment> postComments;

    private List<Tag> postTags;

    public Post() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category cateegory) {
        this.categories.add(cateegory);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
    }

    public void addPostRating(Rating rating) {
        this.postRatings.add(rating);
    }

    public List<Rating> getPostRatings() {
        return postRatings;
    }

    public List<Comment> getPostComments() {
        return postComments;
    }

    public void addComment(Comment comment) {
        this.postComments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.postComments.remove(comment);
    }

    public List<Tag> getPostTags() {
        return postTags;
    }

    public void addTag(Tag tag) {
        this.postTags.add(tag);
    }

    public void removeTag(Tag tag) {
        this.postTags.remove(tag);
    }
}
