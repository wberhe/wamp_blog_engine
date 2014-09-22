/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.validators;

import cs544.wamp_blog_engine.service.IUserService;
import cs544.wamp_blog_engine.validators.annotations.UniqueUserName;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Weldino
 */
public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    private  IUserService UserService;
  @Override
    public void initialize(UniqueUserName constraintAnnotation) {
    }

    public UniqueUserNameValidator() {
//        Thread.dumpStack();
    }
    

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        System.out.println("Unique:"+ value+":"+UserService);
      
        boolean result= !UserService.checkUserName(value);
        System.out.println("result: " + result);
        return result;
    }

}
