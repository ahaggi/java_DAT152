package no.hib.dat152.handleliste.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A domain class for shopping list (handleliste). Annotated with xml binding so that it can be automatically mapped to
 * xml.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
@XmlRootElement(name = "handleliste")
@XmlType(propOrder = { "id", "navn", "varer" })
public class Handleliste {

    private int id;
    private String navn;
    private List<Vare> varer;

    /**
     * Constructs a new Handleliste.
     */
    public Handleliste() {
    }

    /**
     * Constructs a new Handleliste with id.
     *
     * @param id the id
     */
    public Handleliste(final int id) {
        this(id, "");
    }

    /**
     * Constructs a new Handleliste with properties.
     *
     * @param id the id
     * @param navn the name
     */
    public Handleliste(final int id, final String navn) {
        this.id = id;
        this.navn = navn;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the id to set
     */
    public final void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets the navn.
     *
     * @return the navn
     */
    public final String getNavn() {
        return navn;
    }

    /**
     * Sets the navn.
     *
     * @param navn the navn to set
     */
    public final void setNavn(final String navn) {
        this.navn = navn;
    }

    /**
     * Gets the varer.
     *
     * @return the varer
     */
    public final List<Vare> getVarer() {
        return varer;
    }

    /**
     * Sets the varer.
     *
     * @param varer the varer to set
     */
    public final void setVarer(final List<Vare> varer) {
        this.varer = varer;
    }

}
