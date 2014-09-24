/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.AOP;

import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.impl.NotificationService;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author Weldino
 */
@Aspect
public class EmailAdvice {

    private NotificationService notificationService;

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @AfterReturning(pointcut = "execution(* cs544.wamp_blog_engine.service.impl.UserService.addUser(..))")
    public void signupEmailNotification(JoinPoint jp) {
        User user=(User) jp.getArgs()[0];
        
        System.out.println("Eamilllllllllllllllll Notification");
        String text = "Thank you for becoming our member, enjoy!";
        List<User> users = new ArrayList<User>();
        users.add(user);
        notificationService.notifyBlogger(users, text);
    }
}
