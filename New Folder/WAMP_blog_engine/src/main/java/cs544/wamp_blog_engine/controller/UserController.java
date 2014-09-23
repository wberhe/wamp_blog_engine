/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.controller;

import cs544.wamp_blog_engine.domain.Credential;
import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.INotificationService;
import cs544.wamp_blog_engine.service.IUserService;
import cs544.wamp_blog_engine.service.impl.NotificationService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Weldino
 */
@Controller
public class UserController {

    @Resource
    private IUserService userService;
    @Resource
    private INotificationService notificationService;

    /**
     * Displaying the Users
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }

    @RequestMapping(value = "/settings", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("allusers", userService.getAllUsers());
        return "settings";
    }

    /**
     * User detail
     * @param model
     * @param id
     * @return 
     */
    @RequestMapping(value = "/userDetail/{id}", method = RequestMethod.GET)
    public String getUserDetail(Model model, @PathVariable int id) {
        model.addAttribute("userdetail", userService.getUser(id));
        return "userInfo";
    }
    /**
     * Adding the user(Session is used)
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("user") User user, HttpSession session) {
        user.setUserCredential((Credential) session.getAttribute("credential"));
        return "signup";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String add(@Valid User user, BindingResult result, HttpSession session) {
        String view = "redirect:/users";
        System.out.println("userController Add");

        if (!result.hasErrors()) {
            userService.addUser(user);
            session.removeAttribute("credential");
        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println("Error:" + err.getField() + ":" + err.getDefaultMessage());
            }
            view = "addUser";
        }
        return view;
    }

    /**
     * Adding the Credential Note: the default credential role is BLOGGER
     *
     * @param credential
     * @return
     */
    @RequestMapping(value = "/addCredential", method = RequestMethod.GET)
    public String addCredential(@ModelAttribute("credential") Credential credential) {
        credential.setPreviledge("Please don't change");
        return "addCredential";
    }

    @RequestMapping(value = "/addCredential", method = RequestMethod.POST)
    public String addCredential(@Valid Credential credential, BindingResult result, HttpSession session) {
        String view = "redirect:/addUser";
        //dumb fix
        boolean used = userService.checkUserName(credential.getUsername());
        if (used) {
            FieldError f = new FieldError("credential", "username", credential.getUsername(), false, null, null, "Username : " + credential.getUsername() + " already in use");
            result.addError(f);
        }
        if (!result.hasErrors()) {
            credential.setPreviledge("ROLE_BLOGGER");
            credential.setBlocked(false);
            session.setAttribute("credential", credential);
        } else {
            view = "addCredential";
        }
        return view;
    }

    /**
     * Updating the user
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "userDetail";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result, @PathVariable int id, HttpSession session) {
        //System.out.println("Update");
        if (!result.hasErrors()) {
            //System.out.println("done");
            session.setAttribute("user", user);
            userService.updateUserInfo(id, user);
            return "redirect:/users";
        } else {
            for (FieldError err : result.getFieldErrors()) {
                System.out.println(err.getField() + ": " + err.getDefaultMessage());
            }
            System.out.println("err");
            return "userDetail";
        }
    }

    /**
     * Deleting the user
     *
     * @param userId
     * @param operation
     * @return
     */
    @RequestMapping(value = "/users/{id}/{operation}", method = RequestMethod.GET)
    public String EnableDisable(@PathVariable("id") int userId, @PathVariable("operation") String operation) {

        User u = userService.getUser(userId);
        if ("enable".equalsIgnoreCase(operation)) {
            System.out.println("enabled");
            u.getUserCredential().setBlocked(true);
            u.getUserCredential().setUsername(u.getUserCredential().getUsername());
        } else {
            System.out.println("disabled");
            u.getUserCredential().setBlocked(false);
        }
        userService.updateUserInfo(userId, u);
        return "redirect:/users";
    }

    /**
     * Admin notification to bloggers
     * @param model
     * @param text
     * @param ids
     * @return to settings page
     */
    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    public String notifyUsers(Model model, String text, String[] ids) {
        List<User> user = new ArrayList<User>();
        if (ids != null) {
            for (String id : ids) {
                user.add(userService.getUser(Integer.parseInt(id)));
            }
        }
        notificationService.notifyBlogger(user, text);
        model.addAttribute("allusers", userService.getAllUsers());
        return "settings";
    }

}
