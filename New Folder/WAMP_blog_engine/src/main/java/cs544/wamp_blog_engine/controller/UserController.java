/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.controller;


import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.IUserService;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Weldino
 */
@Controller
public class UserController {
    
    
    @Resource
    private IUserService userService;
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAll(Model model) {        
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }
    
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String add(@Valid User user, BindingResult result, RedirectAttributes re) {
        String view = "redirect:/users";
        if (!result.hasErrors()) {
            userService.addUser(user);
        } else {
            view = "addUser";
        }
        return view;
    }
    
    
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String get(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "userDetail";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.POST)
    public String update(@Valid User user, BindingResult result, @PathVariable int id) {
        if (!result.hasErrors()) {
            //carService.update(id, car); 
            return "redirect:/users";
        } else {
            return "userDetail";
        }
    }

    
}
