/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.controller;

import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Tag;
import cs544.wamp_blog_engine.service.ICategoryTagService;
import cs544.wamp_blog_engine.service.ISettingsService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author aalzamer
 */
@Controller
public class SettingsController {

    @Autowired
    private ISettingsService settingService;
    @Autowired
    private ICategoryTagService categoryTagService;

    public ICategoryTagService getCategoryTagService() {
        return categoryTagService;
    }

    public void setCategoryTagService(ICategoryTagService categoryTagService) {
        this.categoryTagService = categoryTagService;
    }

    public ISettingsService getSettingService() {
        return settingService;
    }

    public void setSettingService(ISettingsService settingService) {
        this.settingService = settingService;
    }

//    public String getAllCategories(Model model){
//        model.addAttribute("categories", getSettingService().)
//    }
    @RequestMapping(value = "/allCategories", method = RequestMethod.GET)
    public String getCategories(Model model) {
        model.addAttribute("categories", getCategoryTagService().getAllcategories());
        return "allCategories";
    }

    @RequestMapping(value = "/addBlogCategory", method = RequestMethod.GET)
    public String addBlogCategory(@ModelAttribute("category") Category category) {
        return "addBlogCategory";
    }

    @RequestMapping(value = "/addBlogCategory", method = RequestMethod.POST)
    public String addBlogCategory(@Valid Category category, BindingResult result) {
        String nextView = "redirect:/allCategories";
        if (!result.hasErrors()) {
            getSettingService().addBlogCategory(category);

        } else {
            nextView = "addBlogCategory";
        }
        return nextView;
    }

    @RequestMapping(value = "/deleteCategory/{categoryId}", method = RequestMethod.GET)
    public String deleteBlogCategory(@PathVariable int categoryId) {
        String nextView = "redirect:/allCategories";
        Category category=categoryTagService.getCategory(categoryId);
        categoryTagService.deleteCategory(category);
        return nextView;
    }

    
     @RequestMapping(value = "/allTags", method = RequestMethod.GET)
    public String getTag(Model model) {
        model.addAttribute("tags", getCategoryTagService().getAllTags());
        return "allTags";
    }

    @RequestMapping(value = "/addTag", method = RequestMethod.GET)
    public String addTag(@ModelAttribute("tag") Tag Tag,Model model) {
        List<String> t=new ArrayList<String>();
        t.add("test");
        t.add("test2");
        t.add("test3");
        t.add("test4");
        model.addAttribute("tags",t);
        return "addTag";
    }

    @RequestMapping(value = "/addTag", method = RequestMethod.POST)
    public String addTag(@Valid Tag tag, BindingResult result) {
        String nextView = "redirect:/allTags";
        if (!result.hasErrors()) {
            getSettingService().addTag(tag);

        } else {
            nextView = "addTag";
        }
        return nextView;
    }

    @RequestMapping(value = "/deleteTag/{tagId}", method = RequestMethod.GET)
    public String deleteTag(@PathVariable int tagId) {
        String nextView = "redirect:/allTags";
        Tag tag=categoryTagService.getTag(tagId);
        categoryTagService.deleteTag(tag);
        return nextView;
    }

}
