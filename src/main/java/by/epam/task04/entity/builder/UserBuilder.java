package by.epam.task04.entity.builder;

import by.epam.task04.entity.Role;
import by.epam.task04.entity.User;
import by.epam.task04.exception.RepositoryException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type User builder.
 */
public class UserBuilder implements Builder<User> {

    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";

    @Override
    public User build(ResultSet resultSet) throws RepositoryException {
        try {
            Integer id = resultSet.getInt(ID);
            String login = resultSet.getString(USERNAME);
            String password = resultSet.getString(PASSWORD);
            Role role = Role.valueOf(resultSet.getString(ROLE).toUpperCase());

            return new User(id, login, password, role);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
