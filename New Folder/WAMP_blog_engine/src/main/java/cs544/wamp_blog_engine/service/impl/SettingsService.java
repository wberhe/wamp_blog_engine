/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service.impl;

import cs544.wamp_blog_engine.dao.BlogDAO;
import cs544.wamp_blog_engine.dao.CategoryDAO;
import cs544.wamp_blog_engine.dao.TagDAO;
import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Tag;
import cs544.wamp_blog_engine.service.ISettingsService;

/**
 *
 * @author aalzamer
 */
public class SettingsService implements ISettingsService {
    private CategoryDAO categoryDAO;
    private TagDAO tagDAO;
    @Override
    public void addBlogCategory(Category category) {
        categoryDAO.createCategory(category);
    }

    @Override
    public void modifyBlogCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Override
    public void deleteBlogCategory(Category category) {
        categoryDAO.removeCategory(category);
    }

    @Override
    public void addTag(Tag tag) {
        tagDAO.addTag(tag);
    }

    @Override
    public void modifyTag(Tag tag) {
        tagDAO.updateTag(tag);
    }

    @Override
    public void deleteTag(Tag tag) {
        tagDAO.removeTag(tag);
    }
    
}
