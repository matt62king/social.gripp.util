package social.gripp.util.http.configuration.headers;

import java.util.Optional;

public interface HttpHeaderResolvier {
    Optional<String> getProjectIdHeader();
    Optional<String> getTaskIdHeader();

    boolean hasHeader(String header);

    interface Factory {
        default HttpHeaderResolvier createDefault() {
            return new DefaultHeaderResolver();
        }
    }
}
