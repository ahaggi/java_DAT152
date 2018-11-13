package no.hib.dat152.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * The "view shoppinglist" Action object.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class ViewShoppinglistAction implements Action {

    @Override
    public final void execute(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final List<Item> items = ItemDAOMemorySingleton.getInstance().findAllItems();
        req.getSession().setAttribute("items", items);

        req.getRequestDispatcher("/shoppinglist.jsp").forward(req, resp);
    }
}
