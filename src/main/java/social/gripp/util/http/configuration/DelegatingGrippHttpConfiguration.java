package social.gripp.util.http.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import social.gripp.util.http.configuration.headers.HttpHeaderResolvier;
import social.gripp.util.http.validation.HeaderValidatorAspect;

public class DelegatingGrippHttpConfiguration {

    @Autowired
    private HttpHeaderResolvier.Factory httpResolverFactory;

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public HttpHeaderResolvier createHeaderResolver() {
        return httpResolverFactory.createDefault();
    }

    @Bean
    public HeaderValidatorAspect headerValidatorAspect() {
        return new HeaderValidatorAspect();
    }
}
