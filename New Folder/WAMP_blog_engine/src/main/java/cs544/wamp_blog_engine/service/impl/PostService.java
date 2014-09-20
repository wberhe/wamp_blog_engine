/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.service.impl;

import cs544.wamp_blog_engine.dao.BlogDAO;
import cs544.wamp_blog_engine.dao.CategoryDAO;
import cs544.wamp_blog_engine.dao.PostDAO;
import cs544.wamp_blog_engine.dao.TagDAO;
import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Comment;
import cs544.wamp_blog_engine.domain.Post;
import cs544.wamp_blog_engine.domain.Rating;
import cs544.wamp_blog_engine.domain.Tag;
import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.INotificationService;
import cs544.wamp_blog_engine.service.IPostService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priya
 */
public class PostService implements IPostService {

    private PostDAO postDAO;
    private BlogDAO blogDAO;

    private INotificationService notificationService;

    @Override
    public void createPost(Post post) {
        postDAO.addPost(post);

        post.getParentBlog().addBlogPost(post);

        blogDAO.updateBlog(post.getParentBlog());

        notificationService.notifyFollowers(post.getParentBlog().getFollowers(), post);
    }

    @Override
    public void modifyPost(Post post) {
        postDAO.updatePost(post);

    }

    @Override
    public Post getPost(int postId) {
        return postDAO.getPost(postId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    @Override
    public List<Post> getAllDrafts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getPostsByCategory(Category category) {
        return category.getCatogorizedPosts();
    }

    @Override
    public List<Post> getPostsByTag(Tag tag) {
        return tag.getTaggedPosts();
    }

    @Override
    public void addRating(Rating rating, Post post) {
        post.addPostRating(rating);
        postDAO.updatePost(post);
    }

    @Override
    public double getRating(Post post) {
        double totalRating = 0.0;
        int size = post.getPostRatings().size();
        for (int i = 0; i < size; i++) {
            totalRating += post.getPostRatings().get(i).getRate();
        }

        return totalRating / size;
    }

    @Override
    public void addComment(Comment comment, Post post, User user) {
        if (post.getParentBlog().isComm_approval()) {
            notificationService.notifyBloggerNewComment(post.getParentBlog().getBlogger(), comment);

        } else {

            comment.setApproved(true);
            comment.setCommentAuthor(user);
            post.addComment(comment);
            comment.setParentPost(post);
            postDAO.updatePost(post);
        }

    }

    @Override
    public void approveComment(Comment comment, Post post) {
        comment.setApproved(true);
        post.addComment(comment);
        comment.setParentPost(post);
        postDAO.updatePost(post);
    }

    @Override
    public List<Comment> getAllComments(Post post) {
        List<Comment> approvedComments = new ArrayList<Comment>();
        for (int i = 0; i < post.getPostComments().size(); i++) {
            Comment c = post.getPostComments().get(i);
            if (c.isApproved()) {
                approvedComments.add(c);
            }
        }
        return approvedComments;
    }

    @Override
    public void deleteComment(Post post) {
        post.removeComment(null);
        postDAO.updatePost(post);
    }

    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public void setBlogDAO(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    public void setNotificationService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

}
