package by.epam.task04.entity;

import java.util.Objects;

/**
 * The type Room.
 */
public class Room implements BaseEntity {

    private Integer id;
    private String roomNumber;
    private Boolean occupied;

    /**
     * Instantiates a new Room.
     *
     * @param id         the id
     * @param roomNumber the room number
     * @param occupied   the occupied
     */
    public Room(Integer id, String roomNumber, Boolean occupied) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.occupied = occupied;
    }

    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets room number.
     *
     * @return the room number
     */
    public String getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets room number.
     *
     * @param roomNumber the room number
     */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Gets occupied.
     *
     * @return the occupied
     */
    public Boolean getOccupied() {
        return occupied;
    }

    /**
     * Sets occupied.
     *
     * @param occupied the occupied
     */
    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id.equals(room.id) && roomNumber.equals(room.roomNumber) && occupied.equals(room.occupied);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, occupied);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber='" + roomNumber + '\'' +
                ", occupied=" + occupied +
                '}';
    }
}
