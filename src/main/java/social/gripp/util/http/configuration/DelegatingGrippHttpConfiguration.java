package social.gripp.util.http.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DelegatingGrippHttpConfiguration {

    @Bean
    public HttpHeaderResolver createHeaderResolver() {
        return  new HttpHeaderResolver();
    }
}
