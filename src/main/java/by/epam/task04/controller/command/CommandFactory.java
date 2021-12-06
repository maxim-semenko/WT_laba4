package by.epam.task04.controller.command;

import by.epam.task04.controller.command.admin.AddRoomCommand;
import by.epam.task04.controller.command.admin.DeoccupyRoomCommand;
import by.epam.task04.controller.command.admin.ShowRoomsCommand;
import by.epam.task04.controller.command.common.ChangeLanguageCommand;
import by.epam.task04.controller.command.common.LogOutCommand;
import by.epam.task04.controller.command.common.LoginCommand;
import by.epam.task04.controller.command.common.SignUpCommand;
import by.epam.task04.controller.command.common.StartLoginCommand;
import by.epam.task04.controller.command.common.StartPageCommand;
import by.epam.task04.controller.command.user.MainPageCommand;
import by.epam.task04.controller.command.user.MakeOrderCommand;

/**
 * The type Command factory.
 */
public class CommandFactory {
    private static final CommandFactory INSTANCE = new CommandFactory();
    private static final String MAIN_PAGE = "mainPage";
    private static final String MAKE_ORDER = "makeOrder";
    private static final String LOGIN = "login";
    private static final String SHOW_ROOMS = "showRooms";
    private static final String CHANGE_LANGUAGE = "changeLanguage";
    private static final String ADD_ROOM = "addRoom";
    private static final String DEOCCUPY_ROOM = "deoccupyRoom";
    private static final String LOG_OUT = "signOut";
    private static final String SIGN_UP = "signUp";
    private static final String START_PAGE = "startPage";
    private static final String START_LOGIN = "startLogin";

    private CommandFactory() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Gets command.
     *
     * @param command the command
     * @return the command
     */
    public Command getCommand(String command) {
        switch (command) {
            case LOGIN:
                return new LoginCommand();
            case SHOW_ROOMS:
                return new ShowRoomsCommand();
            case MAIN_PAGE:
                return new MainPageCommand();
            case CHANGE_LANGUAGE:
                return new ChangeLanguageCommand();
            case ADD_ROOM:
                return new AddRoomCommand();
            case MAKE_ORDER:
                return new MakeOrderCommand();
            case DEOCCUPY_ROOM:
                return new DeoccupyRoomCommand();
            case LOG_OUT:
                return new LogOutCommand();
            case START_PAGE:
                return new StartPageCommand();
            case SIGN_UP:
                return new SignUpCommand();
            case START_LOGIN:
                return new StartLoginCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
