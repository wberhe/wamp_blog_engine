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

/**
 *
 * @author priya
 */
@Entity
public class Comment {
@Id
@GeneratedValue
    private int id;
    private String comment;
    @Temporal(TemporalType.TIMESTAMP)
    private Date comm_time;
    // todo: adding parent id?
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

}
