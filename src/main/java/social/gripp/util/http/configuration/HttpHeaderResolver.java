package social.gripp.util.http.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import social.gripp.util.http.GrippHttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class HttpHeaderResolver {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public Optional<String> getProjectIdHeader() {
        return Optional.ofNullable(httpServletRequest.getHeader(GrippHttpHeaders.PROJECT_ID_HEADER));
    }
}
