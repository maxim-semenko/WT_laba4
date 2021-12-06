package by.epam.task04.dao;

import by.epam.task04.exception.RepositoryException;
import by.epam.task04.specification.Specification;

import java.util.List;
import java.util.Map;
import java.util.Optional;


/**
 * The interface Repository.
 *
 * @param <T> the type parameter
 */
public interface Repository<T> {


    /**
     * Query optional.
     *
     * @param specification the specification
     * @return the optional
     * @throws RepositoryException the repository exception
     */
    Optional<T> query(Specification specification) throws RepositoryException;


    /**
     * Query all list.
     *
     * @param specification the specification
     * @return the list
     * @throws RepositoryException the repository exception
     */
    List<T> queryAll(Specification specification) throws RepositoryException;


    /**
     * Save.
     *
     * @param item the item
     * @throws RepositoryException the repository exception
     */
    void save(T item) throws RepositoryException;

    /**
     * Gets table name.
     *
     * @return the table name
     */
    String getTableName();


    /**
     * Gets fields.
     *
     * @param item the item
     * @return the fields
     */
    Map<String, Object> getFields(T item);
}
