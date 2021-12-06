package by.epam.task04.specification.common;

import by.epam.task04.specification.Specification;

import java.util.Collections;
import java.util.List;

/**
 * The type Find by id.
 */
public class FindById implements Specification {

    private final Integer id;

    /**
     * Instantiates a new Find by id.
     *
     * @param id the id
     */
    public FindById(Integer id) {
        this.id = id;
    }

    @Override
    public String toSql() {
        return "where id = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(id);
    }
}
