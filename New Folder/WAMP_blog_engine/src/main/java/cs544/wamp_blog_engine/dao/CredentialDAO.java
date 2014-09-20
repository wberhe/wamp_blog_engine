/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.dao;
import cs544.wamp_blog_engine.domain.Credential;
import java.util.List;

/**
 *
 * @author Weldino
 */
public interface CredentialDAO {
    public void createComment(Credential credential);
    public void updateComment(Credential credential);
    public void removeComment(Credential credential);
    public Credential getComment(int credentialid);
    public List<Credential> getAllCredentials();
}
