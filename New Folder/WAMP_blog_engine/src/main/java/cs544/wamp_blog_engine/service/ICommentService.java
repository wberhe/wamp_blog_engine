/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service;

import cs544.wamp_blog_engine.domain.Comment;
import cs544.wamp_blog_engine.domain.Post;
import cs544.wamp_blog_engine.domain.User;
import java.util.List;

/**
 *
 * @author priya
 */
public interface ICommentService {
    
    public void addComment(Comment comment, User user, Post post);
    public List<Comment> getPostComments(Post post);
   
    
}
