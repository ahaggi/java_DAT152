package no.hib.dat152.handleliste.persistence;

import java.util.List;

import no.hib.dat152.handleliste.model.Handleliste;
import no.hib.dat152.handleliste.model.Vare;

/**
 * Defines the interface to a shopping list (handleliste) data access object.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public interface HandlelisteDAO {

    /**
     * Create a new shopping list (handleliste) and name it.
     *
     * @param navn the name
     * @return id to the new shopping list
     */
    int opprettHandleliste(String navn);

    /**
     * Create a new item and add it to a shopping list.
     *
     * @param hid the shopping list id
     * @param vare a new item
     * @return id to the new item
     */
    int opprettVareIHandleliste(int hid, Vare vare);

    /**
     * Read all shopping lists (handlelister).
     *
     * @return a list of shopping lists
     */
    List<Handleliste> finnAlleHandlelister();

    /**
     * Read the shopping list with the handlelisteId.
     *
     * @param hid the id
     * @return a shopping list
     */
    Handleliste finnHandleliste(int hid);

    /**
     * Read all items from a shopping list.
     *
     * @param hid id of the shopping list
     * @return list of items
     */
    List<Vare> finnAlleVarer(int hid);

    /**
     * Read one item from a shopping list.
     *
     * @param hid shopping list id
     * @param vid item id
     * @return an item
     */
    Vare finnVare(int hid, int vid);

    /**
     * Update a shopping list (handleliste).
     *
     * @param hid the id
     * @param handleliste the updated shopping list
     */
    void oppdaterHandleliste(int hid, Handleliste handleliste);

    /**
     * Update an item.
     *
     * @param hid the shopping list.
     * @param vid the item id
     * @param vare the updated item
     */
    void oppdaterVare(int hid, int vid, Vare vare);

    /**
     * Delete a shopping list (handleliste).
     *
     * @param hid the id
     */
    void slettHandleliste(int hid);

    /**
     * Delete an item.
     *
     * @param hid the shopping list id
     * @param vid the item id
     */
    void slettVare(int hid, int vid);

    /**
     * Find a shopping list.
     *
     * @param hid the id
     * @return a shopping list
     */
    boolean finnesHandleliste(int hid);

    /**
     * Get an item in a shopping list.
     *
     * @param hid shopping list id
     * @param vid item id
     * @return an item
     */
    boolean finnesVare(int hid, int vid);
}
