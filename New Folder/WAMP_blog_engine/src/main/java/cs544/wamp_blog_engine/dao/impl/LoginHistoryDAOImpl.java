/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.LoginHistoryDAO;
import cs544.wamp_blog_engine.domain.LoginHistory;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

/**
 *
 * @author Weldino
 */
public class LoginHistoryDAOImpl implements LoginHistoryDAO{
    
    
    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void addLoginHistory(LoginHistory history) {
        sf.getCurrentSession().save(history);
    }

    @Override
    public void updateLoginHistory(LoginHistory history) {
        sf.getCurrentSession().saveOrUpdate(history);
    }

    @Override
    public void removeLoginHistory(LoginHistory history) {
        sf.getCurrentSession().delete(history);
    }

    @Override
    public LoginHistory getLoginHistory(int id) {
        LoginHistory history= (LoginHistory) sf.getCurrentSession().get(LoginHistory.class, id);
        return history;
    }

    @Override
    public List<LoginHistory> getAllLoginHistory() {
        
        Query query= sf.getCurrentSession().createQuery("from LoginHistory");
        List<LoginHistory> historys =new ArrayList<LoginHistory>();
        historys=query.list();
        return historys;
    }
    
}
