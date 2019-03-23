package social.gripp.util.http.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({DelegatingGrippHttpConfiguration.class})
public @interface EnableGrippHttp {
}
