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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aalzamer
 */
public class SettingsService implements ISettingsService {
    private CategoryDAO categoryDAO;
    private TagDAO tagDAO;

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public TagDAO getTagDAO() {
        return tagDAO;
    }

    public void setTagDAO(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addBlogCategory(Category category) {
        categoryDAO.createCategory(category);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void modifyBlogCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteBlogCategory(Category category) {
        categoryDAO.removeCategory(category);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addTag(Tag tag) {
        tagDAO.addTag(tag);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void modifyTag(Tag tag) {
        tagDAO.updateTag(tag);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteTag(Tag tag) {
        tagDAO.removeTag(tag);
    }
    
}
