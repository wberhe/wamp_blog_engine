/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
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
    
//    private String blogName;

    @NotBlank
    @SafeHtml
    private String body;

    //@Past
    @Temporal(TemporalType.TIMESTAMP)
//    @NotNull
    private Date creation_time;

    private byte[] image;

    @ManyToMany(mappedBy = "catogorizedPosts", cascade = CascadeType.ALL)
    private List<Category> categories;

    @OneToMany(mappedBy = "post")
    private List<Rating> postRatings;

    @OneToMany(mappedBy = "parentPost", cascade = CascadeType.ALL)
    private List<Comment> postComments;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "taggedPosts")
    private List<Tag> postTags;

    @ManyToOne
    private Blog parentBlog;
    
    @Transient
    private String tempComment;

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

    public String getTempComment() {
        return tempComment;
    }

    public void setTempComment(String tempComment) {
        this.tempComment = tempComment;
    }

   
    
    

//    public String getBlogName() {
//        return blogName;
//    }
//
//    public void setBlogName(String blogName) {
//        this.blogName = blogName;
//    }

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

    public void addCategory(Category category) {
        this.categories.add(category);
        category.addPostToCategory(this);
    }

    public void removeCategory(Category category) {
        this.categories.remove(category);
        category.removePostFromCategory(this);
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
        comment.setParentPost(this);
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
        tag.addPost(this);
    }

    public void removeTag(Tag tag) {
        this.postTags.remove(tag);
        tag.removePost(this);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Blog getParentBlog() {
        return parentBlog;
    }

    public void setParentBlog(Blog parentBlog) {
        this.parentBlog = parentBlog;
        //this.blogName = parentBlog.getName();
    }

    private void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    private void setPostRatings(List<Rating> postRatings) {
        this.postRatings = postRatings;
    }

    private void setPostComments(List<Comment> postComments) {
        this.postComments = postComments;
    }

    private void setPostTags(List<Tag> postTags) {
        this.postTags = postTags;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 67 * hash + (this.draft ? 1 : 0);
        hash = 67 * hash + (this.body != null ? this.body.hashCode() : 0);
        hash = 67 * hash + (this.creation_time != null ? this.creation_time.hashCode() : 0);
        hash = 67 * hash + Arrays.hashCode(this.image);
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
        final Post other = (Post) obj;
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if (this.draft != other.draft) {
            return false;
        }
        if ((this.body == null) ? (other.body != null) : !this.body.equals(other.body)) {
            return false;
        }
        if (this.creation_time != other.creation_time && (this.creation_time == null || !this.creation_time.equals(other.creation_time))) {
            return false;
        }
        if (!Arrays.equals(this.image, other.image)) {
            return false;
        }
        return true;
    }

}
