package by.epam.task04.controller.command.user;

import by.epam.task04.controller.command.Command;
import by.epam.task04.controller.command.CommandResult;
import by.epam.task04.exception.ServiceException;
import by.epam.task04.service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Make order command.
 */
public class MakeOrderCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=mainPage";
    private static final String ROOM_ID = "roomId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String roomId = request.getParameter(ROOM_ID);

        RoomService roomService = new RoomService();
        roomService.changeStatus(Integer.valueOf(roomId), true);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
