package by.epam.task04.controller;

import by.epam.task04.controller.command.Command;
import by.epam.task04.controller.command.CommandFactory;
import by.epam.task04.controller.command.CommandResult;
import by.epam.task04.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The type Controller.
 */
public class MainController extends HttpServlet {

    private static final String COMMAND = "command";
    private static final String ERROR_PAGE = "/WEB-INF/pages/error/Error500.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    /**
     * Method receives {@link HttpServletRequest} requests and {@link HttpServletResponse} responses.
     * Based on {@link HttpServletRequest} the request, he takes {@link Command} a command parameter
     * and receives it from the {@link CommandFactory} commandFactory,
     * then gives the page for output and forward on it.
     *
     * @param req  {@link HttpServletRequest} request
     * @param resp {@link HttpServletResponse} response
     * @throws ServletException exception
     * @throws IOException      exception
     */
    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter(COMMAND);
        Command command = CommandFactory.getInstance().getCommand(parameter);

        try {
            CommandResult commandResult = command.execute(req, resp);
            String page = commandResult.getPage();
            if (commandResult.isRedirect()) {
                resp.sendRedirect(page);
            } else {
                ServletContext servletContext = getServletContext();
                RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(page);
                requestDispatcher.forward(req, resp);
            }
        } catch (ServiceException e) {
            CommandResult.forward(ERROR_PAGE);
        }
    }
}
