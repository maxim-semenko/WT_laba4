package by.epam.task04.dao.impl;

import by.epam.task04.entity.Room;
import by.epam.task04.entity.builder.RoomBuilder;
import by.epam.task04.exception.RepositoryException;
import by.epam.task04.dao.AbstractRepository;
import by.epam.task04.specification.Specification;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The type Room repository.
 */
public class RoomRepository extends AbstractRepository<Room> {
    private static final String TABLE_NAME = " `room` ";

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String OCCUPIED = "occupied";

    private static final String SELECT_QUERY = "SELECT * FROM `room` ";

    /**
     * Instantiates a new Room repository.
     *
     * @param connection the connection
     */
    public RoomRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(Room item) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put(ROOM_NUMBER, item.getRoomNumber());
        values.put(OCCUPIED, item.getOccupied());
        values.put(ID, item.getId());

        return values;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<Room> query(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParameters();
        return executeQueryForSingleResult(query, new RoomBuilder(), params);
    }

    @Override
    public List<Room> queryAll(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParameters();
        return executeQuery(query, new RoomBuilder(), params);
    }
}
