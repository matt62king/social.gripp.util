package social.gripp.util.http.validation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import social.gripp.util.http.configuration.headers.HttpHeaderResolver;

import java.util.Arrays;

@Aspect
public class HeaderValidatorAspect {

    @Autowired(required = false)
    private HttpHeaderResolver defaultHeaderResolver;

    @Around(value = "@annotation(validateHeader)")
    public Object validateHeader(ProceedingJoinPoint proceedingJoinPoint, ValidateHeader validateHeader) throws Throwable {
        if (defaultHeaderResolver != null) {
            boolean hasHeaders = Arrays.asList(validateHeader.value()).stream()
                    .allMatch(defaultHeaderResolver::hasHeader);

            return hasHeaders ? proceedingJoinPoint.proceed() : new RuntimeException("Missing required header(s).");
        } else {
            throw new RuntimeException("Missing required header(s).");
        }
    }
}
