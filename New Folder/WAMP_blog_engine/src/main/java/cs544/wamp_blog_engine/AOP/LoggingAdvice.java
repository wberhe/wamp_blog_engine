/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs544.wamp_blog_engine.AOP;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author aalzamer
 */
@Aspect
public class LoggingAdvice {
    private  static Logger log = Logger.getLogger(LoggingAdvice.class);
    @AfterReturning("* cs544.wamp_blog_engine.service.impl.*.*(..)")
    public void logSuccessfulServiceCalls(JoinPoint jp){
        log.info("method:"+jp.getTarget().getClass().getName()+":"+jp.getSignature().getName()+" has returned successfully.");
    }
     
}
