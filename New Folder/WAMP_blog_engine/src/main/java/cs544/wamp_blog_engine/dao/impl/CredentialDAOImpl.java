/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.CredentialDAO;
import cs544.wamp_blog_engine.domain.Credential;
import cs544.wamp_blog_engine.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Weldino
 */
public class CredentialDAOImpl implements CredentialDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void createCredential(Credential credential) {
        sf.getCurrentSession().save(credential);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void updateCredential(Credential credential) {
        sf.getCurrentSession().saveOrUpdate(credential);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void removeCredential(Credential credential) {
        sf.getCurrentSession().delete(credential);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Credential getCredential(int credentialid) {
        Credential cre = (Credential) sf.getCurrentSession().get(Credential.class, credentialid);
        return cre;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Credential> getAllCredentials() {
        Query query = sf.getCurrentSession().createQuery("from Credential");
        List<Credential> credentials = query.list();
        return credentials;
    }

    @Override//getting credential by userName
    public Credential getCredentialByUserName(String userName) {
        Criteria criterea=sf.getCurrentSession().createCriteria(Credential.class); 
        criterea.add(Restrictions.eq("username", userName));
//         Query query= sf.getCurrentSession().createQuery("select distinct c from Credential c where c.username=:u");
//         query.setString("u", userName);
//         List<Credential> credential= query.list();
         List<Credential> credential= criterea.list();
         System.out.println(userName+":Size:"+credential.size());
         return ((credential.size()>0)?credential.get(0):null);
    }
}
