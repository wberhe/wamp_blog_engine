/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao;

import cs544.wamp_blog_engine.domain.Tag;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface TagDAO {

    public void addTag(Tag tag);
    public void updateTag(Tag tag);
    public void removeTag(Tag tag);
    public Tag getTag(int id);
    public List<Tag> getAllTags();
    
}
