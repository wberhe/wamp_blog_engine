/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.wamp_blog_engine.validators;

import cs544.wamp_blog_engine.domain.Credential;
import cs544.wamp_blog_engine.validators.annotations.FieldMatch;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Credential> {
    private String firstFieldName;
    private String secondFieldName;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(final Credential value, final ConstraintValidatorContext context) {
        try {
            final Object firstObj = value.getPassword();
            final Object secondObj = value.getConfirmpassword();
//            System.out.println("Tesying:"+(firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj)));
            boolean fieldsMatch = firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
            if (false == fieldsMatch) {
                String errorMessage = "Fields do not match"; //change to be property driven

                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(errorMessage).addNode(secondFieldName).addConstraintViolation();

                return false;
            }
            return fieldsMatch;
        } catch (final Exception ignore) {
            // ignore
        }
        return true;
    }
}
