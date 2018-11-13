package no.hib.dat152.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * "Create item, save form" Action object.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class CreateItemSaveAction implements Action {

    @Override
    public final void execute(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        Double price = 0.0;
        try {
            price = Double.parseDouble(req.getParameter("price"));
        } catch (final NumberFormatException e) {
        }
        final String description = req.getParameter("description");

        final Item newItem = new Item(id, name, price, description);
        ItemDAOMemorySingleton.getInstance().createItem(newItem);

        resp.sendRedirect("viewshoppinglist");
    }

}
