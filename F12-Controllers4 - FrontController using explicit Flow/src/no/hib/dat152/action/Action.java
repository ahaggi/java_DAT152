package no.hib.dat152.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for Action objects.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public interface Action {

    int SUCCESS = 0;

    /**
     * Executes the action.
     *
     * @param req request
     * @param resp response
     * @return result of action
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    int execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

}
