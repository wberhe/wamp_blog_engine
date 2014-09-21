/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.dao.impl;

import cs544.wamp_blog_engine.dao.PostDAO;
import cs544.wamp_blog_engine.domain.Blog;
import cs544.wamp_blog_engine.domain.Category;
import cs544.wamp_blog_engine.domain.Post;
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
public class PostDAOImpl implements PostDAO {

    private SessionFactory sf;

    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void addPost(Post post) {
        System.out.println("post dao" + post.getTitle());
        sf.getCurrentSession().save(post);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void updatePost(Post post) {
        sf.getCurrentSession().saveOrUpdate(post);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    @Override
    public void removePost(Post post) {
        sf.getCurrentSession().delete(post);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Post getPost(int id) {
        Post post = (Post) sf.getCurrentSession().get(Post.class, id);
        return post;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Post> getAllPosts() {
        Query query = sf.getCurrentSession().createQuery("from Post");
        List<Post> posts = query.list();
        return posts;
    }

    @Override
    public List<Post> getAllDrafts(Blog blog) {
        Query query = sf.getCurrentSession().createQuery("select p from Post p where p.draft = true AND p.parentBlog = :pblog");
        query.setParameter("pblog", blog);
        List<Post> drafts = query.list();
        return drafts;
    }

    @Override
    public List<Post> getAllPublishedPosts(Blog blog) {
        Query query = sf.getCurrentSession().createQuery("select p from Post p where p.draft = false AND p.parentBlog = :pblog");
        query.setParameter("pblog", blog);
        List<Post> publishedPosts = query.list();
        return publishedPosts;
    }

    @Override
    public List<Post> getLatestPosts() {
        Query query = sf.getCurrentSession().createQuery("SELECT TOP 10 p from Post p ORDER BY p.creation_time DESC");
        List<Post> latestPosts = query.list();
        return latestPosts;
    }

    @Override
    public List<Post> getPostsByCategory(Category category) {
        Query query = sf.getCurrentSession().createQuery("SELECT p from Post p JOIN p.categories c WHERE c.id = :cid ");
        query.setParameter("cid", category.getId());
        List<Post> categorizedPosts = query.list();
        return categorizedPosts;
    }

    @Override
    public List<Post> getPostsByTag(Tag tag) {
        Query query = sf.getCurrentSession().createQuery("SELECT p from Post p join p.postTags t WHERE t.id = :tid");
        query.setParameter("tid", tag.getId());
        List<Post> taggedPosts = query.list();
        return taggedPosts;
    }

    @Override
    public List<Post> getBlogPostsByCategory(Category category, Blog blog) {
        Query query = sf.getCurrentSession().createQuery("SELECT p from Post p JOIN p.categories c join WHERE c.id = :cid and p.parentBlog = :pblog");
        query.setParameter("cid", category.getId());
        query.setParameter("pblog", blog);
        List<Post> blogPostsByCategory = query.list();
        return blogPostsByCategory;
    }

    @Override
    public List<Post> getBlogPostsByTag(Tag tag, Blog blog) {
                Query query = sf.getCurrentSession().createQuery("SELECT p from Post p JOIN p.postTags t join WHERE t.id = :tid and p.parentBlog = :pblog");
                query.setParameter("tid", tag.getId());
                query.setParameter("pblog", blog);
                List<Post> blogPostsByTag = query.list();
                return blogPostsByTag;

    }

}
