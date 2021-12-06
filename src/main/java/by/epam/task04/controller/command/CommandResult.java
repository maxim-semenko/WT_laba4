package by.epam.task04.controller.command;

/**
 * The type Command result.
 */
public class CommandResult {

    private final String page;
    private final boolean redirect;

    /**
     * Instantiates a new Command result.
     *
     * @param page     the page
     * @param redirect the redirect
     */
    public CommandResult(String page, boolean redirect) {
        this.page = page;
        this.redirect = redirect;
    }

    /**
     * Forward command result.
     *
     * @param page the page
     * @return the command result
     */
    public static CommandResult forward(String page) {
        return new CommandResult(page, false);
    }

    /**
     * Redirect command result.
     *
     * @param page the page
     * @return the command result
     */
    public static CommandResult redirect(String page) {
        return new CommandResult(page, true);
    }

    /**
     * Gets page.
     *
     * @return the page
     */
    public String getPage() {
        return page;
    }

    /**
     * Is redirect boolean.
     *
     * @return the boolean
     */
    public boolean isRedirect() {
        return redirect;
    }
}
