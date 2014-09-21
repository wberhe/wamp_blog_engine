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
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    public IBlogService getBlogService() {
        return blogService;
    }

    public void setBlogService(IBlogService blogService) {
        this.blogService = blogService;
    }

    public IPostService getPostService() {
        return postService;
    }

    public void setPostService(IPostService postService) {
        this.postService = postService;
    }

    //create fake data for test
    //some how get this from context ?
    private Blog blog;
//     private int blogId;
//    public void createBlog(){
//        blog = new Blog();
//        blog.setName("Funday Sunday Blog");
//        blogId = blog.getId();
//    }
    ///

    //create a new post
//    
    @RequestMapping(value = "/postList", method = RequestMethod.GET)
    public String showAllPosts(Model model) {
        System.out.println("in get blog method");
        blog = blogService.getBlog(1);
//        model.addAttribute("parentBlog", blogService.getBlog(blogId));
        model.addAttribute("posts", postService.getAllPublishedPosts(blog));
        System.out.println("num of published posts" + postService.getAllPublishedPosts(blog).size());
        System.out.println("num of draft posts" + postService.getAllDrafts(blog).size());
        return "blog";
    }
//   o

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String createPost(Post post) {
        System.out.println("select cats: " + post.getCategories());
        postService.createPost(post);
        
        blog = blogService.getBlog(1);
        post.setParentBlog(blog);
        blog.addBlogPost(post);

        blogService.modifyBlog(blog);
        postService.modifyPost(post);
        System.out.println("select cats: getTitle" + post.getTitle());
        System.out.println("select cats: " + post.getCategories());
        return "redirect:/postList";
    }
    

    @RequestMapping(value = "/editPost/{id}", method = RequestMethod.GET)
    public String editPostGet(Model model, @PathVariable int id) {
        model.addAttribute("post", postService.getPost(id));
        model.addAttribute("allcategories", postService.getAllCategories());
        model.addAttribute("alltags", postService.getAllTags());
        return "editPost";
    }

    @RequestMapping(value = "/editPost", method = RequestMethod.POST)
    public String editPostPost(Post post) {

        return "redirect:/postList";
    }
    
    @RequestMapping(value = "viewPost/{id}", method = RequestMethod.GET)
    public String viewPost(Model model, @PathVariable int id){
    
        model.addAttribute("post", postService.getPost(id));
        return "post";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String showCreatePost(Model model) {
//,@ModelAttribute("post") Post post
        model.addAttribute("categories", postService.getAllCategories());
        model.addAttribute("tags", postService.getAllTags());
        model.addAttribute("post", new Post());
        return "createPost";
    }
    
    
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "categories", new CustomCollectionEditor(List.class)
          {
            @Override
            protected Object convertElement(Object element)
            {
                Long id = null;

                if(element instanceof String && !((String)element).equals("")){
                    //From the JSP 'element' will be a String
                    try{
                        id = Long.parseLong((String) element);
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                }
                else if(element instanceof Long) {
                    //From the database 'element' will be a Long
                    id = (Long) element;
                }

                return id != null ? employeeService.loadSkillById(id) : null;
            }
          });
    }

}
