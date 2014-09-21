/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.contoller;

import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.service.IBlogService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author aalzamer
 */
@Controller
public class BlogController {
    private IBlogService blogService;

    public IBlogService getBlogService() {
        return blogService;
    }

    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }
    
    @RequestMapping("blogs")
    public String getAllBlogs(Model model){
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "";
    }
    public void createBlog(@Valid Blog blog){
    }
    
}
