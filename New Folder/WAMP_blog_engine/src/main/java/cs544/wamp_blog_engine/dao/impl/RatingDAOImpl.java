/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.RatingDAO;
import cs544.wamp_blog_engine.domain.Rating;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Weldino
 */
public class RatingDAOImpl implements RatingDAO{
    
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void addRating(Rating rating) {
        sf.getCurrentSession().save(rating);
    }

    @Override
    public void updateRating(Rating rating) {
        sf.getCurrentSession().saveOrUpdate(rating);
    }

    @Override
    public void removeRatingt(Rating rating) {
        sf.getCurrentSession().delete(rating);
    }

    @Override
    public Rating getBlog(int id) {
        Rating rating = (Rating) sf.getCurrentSession().get(Rating.class, id);
        return rating;
    }

    @Override
    public List<Rating> getAllRatings() {
        Query query= sf.getCurrentSession().createQuery("from Rating");
        List<Rating> rating =new ArrayList<Rating>();
        rating=query.list();
        return rating;
    }
    
}
