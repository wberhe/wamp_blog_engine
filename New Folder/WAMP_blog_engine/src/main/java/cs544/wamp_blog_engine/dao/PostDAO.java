/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.dao;

import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Post;
import cs544.wamp_blog_engine.domain.Tag;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface PostDAO {

    public void addPost(Post post);

    public void updatePost(Post post);

    public void removePost(Post post);

    public Post getPost(int id);

    public List<Post> getAllPosts();
    
    public List<Post> getPostsByCategory(Category category);
    
    public List<Post> getPostsByTag(Tag tag);
    
    public List<Post> getBlogPostsByCategory(Category category, Blog blog);
    
    public List<Post> getBlogPostsByTag(Tag tag, Blog blog);

    public List<Post> getAllDrafts(Blog blog);

    public List<Post> getAllPublishedPosts(Blog blog);

    public List<Post> getLatestPosts();
    
    
}
