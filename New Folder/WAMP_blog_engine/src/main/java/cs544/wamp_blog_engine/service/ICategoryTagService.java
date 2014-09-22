/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.service;

import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Tag;
import java.util.List;

/**
 *
 * @author aalzamer
 */
public interface ICategoryTagService {
    public void addTag(Tag tag);
    public void updateTag(Tag  tag);
    public void deleteTag(Tag tag);
    public List<Tag> getAllTags();
    public Tag getTag(int tagId);
    public void addCategory(Category category);
    public void updateCategory(Category  category);
    public void deleteCategory(Category category);
    public List<Category> getAllcategories();
    public Category getCategory(int categoryId);
}
