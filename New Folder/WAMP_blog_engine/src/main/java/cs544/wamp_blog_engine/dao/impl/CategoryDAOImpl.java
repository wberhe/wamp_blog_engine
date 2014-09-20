/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.CategoryDAO;
import cs544.wamp_blog_engine.domain.Category;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Weldino
 */
public class CategoryDAOImpl implements CategoryDAO{
    
    
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void createCategory(Category category) {
        sf.getCurrentSession().save(category);
    }

    @Override
    public void updateCategory(Category category) {
        sf.getCurrentSession().saveOrUpdate(category);
    }

    @Override
    public void removeCategory(Category category) {
        sf.getCurrentSession().delete(category);
    }

    @Override
    public Category getCategory(int categoryid) {
        Category category=(Category) sf.getCurrentSession().get(Category.class, categoryid);
        return category;
    }

    @Override
    public List<Category> getAllCategorys() {
        Query query= sf.getCurrentSession().createQuery("from Category");
        List<Category> categorys =new ArrayList<Category>();
        categorys=query.list();
        return categorys;
    }
    
}