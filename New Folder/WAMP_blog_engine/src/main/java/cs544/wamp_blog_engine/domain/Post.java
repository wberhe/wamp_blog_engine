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
import org.hibernate.validator.constraints.SafeHtml;

/**
 *
 * @author priya
 */
@Entity
public class Post {

    @Id
    @GeneratedValue
    private int id;
    
    @NotBlank
    @SafeHtml
    private String title;
    
    private boolean draft;
    
    @NotBlank
    @SafeHtml
    private String body;
    
    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date creation_time;
    
    private byte[] image;

    @ManyToMany(mappedBy = "catogorizedPosts", cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rating> postRatings;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> postComments;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "taggedPosts")
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

    public boolean isDraft() {
        return draft;
    }

    public void setDraft(boolean draft) {
        this.draft = draft;
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
