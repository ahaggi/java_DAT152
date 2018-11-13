package no.hib.dat152.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * "View item" Action object.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class ViewItemAction implements Action {

    @Override
    public final void execute(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = req.getParameter("id");
        final Item item = ItemDAOMemorySingleton.getInstance().findItem(id);
        req.setAttribute("item", item);

        req.getRequestDispatcher("/item.jsp").forward(req, resp);
    }

}
