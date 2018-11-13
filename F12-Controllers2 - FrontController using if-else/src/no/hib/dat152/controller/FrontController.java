package no.hib.dat152.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

/**
 * FrontController for Item.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
@WebServlet("/do/*")
public class FrontController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected final void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        final String cmd = req.getPathInfo();
        if (cmd == null) {
            return;
        }
        if (cmd.equals("/viewshoppinglist")) {
            viewShoppinglist(req, resp);
        } else if (cmd.equals("/viewitem")) {
            viewItem(req, resp);
        } else if (cmd.equals("/updateitemform")) {
            updateItemForm(req, resp);
        } else if (cmd.equals("/updateItemSave")) {
            updateItemSave(req, resp);
        } else if (cmd.equals("/createitemform")) {
            createItemForm(req, resp);
        } else if (cmd.equals("/createitemsave")) {
            createItemSave(req, resp);
        }
    }

    @Override
    protected final void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * Implements the controller for "View shopping list".
     *
     * @param req request
     * @param resp response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    private void viewShoppinglist(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        final List<Item> items = ItemDAOMemorySingleton.getInstance().findAllItems();
        req.getSession().setAttribute("items", items);

        req.getRequestDispatcher("/shoppinglist.jsp").forward(req, resp);
    }

    /**
     * Implements the controller for "View Item".
     *
     * @param req request
     * @param resp response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    private void viewItem(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final Item item = ItemDAOMemorySingleton.getInstance().findItem(id);
        req.setAttribute("item", item);

        req.getRequestDispatcher("/item.jsp").forward(req, resp);
    }

    /**
     * Implements the controller for "Update item, form".
     *
     * @param req request
     * @param resp response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    private void updateItemForm(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = req.getParameter("id");
        final Item item = ItemDAOMemorySingleton.getInstance().findItem(id);

        req.setAttribute("item", item);

        req.getRequestDispatcher("/updateitemform.jsp").forward(req, resp);
    }

    /**
     * Implements the controller for "Update item, save".
     *
     * @param req request
     * @param resp response
     * @throws IOException IOException
     */
    private void updateItemSave(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final Double price = Double.parseDouble(req.getParameter("price"));
        final String description = req.getParameter("description");
        System.out.println("updateItemSave zzzzzzzzzzzzzzz");
        final Item updatedItem = new Item(id, name, price, description);
        ItemDAOMemorySingleton.getInstance().updateItem(id, updatedItem);
        req.getSession().setAttribute("item", updatedItem);
        resp.sendRedirect("viewitem?id=" + id);
    }

    /**
     * Implements the controller for "Create item, form".
     *
     * @param req request
     * @param resp response
     * @throws ServletException ServletException
     * @throws IOException IOException
     */
    private void createItemForm(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        final String id = ItemDAOMemorySingleton.getInstance().getNextId();
        req.setAttribute("id", id);

        req.getRequestDispatcher("/createitemform.jsp").forward(req, resp);
    }

    /**
     * Implements the controller for "Create ite, save".
     *
     * @param req request
     * @param resp response
     * @throws IOException IOException
     */
    private void createItemSave(final HttpServletRequest req, final HttpServletResponse resp) throws IOException {
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
