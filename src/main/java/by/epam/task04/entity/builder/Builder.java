package by.epam.task04.entity.builder;

import by.epam.task04.exception.RepositoryException;

import java.sql.ResultSet;

/**
 * The interface Builder.
 *
 * @param <T> the type parameter
 */
public interface Builder<T> {
    /**
     * Build t.
     *
     * @param resultSet the result set
     * @return the t
     * @throws RepositoryException the repository exception
     */
    T build(ResultSet resultSet) throws RepositoryException;
}
