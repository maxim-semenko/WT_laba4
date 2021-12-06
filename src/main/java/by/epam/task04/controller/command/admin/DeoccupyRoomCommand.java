package by.epam.task04.controller.command.admin;

import by.epam.task04.controller.command.Command;
import by.epam.task04.controller.command.CommandResult;
import by.epam.task04.entity.Room;
import by.epam.task04.exception.ServiceException;
import by.epam.task04.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The type Deoccupy room command.
 */
public class DeoccupyRoomCommand implements Command {
    private static final String MAIN_PAGE = "controller?command=showRooms";
    private static final String ROOM_LIST = "roomList";
    private static final String ROOM_ID = "roomId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String roomId = request.getParameter(ROOM_ID);

        RoomService roomService = new RoomService();
        roomService.changeStatus(Integer.valueOf(roomId), false);

        List<Room> roomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, roomList);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
