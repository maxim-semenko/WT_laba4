package by.epam.task04.controller.command.common;

import by.epam.task04.controller.command.Command;
import by.epam.task04.controller.command.CommandResult;
import by.epam.task04.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Start login command.
 */
public class StartLoginCommand implements Command {

    private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return CommandResult.forward(LOGIN_PAGE);
    }
}
