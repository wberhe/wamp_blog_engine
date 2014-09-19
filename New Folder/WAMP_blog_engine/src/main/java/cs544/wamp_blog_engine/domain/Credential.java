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
public class Credential {

    private int id;
    private String previledge;
    private String username;
    private String password;

    public Credential() {
    }

    public Credential(String previledge, String username, String password) {
        this.previledge = previledge;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPreviledge() {
        return previledge;
    }

    public void setPreviledge(String previledge) {
        this.previledge = previledge;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
