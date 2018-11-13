package no.hib.dat152.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * Controller for use case "Update item".
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class UpdateItemController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected final void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");
        final Item item = ItemDAOMemorySingleton.getInstance().findItem(id);
        req.setAttribute("item", item);

        req.getRequestDispatcher("/updateitemform.jsp").forward(req, resp);
    }

    @Override
    protected final void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final Double price = Double.parseDouble(req.getParameter("price"));
        final String description = req.getParameter("description");

        final Item updatedItem = new Item(id, name, price, description);
        ItemDAOMemorySingleton.getInstance().updateItem(id, updatedItem);

        resp.sendRedirect("viewitem?id=" + id);
    }

}
