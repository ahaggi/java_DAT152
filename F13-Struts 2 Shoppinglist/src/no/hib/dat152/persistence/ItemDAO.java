package no.hib.dat152.persistence;

import java.util.List;

import no.hib.dat152.model.Item;

/**
 * Interface for the data access object for Item.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public interface ItemDAO {

    /**
     * Find all items.
     *
     * @return all items
     */
    List<Item> findAllItems();

    /**
     * Find one Item.
     *
     * @param id the id
     * @return the Item
     */
    Item findItem(String id);

    /**
     * Insert a new Item.
     *
     * @param item the new Item
     */
    void createItem(Item item);

    /**
     * Update an existing Item.
     *
     * @param id the id
     * @param itemdata The Item
     */
    void updateItem(String id, Item itemdata);

    /**
     * Return the next available id.
     *
     * @return id
     */
    String getNextId();
}
