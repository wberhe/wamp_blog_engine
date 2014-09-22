/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao;
import cs544.wamp_blog_engine.domain.Comment;
import cs544.wamp_blog_engine.domain.Post;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface CommentDAO {
    
    public void createComment(Comment comment);
    public void updateComment(Comment comment);
    public void removeComment(Comment comment);
    public Comment getComment(int commentid);
    public List<Comment> getAllComments();
    public List<Comment> getAllPostComments(Post post);
}
