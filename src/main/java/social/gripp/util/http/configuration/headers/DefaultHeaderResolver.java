package social.gripp.util.http.configuration.headers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import social.gripp.util.http.GrippHttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class DefaultHeaderResolver implements HttpHeaderResolver {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Override
    public Optional<String> getProjectIdHeader() {
        return Optional.ofNullable(httpServletRequest.getHeader(GrippHttpHeaders.PROJECT_ID_HEADER));
    }

    @Override
    public Optional<String> getTaskIdHeader() {
        return Optional.ofNullable(httpServletRequest.getHeader(GrippHttpHeaders.TASK_ID_HEADER));
    }

    @Override
    public boolean hasHeader(String header) {
        return httpServletRequest.getHeader(header) != null && !httpServletRequest.getHeader(header).isEmpty();
    }
}
