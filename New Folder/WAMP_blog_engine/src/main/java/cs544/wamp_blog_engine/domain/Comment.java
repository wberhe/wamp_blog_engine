/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;

/**
 *
 * @author priya
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    @SafeHtml
    private String comment;

    @Past
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date comm_time;

    private boolean approved;

    @OneToOne
    private Comment parentComment;

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public Comment() {
    }

    public Comment(String comment, Date comm_time) {
        this.comment = comment;
        this.comm_time = comm_time;
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getComm_time() {
        return comm_time;
    }

    public void setComm_time(Date comm_time) {
        this.comm_time = comm_time;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.comment != null ? this.comment.hashCode() : 0);
        hash = 29 * hash + (this.comm_time != null ? this.comm_time.hashCode() : 0);
        hash = 29 * hash + (this.approved ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if ((this.comment == null) ? (other.comment != null) : !this.comment.equals(other.comment)) {
            return false;
        }
        if (this.comm_time != other.comm_time && (this.comm_time == null || !this.comm_time.equals(other.comm_time))) {
            return false;
        }
        if (this.approved != other.approved) {
            return false;
        }
        return true;
    }
    
    

}
