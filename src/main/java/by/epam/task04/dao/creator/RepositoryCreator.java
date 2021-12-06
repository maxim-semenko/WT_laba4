package by.epam.task04.dao.creator;

import by.epam.task04.dao.impl.RoomRepository;
import by.epam.task04.dao.impl.UserRepository;
import by.epam.task04.dao.pool.ConnectionPool;

import java.sql.Connection;

/**
 * The type Repository creator.
 */
public class RepositoryCreator implements AutoCloseable {

    private final ConnectionPool connectionPool;
    private final Connection connection;

    /**
     * Instantiates a new Repository creator.
     */
    public RepositoryCreator() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    /**
     * Gets user repository.
     *
     * @return the user repository
     */
    public UserRepository getUserRepository() {
        return new UserRepository(connection);
    }

    /**
     * Gets room repository.
     *
     * @return the room repository
     */
    public RoomRepository getRoomRepository() {
        return new RoomRepository(connection);
    }

    @Override
    public void close() {
        connectionPool.returnConnection(connection);
    }


}
