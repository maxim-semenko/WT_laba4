package by.epam.task04.specification.user;

import by.epam.task04.specification.Specification;

import java.util.Arrays;
import java.util.List;

/**
 * The type Find by username and password.
 */
public class FindByUsernameAndPassword implements Specification {

    private final String username;
    private final String password;

    /**
     * Instantiates a new Find by username and password.
     *
     * @param username the username
     * @param password the password
     */
    public FindByUsernameAndPassword(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toSql() {
        return "where username = ? AND password = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(username, password);
    }

}
