package no.hib.dat152.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * "Create item. form" Action object.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class CreateItemFormAction implements Action {

    @Override
    public final int execute(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = ItemDAOMemorySingleton.getInstance().getNextId();
        req.setAttribute("id", id);

        return Action.SUCCESS;
    }
}
