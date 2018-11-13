package no.hib.dat152.action;

import no.hib.dat152.persistence.ItemDAOMemorySingleton;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Create item form action.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public class CreateItemFormAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public final String execute() {
        setId(ItemDAOMemorySingleton.getInstance().getNextId());
        return SUCCESS;
    }

    private String id;

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

}
