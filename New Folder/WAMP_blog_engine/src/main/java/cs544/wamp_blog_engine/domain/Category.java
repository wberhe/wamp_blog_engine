/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

/**
 *
 * @author priya
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @SafeHtml
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Post> catogorizedPosts;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
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

    public List<Post> getCatogorizedPosts() {
        return catogorizedPosts;
    }

    public void addPost(Post post) {
        this.catogorizedPosts.add(post);
    }

    public void removePost(Post post) {
        this.catogorizedPosts.remove(post);
    }

    public void setId(int id) {
        this.id = id;
    }

//    public void setCatogorizedPosts(List<Post> catogorizedPosts) {
//        this.catogorizedPosts = catogorizedPosts;
//    }
    
    public void addPostToCategory(Post post){
        this.catogorizedPosts.add(post);
    }
    
    public void removePostFromCategory(Post post){
        this.catogorizedPosts.remove(post);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.name != null ? this.name.hashCode() : 0);
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
        final Category other = (Category) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
