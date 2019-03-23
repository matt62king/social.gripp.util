package social.gripp.util.http.validation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import social.gripp.util.http.configuration.HttpHeaderResolver;

@Aspect
@Component
public class HeaderValidatorAspect {

    @Autowired(required = false)
    private HttpHeaderResolver httpHeaderResolver;

    @Around("@annotation(ValidateHeader)")
    public Object validateHeader(ProceedingJoinPoint proceedingJoinPoint, ValidateHeader validateHeader) throws Throwable {
        if (httpHeaderResolver != null && httpHeaderResolver.hasHeader(validateHeader.value())) {
            return proceedingJoinPoint.proceed();
        } else {
            throw new Exception(validateHeader.value() + " is a required header");
        }
    }
}
