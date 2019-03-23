package social.gripp.util.http.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import social.gripp.util.http.GrippHttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class HttpHeaderResolver {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public Optional<String> getProjectIdHeader() {
        return Optional.ofNullable(httpServletRequest.getHeader(GrippHttpHeaders.PROJECT_ID_HEADER));
    }

    public boolean hasHeader(String header) {
        return httpServletRequest.getHeader(header) != null && !httpServletRequest.getHeader(header).isEmpty();
    }
}
