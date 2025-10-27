package todo_list.domain.enums;

import java.net.URI;

public enum ProblemDetailTypeEnum {
    VALIDATION("https://api.com/errors/validation"),
    NOT_FOUND("https://api.com/errors/not-found"),
    BUSINESS_RULE("https://api.com/errors/business-rule");

    private final String uri;

    ProblemDetailTypeEnum(String uri) {
        this.uri = uri;
    }

    public URI getUri() {
        return URI.create(uri);
    }
}