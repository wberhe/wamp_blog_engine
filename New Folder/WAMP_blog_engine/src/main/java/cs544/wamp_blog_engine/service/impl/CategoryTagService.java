/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service.impl;

import cs544.wamp_blog_engine.dao.CategoryDAO;
import cs544.wamp_blog_engine.dao.TagDAO;
import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Tag;
import cs544.wamp_blog_engine.service.ICategoryTagService;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author aalzamer
 */
public class CategoryTagService implements ICategoryTagService{
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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addTag(Tag tag) {
        tagDAO.addTag(tag);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateTag(Tag tag) {
        tagDAO.updateTag(tag);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteTag(Tag tag) {
        tagDAO.removeTag(tag);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Tag> getAllTags() {
        return tagDAO.getAllTags();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addCategory(Category category) {
        categoryDAO.createCategory(category);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateCategory(Category category) {
        categoryDAO.updateCategory(category);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteCategory(Category category) {
        categoryDAO.removeCategory(category);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Category> getAllcategories() {
        return categoryDAO.getAllCategorys();
    }

    @Override
    public Tag getTag(int tagId) {
        return getTagDAO().getTag(tagId);
    }

    @Override
    public Category getCategory(int categoryId) {
        return getCategoryDAO().getCategory(categoryId);
    }
    
}
