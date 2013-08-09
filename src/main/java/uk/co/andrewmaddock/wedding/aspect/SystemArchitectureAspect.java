package uk.co.andrewmaddock.wedding.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * System architecture pointcut expressions.
 *
 * @author Andrew Maddock
 *         Date: 06/08/13 16:13
 */
@Component
@Aspect
public class SystemArchitectureAspect {

    @Pointcut(value = "within(uk.co.andrewmaddock.wedding.mvc..*)")
    public void inMvcLayer() { }

    @Pointcut(value = "within(uk.co.andrewmaddock.wedding.service..*)")
    public void inServiceLayer() { }

    @Pointcut(value = "within(uk.co.andrewmaddock.wedding.repository..*)")
    public void inRepositoryLayer() { }

    @Pointcut("execution(* *(..))")
    public void publicMethod() { }    
    
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMappingAnnotation() { }
    
    @Pointcut(value = "inMvcLayer() && publicMethod() && requestMappingAnnotation()")
    public void mvcOperation() { }
    
    @Pointcut(value = "inServiceLayer() && publicMethod()")
    public void serviceOperation() { }
    
    @Pointcut(value = "inRepositoryLayer() && publicMethod()")
    public void repositoryOperation() { }
  
}
