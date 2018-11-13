package no.hib.dat152.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hib.dat152.action.Action;
import no.hib.dat152.action.CreateItemFormAction;
import no.hib.dat152.action.CreateItemSaveAction;
import no.hib.dat152.action.UpdateItemFormAction;
import no.hib.dat152.action.UpdateItemSaveAction;
import no.hib.dat152.action.ViewItemAction;
import no.hib.dat152.action.ViewShoppinglistAction;

/**
 * Front controller for Item.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class FrontController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Map<String, Action> actions;
    private FlowManager flowManager;

    @Override
    public final void init() throws ServletException {
        createActionsMap();
        flowManager = new FlowManager();
    }

    @Override
    protected final void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        final String cmd = getCommand(req);

        final Action action = actions.get(cmd);
        final int result = action.execute(req, resp);

        if (result == Action.SUCCESS) {
            final String nextPage = flowManager.getNextPage(cmd);
            req.getRequestDispatcher(nextPage).forward(req, resp);
        } else {
        }
    }

    @Override
    protected final void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    /**
     * Creates all action objects.
     */
    private void createActionsMap() {

        actions = new HashMap<>();

        // Kunne brukt config-fil i stedet
        actions.put("viewshoppinglist", new ViewShoppinglistAction());
        actions.put("viewitem",       new ViewItemAction());
        actions.put("updateitemform", new UpdateItemFormAction());
        actions.put("updateitemsave", new UpdateItemSaveAction());
        actions.put("createitemform", new CreateItemFormAction());
        actions.put("createitemsave", new CreateItemSaveAction());
    }

    /**
     * Get the requested command.
     * @param req request
     * @return command
     */
    private String getCommand(final HttpServletRequest req) {

        String cmd = req.getPathInfo();

        if (cmd == null || cmd.length() <= 1) {
            cmd = "";
        } else {
            cmd = cmd.substring(1);
        }
        return cmd;
    }
}
