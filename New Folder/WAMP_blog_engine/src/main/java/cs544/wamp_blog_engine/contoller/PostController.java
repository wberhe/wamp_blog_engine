/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.contoller;

import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.domain.Post;
import cs544.wamp_blog_engine.service.IBlogService;
import cs544.wamp_blog_engine.service.IPostService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author priya
 */
@Controller
public class PostController {
    
    @Resource
    private IPostService postService;
    @Resource
    private IBlogService blogService;
    
    
   
    
    //create fake data for test
    //some how get this from context ?
     private Blog blog;
     private int blogId;
    public void createBlog(){
        blog = new Blog();
        blog.setName("Funday Sunday Blog");
        blogId = blog.getId();
    }
    ///
    
    //create a new post
    
    
    
    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public String showAllPosts(Model model){
        System.out.println("in get blog method");
        model.addAttribute("parentBlog", blogService.getBlog(blogId));
        model.addAttribute("posts" , postService.getAllPublishedPosts(blog));
        return "blog";
    }
   
    @RequestMapping(value = "/newpost", method = RequestMethod.POST )
    public String createPost(Post post){
        System.out.println("in post posts mothod");
        post.setParentBlog(blog);
   
        postService.createPost(post);
        return "redirect:/post";
    }
    
     @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String showCreatePost(Model model){
        
        createBlog();
        model.addAttribute("blogs", blog);
        return "createPost";
    }
    
   
    
    
    
}
