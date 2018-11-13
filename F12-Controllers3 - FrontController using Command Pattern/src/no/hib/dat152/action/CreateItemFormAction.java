package no.hib.dat152.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * "New item. form" Action object.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class CreateItemFormAction implements Action {

    @Override
    public final void execute(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = ItemDAOMemorySingleton.getInstance().getNextId();
        req.setAttribute("id", id);

        req.getRequestDispatcher("/createitemform.jsp").forward(req, resp);
    }
}
