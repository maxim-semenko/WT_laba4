package by.epam.task04.service;

import by.epam.task04.entity.Room;
import by.epam.task04.exception.RepositoryException;
import by.epam.task04.exception.ServiceException;
import by.epam.task04.dao.creator.RepositoryCreator;
import by.epam.task04.dao.impl.RoomRepository;
import by.epam.task04.specification.common.FindById;
import by.epam.task04.specification.room.FindAll;
import by.epam.task04.specification.room.FindFree;

import java.util.List;
import java.util.Optional;

/**
 * The type Room service.
 */
public class RoomService {

    /**
     * Find all list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Room> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindAll());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    /**
     * Find free list.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    public List<Room> findFree() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindFree());
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    /**
     * Save room.
     *
     * @param id         the id
     * @param roomNumber the room number
     * @param occupied   the occupied
     * @throws ServiceException the service exception
     */
    public void saveRoom(Integer id, String roomNumber, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Room room = new Room(id, roomNumber, occupied);
            roomRepository.save(room);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    /**
     * Change status.
     *
     * @param id       the id
     * @param occupied the occupied
     * @throws ServiceException the service exception
     */
    public void changeStatus(Integer id, Boolean occupied) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Optional<Room> room = roomRepository.query(new FindById(id));
            if (room.isPresent()) {
                room.get().setOccupied(occupied);
                roomRepository.save(room.get());
            } else {
                throw new ServiceException("No such room id");
            }
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }
}
