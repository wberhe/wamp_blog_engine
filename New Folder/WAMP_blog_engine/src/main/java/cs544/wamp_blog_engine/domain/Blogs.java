/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.domain;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author MShikder
 */
@XmlRootElement(name = "blogs")
public class Blogs {
    
    protected Collection<Blog> blog;

    public Blogs() {
    }
    public Blogs(Collection<Blog> blog) {
    	this.blog = blog;
    }
    
    /**
     * Gets the value of the customer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Customers.Customer }
     * 
     * 
     */
    @XmlElement(name="blog")
    public Collection<Blog> getBlog() {
        if (blog == null) {
            blog = new ArrayList<Blog>();
        }
        return this.blog;
    }
    
    public void setCustomer(Collection<Blog> blog) {
    	this.blog = blog;
    }
    
}
