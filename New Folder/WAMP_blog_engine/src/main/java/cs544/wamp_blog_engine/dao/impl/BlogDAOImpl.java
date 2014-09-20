/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.BlogDAO;
import cs544.wamp_blog_engine.domain.Blog;
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
public class BlogDAOImpl implements BlogDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void createBlog(Blog blog) {
        sf.getCurrentSession().save(blog);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void updateBlog(Blog blog) {
        sf.getCurrentSession().saveOrUpdate(blog);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void removeBlog(Blog blog) {
        sf.getCurrentSession().delete(blog);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Blog getBlog(int blogid) {
        Blog blog = (Blog) sf.getCurrentSession().get(Blog.class, blogid);
        return blog;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Blog> getAllBlogs() {
        Query query = sf.getCurrentSession().createQuery("from Blog");
        List<Blog> blogs = query.list();
        return blogs;
    }

}
