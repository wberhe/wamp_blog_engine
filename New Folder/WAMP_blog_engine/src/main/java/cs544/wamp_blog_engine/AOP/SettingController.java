/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.AOP;

import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.service.ISettingService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author aalzamer
 */
@Controller
public class SettingController {
    private ISettingService settingService;

    public ISettingService getSettingService() {
        return settingService;
    }

    public void setSettingService(ISettingService settingService) {
        this.settingService = settingService;
    }
    
//    public String getAllCategories(Model model){
//        model.addAttribute("categories", getSettingService().)
//    }
    
    @RequestMapping(value = "/addBlogCategory",method = RequestMethod.GET)
    public String addBlogCategory(@ModelAttribute("category") Category category){
        return "addBlogCategory";
    }
    @RequestMapping(value = "/addBlogCategory",method = RequestMethod.POST)
    public String addBlogCategory(@Valid Category category,BindingResult result){
        String nextView="settings";
        if(!result.hasErrors()){
            getSettingService().addBlogCategory(category);
            
        }else{
            nextView="addBlogCategory";
        }
        return nextView;
    }
    
}
