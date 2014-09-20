/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao;

import cs544.wamp_blog_engine.domain.Blog;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface BlogDAO {
    public void createBlog(Blog blog);
    public void updateBlog(Blog blog);
    public void removeBlog(Blog blog);
    public Blog getBlog(int blogid);
    public List<Blog> getAllBlogs();
}
