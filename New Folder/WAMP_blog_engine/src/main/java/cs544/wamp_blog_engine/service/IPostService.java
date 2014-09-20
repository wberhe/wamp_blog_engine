/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service;

import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Comment;
import cs544.wamp_blog_engine.domain.Post;
import cs544.wamp_blog_engine.domain.Rating;
import cs544.wamp_blog_engine.domain.Tag;
import java.util.List;

/**
 *
 * @author aalzamer
 */
public interface IPostService {
    public void createPost(Post post);
    public void modifyPost(Post post);
    public Post getPost(int postId);
    public List<Post> getAllPosts();
    public List<Post> getPostsByCategory(Category category);
    public List<Post> getPostsByTag(Tag tag);
    public void addRating(Rating rating, Post post);
    public double  getRating(Post post);
    public void addComment(Comment comment, Post post);
    public void approveComment(Comment comment, Post post);
    public void getAllComments();
    public void deleteComment();
    
    
}
