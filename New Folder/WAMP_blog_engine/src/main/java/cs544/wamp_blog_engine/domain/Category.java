/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priya
 */
public class Category {

    private int id;
    private String name;

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

}
