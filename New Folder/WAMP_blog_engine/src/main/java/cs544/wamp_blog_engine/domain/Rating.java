/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.domain;

/**
 *
 * @author priya
 */
public class Rating {

    private int id;
    private String rate;

    public Rating() {
    }

    public Rating(String rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

}
