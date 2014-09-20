/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao;

import cs544.wamp_blog_engine.domain.Rating;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface RatingDAO {
    public void addRating(Rating rating);
    public void updateRating(Rating rating);
    public void removeRating(Rating rating);
    public Rating getBlog(int id);
    public List<Rating> getAllRatings();
}
