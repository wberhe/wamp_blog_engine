/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author priya
 */
@Entity
public class Rating {

    @Id
    @GeneratedValue
    private int id;

    @Range(min = 1, max = 5)
    private int rate;

    public Rating() {
    }

    public Rating(int rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

}
