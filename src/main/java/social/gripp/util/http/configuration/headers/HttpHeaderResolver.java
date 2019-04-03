package social.gripp.util.http.configuration.headers;

import java.util.Optional;

public interface HttpHeaderResolver {
    Optional<String> getProjectIdHeader();
    Optional<String> getTaskIdHeader();

    boolean hasHeader(String header);
}
