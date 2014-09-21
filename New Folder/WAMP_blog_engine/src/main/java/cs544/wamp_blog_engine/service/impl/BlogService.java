/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service.impl;

import cs544.wamp_blog_engine.dao.BlogDAO;
import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.service.IBlogService;
import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MShikder
 */
public class BlogService implements IBlogService{
    private BlogDAO blogDAO;

    public void setBlogDAO(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void createBlog(Blog blog) {
        blog.setCreationg_time(new Date());
        blog.setComm_approval(true);
        blogDAO.createBlog(blog);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void modifyBlog(Blog blog) {
        blogDAO.updateBlog(blog);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Blog getBlog(int blogId) {
        return blogDAO.getBlog(blogId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Blog> getAllBlogs() {
        return blogDAO.getAllBlogs();
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void removeBlog(Blog blog) {
         blogDAO.removeBlog(blog);
    }
    
    
}
