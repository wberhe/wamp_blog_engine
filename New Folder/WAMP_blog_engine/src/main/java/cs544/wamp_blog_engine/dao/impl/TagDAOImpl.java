/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.TagDAO;
import cs544.wamp_blog_engine.domain.Tag;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Weldino
 */
public class TagDAOImpl implements TagDAO {
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void addTag(Tag tag) {
        sf.getCurrentSession().save(tag);
    }

    @Override
    public void updateTag(Tag tag) {
        sf.getCurrentSession().saveOrUpdate(tag);
    }

    @Override
    public void removeTag(Tag tag) {
        sf.getCurrentSession().delete(tag);
    }

    @Override
    public Tag getTag(int id) {
        Tag tag=(Tag) sf.getCurrentSession().get(Tag.class, id);
        return tag;
    }

    @Override
    public List<Tag> getAllTags() {
        
        Query query= sf.getCurrentSession().createQuery("from Tag");
        List<Tag> tags =new ArrayList<Tag>();
        tags=query.list();
        return tags;
    }
    
}
