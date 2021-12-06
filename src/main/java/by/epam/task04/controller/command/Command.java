package by.epam.task04.controller.command;

import by.epam.task04.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The interface Command.
 */
public interface Command {
    /**
     * Execute command result.
     *
     * @param request  the request
     * @param response the response
     * @return the command result
     * @throws ServiceException the service exception
     */
    CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}
