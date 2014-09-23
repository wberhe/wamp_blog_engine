/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.controller;

import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.IBlogService;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

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
    
    

    @RequestMapping(value="/", method={RequestMethod.GET})
    public String homePage(HttpServletRequest request) {
	return "welcome"; //name of tile defination
    }
//    @RequestMapping(value="/login", method={RequestMethod.GET})
//    public String homePage() {
//	return "login"; //name of tile defination
//    }
    
    @RequestMapping(value="/blog", method=RequestMethod.GET)
    public String getAllBlog(Model model){
        model.addAttribute("blogList", blogerService.getAllBlogs());
        return "blogList";
    }
    
    @RequestMapping(value="/addBlog", method=RequestMethod.GET)
    public String addBlogUI(@ModelAttribute("blog") Blog blog){
    public String addBlog(@Valid Blog blog, BindingResult result){
        if(!result.hasErrors()){
            blogerService.createBlog(blog);
            System.out.println("--------------No Error");
            return "redirect:/blog";
        }else{
            System.out.println("-------------- Error");
            return "addBlog";
        }
    
    @RequestMapping(value="/blog/{id}", method=RequestMethod.POST)
    public String update(Blog blog, @PathVariable int id) {
        System.out.print("@@@@@@@@@@@@@@@@@@"+blog.getName());
            Blog blg = blogerService.getBlog(id);
            blg.setName(blog.getName());
            blg.setDescription(blog.getDescription());
            blogerService.modifyBlog(blg); 
            return "redirect:/blog";
        }else{
            //System.out.println("-------------- Error");
            return "blogDetail";
        }
    }
    
    @RequestMapping(value="/blog/{id}", method=RequestMethod.GET)
    public String getBlogDetail(@ModelAttribute("blog") Blog blog, @PathVariable int id, Model model) {
       // System.out.print("@@@@@@@@@@@@@@@@@@ -> Delete Id: "+id);
       blogerService.removeBlog(blogerService.getBlog(id)); 
       return "redirect:/blog";
    }
    
    @RequestMapping(value="/blog/enable/{id}", method=RequestMethod.GET)
    public String enableBlog(@PathVariable int id, Model model) {
       System.out.print("@@@@@@@@@@@@@@@@@@ -> enable Id: "+id);
       Blog blog = blogerService.getBlog(id);
       blog.setBlocked(false);
       blogerService.modifyBlog(blog); 
       return "redirect:/blog";
    }
    @RequestMapping(value="/blog/disable/{id}", method=RequestMethod.GET)
    public String disableBlog(@PathVariable int id, Model model) {
       System.out.print("@@@@@@@@@@@@@@@@@@ -> disable Id: "+id);
       Blog blog = blogerService.getBlog(id);
       blog.setBlocked(true);
       blogerService.modifyBlog(blog); 
       return "redirect:/blog";
    }
}
