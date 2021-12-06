package by.epam.task04.entity;

/**
 * The enum Role.
 */
public enum Role {
    /**
     * User role.
     */
    USER("user"),
    /**
     * Admin role.
     */
    ADMIN("admin");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }
}
