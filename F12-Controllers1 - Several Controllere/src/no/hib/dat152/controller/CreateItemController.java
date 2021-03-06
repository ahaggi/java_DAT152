package no.hib.dat152.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * Controller for use case "Create item".
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class CreateItemController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected final void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = ItemDAOMemorySingleton.getInstance().getNextId();
        req.setAttribute("id", id);

        req.getRequestDispatcher("/createitemform.jsp").forward(req, resp);
    }

    @Override
    protected final void doPost(final HttpServletRequest req, final HttpServletResponse resp)
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
