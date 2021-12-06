package by.epam.task04.specification.room;

import by.epam.task04.specification.Specification;

import java.util.Collections;
import java.util.List;

/**
 * The type Find free.
 */
public class FindFree implements Specification {

    /**
     * Instantiates a new Find free.
     */
    public FindFree() {
    }

    @Override
    public String toSql() {
        return "WHERE occupied = 'false'";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.emptyList();
    }
}
