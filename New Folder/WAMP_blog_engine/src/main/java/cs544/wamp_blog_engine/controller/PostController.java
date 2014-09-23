/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.controller;

import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Comment;
import cs544.wamp_blog_engine.domain.Post;
import cs544.wamp_blog_engine.domain.Rating;
import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.IBlogService;
import cs544.wamp_blog_engine.service.ICategoryTagService;
import cs544.wamp_blog_engine.service.ICommentService;
import cs544.wamp_blog_engine.service.INotificationService;
import cs544.wamp_blog_engine.service.IPostService;
import cs544.wamp_blog_engine.service.IUserService;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Resource
    private ICategoryTagService categoryTagService;

    @Resource
    private IUserService userService;

    @Resource
    private ICommentService commentService;

    @Resource
    private INotificationService notificationService;

    public INotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(INotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public ICommentService getCommentService() {
        return commentService;
    }

    public void setCommentService(ICommentService commentService) {
        this.commentService = commentService;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public ICategoryTagService getCategoryTagService() {
        return categoryTagService;
    }

    public void setCategoryTagService(ICategoryTagService categoryTagService) {
        this.categoryTagService = categoryTagService;
    }

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
//    private Blog blog;
//
//    public void createBlog() {
//        blog = new Blog();
//        blog.setName("Funday Sunday Blog");
//        blogService.createBlog(blog);
//
//    }
//    public User createUser(){
//        User user = new User();
//        user.setFirstname("Sherlock");
//        user.setLastname("Holmes");
//        user.setDob(new Date(1970 , 3, 11));
//        user.setUserCredential(new Credential("Blogger", "username", "password1234!@"));
//        userService.addUser(user);
//        return user;
//    }
    ///
    //create a new post
//    
    @RequestMapping(value = "/postList/{id}", method = RequestMethod.GET)
    public String showAllPosts(Model model, @PathVariable int id, HttpSession session) {
//        createUser();
        User blogger = (User) session.getAttribute("loggedUser");
        System.out.println("in get blog method");
        Blog blog = blogService.getBlog(id);
        User author = blog.getBlogger();
        model.addAttribute("parentBlog", blogService.getBlog(blog.getId()));
        model.addAttribute("posts", postService.getAllPublishedPosts(blog));
        model.addAttribute("drafts", postService.getAllDrafts(blog));
        model.addAttribute("Blog", blog);
        model.addAttribute("blogger", blogger);
        model.addAttribute("author", author);

        return "blog";
    }
//   o

    @RequestMapping(value = "/newpost/{blogid}", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") Post post, BindingResult result, Model model, @PathVariable int blogid) {
//        createBlog();
        System.out.println("...........in newpost post method");
        System.out.println("select cats: " + post.getCategories());
//        req.getParameterValues(null)
        Blog blog = blogService.getBlog(blogid);
        post.setParentBlog(blog);
        blog.addBlogPost(post);

//        System.out.println("does this display?: " + post.getSelectedCat());
        postService.createPost(post);
        System.out.println("post id: " + post.getId());
        blogService.modifyBlog(blog);
//        postService.modifyPost(post);
        model.addAttribute("Blog", blog);
        System.out.println("select cats: getTitle: " + post.getTitle());
        System.out.println("select cats: " + postService.getPost(post.getId()).getCategories());
        return "redirect:/postList/{blogid}";
    }

    @RequestMapping(value = "/newpost/{id}", method = RequestMethod.GET)
    public String showCreatePost(@ModelAttribute("post") Post post, Model model, @PathVariable int id) {
        Blog blog = blogService.getBlog(id);
        System.out.println("in the get new post method");
        model.addAttribute("allCategories", postService.getAllCategories());
        model.addAttribute("tags", postService.getAllTags());
        model.addAttribute("post", new Post());
        model.addAttribute("Blog", blog);
        return "createPost";
    }

    @RequestMapping(value = "editPost/{id}", method = RequestMethod.GET)
    public String editPostGet(Model model, @PathVariable int id) {
        model.addAttribute("post", postService.getPost(id));
        model.addAttribute("allcategories", postService.getAllCategories());
        model.addAttribute("alltags", postService.getAllTags());
        Post post = postService.getPost(id);
        Blog mBlog = post.getParentBlog();
        model.addAttribute("blog", mBlog);
        return "editPost";
    }

    @RequestMapping(value = "editPost/{id}", method = RequestMethod.POST)
    public String editPostPost(Post post, Model model, @PathVariable int id, HttpSession session) {
        System.out.println(".........in editPostPost");
//        User user = (User) session.getAttribute("loggedUser");
        Post modifiedPost = postService.getPost(id);
        modifiedPost.setTitle(post.getTitle());
        modifiedPost.setBody(post.getBody());
        modifiedPost.setDraft(post.isDraft());
        postService.modifyPost(modifiedPost);
        Blog mBlog = modifiedPost.getParentBlog();
        //blogService.modifyBlog(postService.getPost(id).getParentBlog());

        model.addAttribute("post", post);
        model.addAttribute("blog", mBlog);
        return "post";
    }

    @RequestMapping(value = "deletePost/{id}", method = RequestMethod.GET)
    public String deletePost(Model model, @PathVariable int id, RedirectAttributes redattr) {
        Post post = postService.getPost(id);
        int blogId = post.getParentBlog().getId();
        System.out.println("post title: " + post.getTitle());
        Blog blogn = blogService.getBlog(1);
        System.out.println("blog title: " + blogn.getName());
        blogn.removeBlogPost(post);
        blogService.modifyBlog(blogn);
        postService.deletePost(post);
        redattr.addAttribute("id", blogId);
        return "redirect:/postList/{id}";
    }

    @RequestMapping(value = "viewPost/{id}", method = RequestMethod.GET)
    public String viewPost(Model model, @ModelAttribute("post") Post post, @PathVariable int id, HttpSession session) {
        User blogger = (User) session.getAttribute("loggedUser");

        //////////////////////remove hardcoding
//        User blogger = userService.getUser(1);
        Post post2 = postService.getPost(id);
        System.out.println("viewPost: any cats in here?: " + post2.getCategories());
        System.out.println("which post am i viewing?: " + post2.getId());
        System.out.println("from the databse directly: cats: " + categoryTagService.categoriesInPost(post2));
//        post2.setCategories(categoryTagService.categoriesInPost(post2));
        Blog mBlog = post2.getParentBlog();
        Rating rating = postService.getRating(post2);

        if (null != post2.getPostRatings() && post2.getPostRatings().size() >= 1) {

            System.out.println("null check works");
            for (int i = 0; i < post2.getPostRatings().size(); i++) {
                System.out.println("post2.getPostRatings().size(): " + post2.getPostRatings().size());
                System.out.println("post2.getPostRatings().get(i).getUser().getId(): " + post2.getPostRatings().get(i).getUser().getId());
                System.out.println("blogger.getId(): " + blogger.getId());
                if (post2.getPostRatings().get(i).getUser().getId() == blogger.getId()) {
                    blogger.setRatedPost(true);
                }
            }

        }
        List<Category> postCats = categoryTagService.categoriesInPost(post);
        System.out.println("categoriesInPost: " + postCats);
        model.addAttribute("post", post2);
        System.out.println("comnts size: " + post2.getPostComments());
        model.addAttribute("postCategories", categoryTagService.categoriesInPost(post));
        model.addAttribute("comments", commentService.getPostComments(post));
        model.addAttribute("postRating", rating);
        model.addAttribute("blog", mBlog);
        model.addAttribute("blogger", blogger);
        return "post";
    }

    @RequestMapping(value = "viewPost/{id}", method = RequestMethod.POST)
    public String viewPostPost(Model model, @PathVariable int id, @ModelAttribute("post") Post post, RedirectAttributes redattr, HttpSession session) {
//        User user = createUser();
        Post post2 = postService.getPost(id);
        User blogger = (User) session.getAttribute("loggedUser");
        //////////////////////remove hardcoding
//        User blogger = userService.getUser(1);
        model.addAttribute("post", post2);
        Blog mBlog = post2.getParentBlog();
        System.out.println("comment: " + post.getTempComment());
        System.out.println("rating: " + post.getTempRating());
        if (post.getTempRating() != 0) {
            Rating r = new Rating(post.getTempRating());
            r.setUser(blogger);

            postService.addRating(r, post2);

            postService.modifyPost(post2);
        }
        if (post.getTempComment() != null && !post.getTempComment().isEmpty()) {
            Comment comment = new Comment(post.getTempComment(), new Date());

            comment.setCommentAuthor(blogger);
            if (mBlog.isComm_approval()) {
                User author = mBlog.getBlogger();
                System.out.println("author: " + author);
                System.out.println("comment: " + comment);
                comment.setParentPost(post2);
                notificationService.notifyBloggerNewComment(author, comment);
            } else {
                post2.addComment(comment);
                postService.modifyPost(post2);
            }

        }
        int blogId = mBlog.getId();
        redattr.addAttribute("id", post2.getId());
        return "redirect:../viewPost/{id}";
    }

    @RequestMapping(value = "gohome", method = RequestMethod.GET)
    public String showLatestPosts(Model model) {
        System.out.println("inside go home: ");
        List<Post> latestPosts = postService.getLatestPosts();

        model.addAttribute("posts", latestPosts);
        return "gohome";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        System.out.println("fancy thingssss one");
        binder.registerCustomEditor(List.class, "categories", new CustomCollectionEditor(List.class) {

            @Override
            protected Object convertElement(Object element) {
                System.out.println("fancy thingssss");
                Integer id = null;

                if (element instanceof String && !((String) element).equals("")) {
                    //From the JSP 'element' will be a String
                    try {
                        id = Integer.parseInt((String) element);
                    } catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                } else if (element instanceof Integer) {
                    //From the database 'element' will be a Long
                    id = (Integer) element;
                }

                return id != null ? categoryTagService.getCategory(id) : null;
            }
        });
    }

    @InitBinder
    protected void initBinder2(WebDataBinder binder) {
        System.out.println("fancy thingssss two");
        binder.registerCustomEditor(List.class, "postTags", new CustomCollectionEditor(List.class) {

            @Override
            protected Object convertElement(Object element) {
                System.out.println("fancy thingssss");
                Integer id = null;

                if (element instanceof String && !((String) element).equals("")) {
                    //From the JSP 'element' will be a String
                    try {
                        id = Integer.parseInt((String) element);
                    } catch (NumberFormatException e) {
                        System.out.println("Element was " + ((String) element));
                        e.printStackTrace();
                    }
                } else if (element instanceof Integer) {
                    //From the database 'element' will be a Long
                    id = (Integer) element;
                }

                return id != null ? categoryTagService.getTag(id) : null;
            }
        });
    }

}
