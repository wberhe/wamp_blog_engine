/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao;
import cs544.wamp_blog_engine.domain.Category;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface CategoryDAO {
    
    public void createCategory(Category category);
    public void updateCategory(Category category);
    public void removeCategory(Category category);
    public Category getCategory(int categoryid);
    public List<Category> getAllCategorys();
}
