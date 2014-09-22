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
import cs544.wamp_blog_engine.domain.User;
import java.util.List;

/**
 *
 * @author aalzamer
 */
public interface IPostService {
    public void createPost(Post post);
    public void modifyPost(Post post);
    public void deletePost(Post post);
    public Post getPost(int postId);
    public List<Post> getAllPosts();
    public List<Post> getAllDrafts(Blog blog);
    public List<Post> getAllPublishedPosts(Blog blog);
    public List<Post> getPostsByCategory(Category category);
    public List<Post> getPostsByTag(Tag tag);
    public List<Post> getPostByCategoryInBlog(Category category, Blog blog);
    public List<Post> getPostsByTagInBlog(Tag tag, Blog blog);
    public List<Category> getAllCategories();
    public List<Tag> getAllTags();
    public void addRating(Rating rating, Post post);
    public Rating getRating(Post post);
    public void addComment(Comment comment, Post post, User user);
    public void approveComment(Comment comment, Post post);
    public List<Comment> getAllComments(Post post);
    public void deleteComment(Post post);
    
    
}
