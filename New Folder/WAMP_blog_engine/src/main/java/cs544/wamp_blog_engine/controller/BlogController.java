/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.controller;

import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.service.IBlogService;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MShikder
 */
@Controller
public class BlogController {
    @Resource
    private IBlogService blogerService;
    
    

    @RequestMapping(value="/blog", method=RequestMethod.GET)
    public String getAllBlog(Model model){
        model.addAttribute("blogList", blogerService.getAllBlogs());
        return "blogList";
    }
    
    @RequestMapping(value="/addBlog", method=RequestMethod.GET)
    public String addBlogUI(){
        return "addBlog";
    }
    
    @RequestMapping(value="/blog", method=RequestMethod.POST)
    public String addBlog(Blog blog){
        blogerService.createBlog(blog);
        return "redirect:/blog";
    }
    
    @RequestMapping(value="/blog/{id}", method=RequestMethod.POST)
    public String update(Blog blog, @PathVariable int id) {
        System.out.print("@@@@@@@@@@@@@@@@@@"+blog.getName());
        blogerService.modifyBlog(blog); 
        return "redirect:/blog";
    }
    @RequestMapping(value="/blog/{id}", method=RequestMethod.GET)
    public String getBlogDetail(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogerService.getBlog(id));
	return "blogDetail";
    }
}
