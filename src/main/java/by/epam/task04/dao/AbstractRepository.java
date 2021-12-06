package by.epam.task04.dao;

import by.epam.task04.entity.BaseEntity;
import by.epam.task04.entity.builder.Builder;
import by.epam.task04.exception.RepositoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Abstract repository.
 *
 * @param <T> the type parameter
 */
public abstract class AbstractRepository<T extends BaseEntity> implements Repository<T> {

    private final Connection connection;

    /**
     * Instantiates a new Abstract repository.
     *
     * @param connection the connection
     */
    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    /**
     * Execute query list.
     *
     * @param sql     the sql
     * @param builder the builder
     * @param params  the params
     * @return the list
     * @throws RepositoryException the repository exception
     */
    public List<T> executeQuery(String sql, Builder<T> builder, List<Object> params) throws RepositoryException {
        List<T> objects = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            QueryHelper.prepare(preparedStatement, params);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T item = builder.build(resultSet);
                objects.add(item);
            }
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage());
        }
        return objects;
    }

    /**
     * Execute query for single result optional.
     *
     * @param query   the query
     * @param builder the builder
     * @param params  the params
     * @return the optional
     * @throws RepositoryException the repository exception
     */
    public Optional<T> executeQueryForSingleResult(String query, Builder<T> builder, List<Object> params) throws RepositoryException {
        List<T> items = executeQuery(query, builder, params);

        return items.size() == 1 ?
                Optional.of(items.get(0)) :
                Optional.empty();
    }

    public void save(T item) throws RepositoryException {
        try {
            String sql;
            if (item.getId() != null) {
                sql = QueryHelper.makeUpdateQuery(getFields(item), getTableName());
            } else {
                sql = QueryHelper.makeInsertQuery(getFields(item), getTableName());
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            QueryHelper.prepare(preparedStatement, getFields(item));

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage());
        }
    }
}
