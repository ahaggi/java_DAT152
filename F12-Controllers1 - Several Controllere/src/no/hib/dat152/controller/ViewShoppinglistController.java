package no.hib.dat152.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * Controller for use case "View shopping list".
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class ViewShoppinglistController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected final void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final List<Item> items = ItemDAOMemorySingleton.getInstance().findAllItems();
        req.getSession().setAttribute("items", items);

        req.getRequestDispatcher("/shoppinglist.jsp").forward(req, resp);
    }

}
