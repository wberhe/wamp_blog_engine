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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Weldino
 */
public class TagDAOImpl implements TagDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void addTag(Tag tag) {
        sf.getCurrentSession().save(tag);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void updateTag(Tag tag) {
        sf.getCurrentSession().saveOrUpdate(tag);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void removeTag(Tag tag) {
        sf.getCurrentSession().delete(tag);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Tag getTag(int id) {
        Tag tag = (Tag) sf.getCurrentSession().get(Tag.class, id);
        return tag;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Tag> getAllTags() {

        Query query = sf.getCurrentSession().createQuery("from Tag");
        List<Tag> tags = query.list();
        return tags;
    }

}
