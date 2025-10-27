package todo_list.domain.enums;

public enum ProblemDetailCustomPropertiesEnum {
    ERRORS("errors");

    private String property;

    private ProblemDetailCustomPropertiesEnum(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }
}
