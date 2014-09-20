/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.CommentDAO;
import cs544.wamp_blog_engine.domain.Comment;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Weldino
 */
public class CommentDAOImpl implements CommentDAO{
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void createComment(Comment comment) {
        sf.getCurrentSession().save(comment);
    }

    @Override
    public void updateComment(Comment comment) {
        sf.getCurrentSession().saveOrUpdate(comment);
    }

    @Override
    public void removeComment(Comment comment) {
        sf.getCurrentSession().delete(comment);
    }

    @Override
    public Comment getComment(int commentid) {
        Comment comment= (Comment) sf.getCurrentSession().get(Comment.class,commentid);
        return comment;
    }

    @Override
    public List<Comment> getAllComments() {
        
        Query query= sf.getCurrentSession().createQuery("from Comment");
        List<Comment> comments =new ArrayList<Comment>();
        comments=query.list();
        return comments;
    }
    
}
