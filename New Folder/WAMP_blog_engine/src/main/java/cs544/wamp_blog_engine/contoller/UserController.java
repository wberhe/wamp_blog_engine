/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.contoller;


import cs544.wamp_blog_engine.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Weldino
 */
@Controller
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "userList";
    }
    
    
    
}
