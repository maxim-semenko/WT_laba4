package by.epam.task04.entity.builder;

import by.epam.task04.entity.Room;
import by.epam.task04.exception.RepositoryException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * The type Room builder.
 */
public class RoomBuilder implements Builder<Room> {

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String OCCUPIED = "occupied";

    @Override
    public Room build(ResultSet resultSet) throws RepositoryException {
        try {
            Integer id = resultSet.getInt(ID);
            String roomNumber = resultSet.getString(ROOM_NUMBER);
            Boolean occupied = resultSet.getBoolean(OCCUPIED);

            return new Room(id, roomNumber, occupied);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
