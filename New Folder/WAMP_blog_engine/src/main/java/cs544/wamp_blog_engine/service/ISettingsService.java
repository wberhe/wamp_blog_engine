/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.service;

import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Tag;

/**
 *
 * @author aalzamer
 */
public interface ISettingsService {

    public void addBlogCategory(Category category);

    public void modifyBlogCategory(Category category);

    public void deleteBlogCategory(Category category);

    public void addTag(Tag tag);

    public void modifyTag(Tag  tag);

    public void deleteTag(Tag tag);
    
}
