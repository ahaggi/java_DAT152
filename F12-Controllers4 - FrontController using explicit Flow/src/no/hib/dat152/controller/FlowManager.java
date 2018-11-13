package no.hib.dat152.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Flow manager for Item.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
public class FlowManager {

    private final Map<String, String> pages;

    /**
     * Constructs a new FlowManager.
     */
    public FlowManager() {

        pages = new HashMap<>();

        // Kunne brukt config-fil i stedet
        pages.put("viewshoppinglist", "/shoppinglist.jsp");
        pages.put("viewitem", "/item.jsp");
        pages.put("updateitemform", "/updateitemform.jsp");
        pages.put("updateitemsave", "/item.jsp");
        pages.put("createitemform", "/createitemform.jsp");
        pages.put("createitemsave", "/shoppinglist.jsp");
    }

    /**
     * Gets the next page.
     *
     * @param cmd the command
     * @return next page
     */
    public final String getNextPage(final String cmd) {
        return pages.get(cmd);
    }

}
