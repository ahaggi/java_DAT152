package no.hib.dat152.action;

import java.util.ArrayList;
import java.util.List;

import no.hib.dat152.model.Item;
import no.hib.dat152.persistence.ItemDAOMemorySingleton;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Create item save action.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 *
 */
public class CreateItemSaveAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public final String execute() {

        final Item newItem = new Item(id, name, price, description);
        ItemDAOMemorySingleton.getInstance().createItem(newItem);

        items = ItemDAOMemorySingleton.getInstance().findAllItems();

        return SUCCESS;
    }

    private List<Item> items = new ArrayList<Item>();

    private String id;
    private String name;
    private Double price;
    private String description;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the price.
     *
     * @return the price
     */
    public final Double getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price the price to set
     */
    public final void setPrice(final Double price) {
        this.price = price;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public final String Description() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the description to set
     */
    public final void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Gets the items.
     *
     * @return the items
     */
    public final List<Item> getItems() {
        return items;
    }

}
