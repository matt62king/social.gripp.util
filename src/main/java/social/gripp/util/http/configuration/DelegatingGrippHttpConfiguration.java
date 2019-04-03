package social.gripp.util.http.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import social.gripp.util.http.configuration.headers.DefaultHeaderResolver;
import social.gripp.util.http.configuration.headers.HttpHeaderResolver;
import social.gripp.util.http.validation.HeaderValidatorAspect;

public class DelegatingGrippHttpConfiguration {

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HttpHeaderResolver createHeaderResolver() {
        return new DefaultHeaderResolver();
    }

    @Bean
    public HeaderValidatorAspect headerValidatorAspect() {
        return new HeaderValidatorAspect();
    }
}
