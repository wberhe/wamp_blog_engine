/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.service.impl;

import cs544.wamp_blog_engine.domain.Comment;
import cs544.wamp_blog_engine.domain.Post;
import cs544.wamp_blog_engine.domain.User;
import cs544.wamp_blog_engine.service.INotificationService;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author aalzamer
 */
public class NotificationService implements INotificationService {

    private SimpleMailMessage fromAdminTemplate;
    private SimpleMailMessage toAdminTemplate;
    private SimpleMailMessage toFollowersTemplate;
    private SimpleMailMessage toBloggerTemplate;

    private JavaMailSenderImpl javaMailSender;

    public SimpleMailMessage getFromAdminTemplate() {
        return fromAdminTemplate;
    }

    public void setFromAdminTemplate(SimpleMailMessage fromAdminTemplate) {
        this.fromAdminTemplate = fromAdminTemplate;
    }

    public SimpleMailMessage getToAdminTemplate() {
        return toAdminTemplate;
    }

    public void setToAdminTemplate(SimpleMailMessage toAdminTemplate) {
        this.toAdminTemplate = toAdminTemplate;
    }

    public SimpleMailMessage getToFollowersTemplate() {
        return toFollowersTemplate;
    }

    public void setToFollowersTemplate(SimpleMailMessage toFollowersTemplate) {
        this.toFollowersTemplate = toFollowersTemplate;
    }

    public SimpleMailMessage getToBloggerTemplate() {
        return toBloggerTemplate;
    }

    public void setToBloggerTemplate(SimpleMailMessage toBloggerTemplate) {
        this.toBloggerTemplate = toBloggerTemplate;
    }

    public JavaMailSenderImpl getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void notifyFollowers(List<User> followers, Post post) {
        SimpleMailMessage template = getToFollowersTemplate();
        for (User user : followers) {
            String message = String.format(template.getText(), user.getFirstname() + " " + user.getLastname(), post.getTitle(), "Blog Title", post.getCreation_time());
            sendMail(template.getFrom(), user.getEmail(), template.getSubject(), message);
        }
    }

    @Override
    public void notifyBlogger(List<User> users, String message) {
        SimpleMailMessage template = getFromAdminTemplate();
        for (User user : users) {
            String emailMessage = String.format(template.getText(), user.getFirstname() + " " + user.getLastname(), message);
            sendMail(template.getFrom(), user.getEmail(), template.getSubject(), emailMessage);
        }
    }

    @Override
    public void notifyBloggerNewComment(User user, Comment comment) {
        SimpleMailMessage template = getToBloggerTemplate();
        System.out.println( user.getFirstname()+" "+user.getLastname()+":"+comment.getParentPost().getTitle()+":"+comment.getParentPost().getParentBlog().getName()+":"+comment.getComm_time());
            String emailMessage=String.format(template.getText(), user.getFirstname()+" "+user.getLastname(),comment.getParentPost().getTitle(),comment.getParentPost().getParentBlog().getName(),comment.getComm_time());
            sendMail(template.getFrom(), user.getEmail(), template.getSubject(), emailMessage);
    }

    @Override
    public void contactAdmin(User user, String message) {
        SimpleMailMessage template = getToAdminTemplate();
        String emailMessage = String.format(template.getText(),message, user.getFirstname() + " " + user.getLastname());
        sendMail(user.getEmail(), template.getFrom(), template.getSubject(), emailMessage);
    }

    public void sendMail(String fromEmail, String toEmail, String emailSubject, String emailBody) {
//		String fromEmail = emailTemplate.getFrom();
//		String[] toEmail = emailTemplate.getTo();
//        String[] toEmails = new String[]{toEmail};
//		String emailSubject = emailTemplate.getSubject();
//		String emailBody = String.format(emailTemplate.getText(), dear, content);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setSubject(emailSubject);
            helper.setText(emailBody);

            /*
             uncomment the following lines for attachment FileSystemResource
             file = new FileSystemResource("attachment.jpg");
             helper.addAttachment(file.getFilename(), file);
             */
            javaMailSender.send(mimeMessage);
            System.out.println("Mail sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
