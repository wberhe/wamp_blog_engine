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
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String addBlogUI(@ModelAttribute("blog") Blog blog){
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
        Blog blg = blogerService.getBlog(id);
        blg.setName(blog.getName());
        blg.setDescription(blog.getDescription());
        blogerService.modifyBlog(blg); 
        return "redirect:/blog";
    }
    @RequestMapping(value="/blog/{id}", method=RequestMethod.GET)
    public String getBlogDetail(@PathVariable int id, Model model) {
        System.out.print("!!!!!!!!!!!!!!!!!!!!!!");
        model.addAttribute("blog", blogerService.getBlog(id));
	return "blogDetail";
    }
    @RequestMapping(value="/blog/delete/{id}", method=RequestMethod.GET)
    public String deleteBlog(@PathVariable int id, Model model) {
        System.out.print("@@@@@@@@@@@@@@@@@@ -> Delete Id: "+id);
       blogerService.removeBlog(blogerService.getBlog(id)); 
       return "redirect:/blog";
    }
}
