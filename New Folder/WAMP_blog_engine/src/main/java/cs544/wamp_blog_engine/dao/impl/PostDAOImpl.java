/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.PostDAO;
import cs544.wamp_blog_engine.domain.Post;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Weldino
 */
public class PostDAOImpl implements PostDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void addPost(Post post) {
        sf.getCurrentSession().save(post);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void updatePost(Post post) {
        sf.getCurrentSession().saveOrUpdate(post);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void removePost(Post post) {
        sf.getCurrentSession().delete(post);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Post getPost(int id) {
        Post post = (Post) sf.getCurrentSession().get(Post.class, id);
        return post;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Post> getAllPosts() {
        Query query = sf.getCurrentSession().createQuery("from Post");
        List<Post> posts = query.list();
        return posts;
    }

}
