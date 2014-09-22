/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service.impl;

import cs544.wamp_blog_engine.dao.CommentDAO;
import cs544.wamp_blog_engine.domain.Comment;
import cs544.wamp_blog_engine.domain.Post;
import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.ICommentService;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author priya
 */


public class CommentService implements ICommentService{

    private CommentDAO commentDAO;
            
        public CommentService() {
    }

    public void setCommentDAO(CommentDAO commentDAO) {
        this.commentDAO = commentDAO;
    }
     
    @Transactional(propagation = Propagation.REQUIRED)        
    @Override
    public void addComment(Comment comment, User user, Post post) {
        comment.setComm_time(new Date());
        comment.setCommentAuthor(user);
        comment.setParentPost(post);
        commentDAO.createComment(comment);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Comment> getPostComments(Post post) {
        return commentDAO.getAllPostComments(post);
    }
    
    
}
