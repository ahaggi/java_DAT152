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

    @Override
    public final void init() throws ServletException {
        createActionsMap();
    }

    /**
     * Creates all action objects.
     */
    private void createActionsMap() {

        actions = new HashMap<>();

	        actions.put("/viewshoppinglist", new ViewShoppinglistAction());
        actions.put("/viewitem", new ViewItemAction());
        actions.put("/updateitemform", new UpdateItemFormAction());
        actions.put("/updateitemsave", new UpdateItemSaveAction());
        actions.put("/createitemform", new CreateItemFormAction());
        actions.put("/createitemsave", new CreateItemSaveAction());
    }

    @Override
    protected final void doGet(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {

        String cmd = req.getPathInfo(); // f.eks "/viewshoppinglist"

        if (cmd == null || cmd.length() == 1) {
            return;
        }

//        cmd = cmd.substring(1); // OBS OBS HVIS KEY BLIR LAGRET SOM "viewshoppinglist" fjern "/" fra f.eks "/viewshoppinglist"

        final Action action = actions.get(cmd);
        action.execute(req, resp);
    }

    @Override
    protected final void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

}
