package by.epam.task04.specification;

import java.util.List;

/**
 * The interface Specification.
 */
public interface Specification {
    /**
     * To sql string.
     *
     * @return the string
     */
    String toSql();

    /**
     * Gets parameters.
     *
     * @return the parameters
     */
    List<Object> getParameters();
}
