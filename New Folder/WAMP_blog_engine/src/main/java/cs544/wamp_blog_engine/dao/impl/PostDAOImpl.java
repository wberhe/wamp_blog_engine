/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.PostDAO;
import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.domain.Post;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Weldino
 */
public class PostDAOImpl implements PostDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void addPost(Post post) {
        sf.getCurrentSession().save(post);
    }

    @Override
    public void updatePost(Post post) {
        sf.getCurrentSession().saveOrUpdate(post);
    }

    @Override
    public void removePost(Post post) {
        sf.getCurrentSession().delete(post);
    }

    @Override
    public Post getPost(int id) {
        Post post = (Post) sf.getCurrentSession().get(Post.class, id);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        Query query = sf.getCurrentSession().createQuery("from Post");
        List<Post> posts = new ArrayList<Post>();
        posts = query.list();
        return posts;
    }

    @Override
    public List<Post> getAllDrafts(Blog blog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getAllPublishedPosts(Blog blog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Post> getLatestPosts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
