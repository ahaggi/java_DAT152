package no.hib.dat152.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * "Update item, save form" Action object.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class UpdateItemSaveAction implements Action {

    @Override
    public final int execute(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final Double price = Double.parseDouble(req.getParameter("price"));
        final String description = req.getParameter("description");

        final Item updatedItem = new Item(id, name, price, description);
        ItemDAOMemorySingleton.getInstance().updateItem(id, updatedItem);

        req.setAttribute("item", updatedItem);

        return Action.SUCCESS;
    }
}
