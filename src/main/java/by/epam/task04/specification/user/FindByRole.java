package by.epam.task04.specification.user;

import by.epam.task04.entity.Role;
import by.epam.task04.specification.Specification;

import java.util.Collections;
import java.util.List;

/**
 * The type Find by role.
 */
public class FindByRole implements Specification {

    private final Role role;

    /**
     * Instantiates a new Find by role.
     *
     * @param role the role
     */
    public FindByRole(Role role) {
        this.role = role;
    }

    @Override
    public String toSql() {
        return "WHERE role = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(role);
    }
}
