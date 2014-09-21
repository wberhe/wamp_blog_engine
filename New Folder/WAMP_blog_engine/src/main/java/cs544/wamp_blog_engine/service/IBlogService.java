/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service;

import cs544.wamp_blog_engine.domain.Blog;
import java.util.List;

/**
 *
 * @author aalzamer
 */
public interface IBlogService {
    public void createBlog(Blog blog);
    public void modifyBlog(Blog blog);
    public Blog getBlog(int blogId);
    public List<Blog> getAllBlogs();
    public void removeBlog(Blog blog);
}
