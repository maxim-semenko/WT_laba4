package by.epam.task04.specification.user;

import by.epam.task04.specification.Specification;

import java.util.Collections;
import java.util.List;

/**
 * The type Find by username.
 */
public class FindByUsername implements Specification {

    private final String username;

    /**
     * Instantiates a new Find by username.
     *
     * @param username the username
     */
    public FindByUsername(String username) {
        this.username = username;
    }

    @Override
    public String toSql() {
        return "WHERE username=?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(username);
    }
}
