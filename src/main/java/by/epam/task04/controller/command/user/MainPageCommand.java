package by.epam.task04.controller.command.user;

import by.epam.task04.controller.command.Command;
import by.epam.task04.controller.command.CommandResult;
import by.epam.task04.entity.Room;
import by.epam.task04.exception.ServiceException;
import by.epam.task04.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * The type Main page command.
 */
public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/makeOrder.jsp";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        List<Room> freeRoomList = roomService.findFree();
        request.setAttribute(ROOM_LIST, freeRoomList);
        return CommandResult.forward(MAIN_PAGE);
    }
}
