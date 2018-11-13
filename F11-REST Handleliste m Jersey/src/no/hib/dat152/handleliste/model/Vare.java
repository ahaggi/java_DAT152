package no.hib.dat152.handleliste.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A domain class for items in the shopping list (varer). Annotated with xml binding so that it can be automatically
 * mapped to xml.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 *
 */
@XmlRootElement(name = "vare")
@XmlType(propOrder = { "id", "navn", "antall", "enhet" })
public class Vare {

    private int id;
    private String navn;
    private int antall;
    private String enhet;

    /**
     * Constructs a new Vare.
     */
    public Vare() {
    }

    /**
     * Constructs a new Vare with an id.
     *
     * @param id the id
     */
    public Vare(final int id) {
        this(id, "", 0, "");
    }

    /**
     * Constructs a new Vare with fields set.
     *
     * @param id the id
     * @param navn the name
     * @param antall the number
     * @param enhet the unit
     */
    public Vare(final int id, final String navn, final int antall, final String enhet) {
        this.id = id;
        this.navn = navn;
        this.antall = antall;
        this.enhet = enhet;
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
     * Gets the antall.
     *
     * @return the antall
     */
    public final int getAntall() {
        return antall;
    }

    /**
     * Sets the antall.
     *
     * @param antall the antall to set
     */
    public final void setAntall(final int antall) {
        this.antall = antall;
    }

    /**
     * Gets the enhet.
     *
     * @return the enhet
     */
    public final String getEnhet() {
        return enhet;
    }

    /**
     * Sets the enhet.
     *
     * @param enhet the enhet to set
     */
    public final void setEnhet(final String enhet) {
        this.enhet = enhet;
    }

    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + antall;
        result = prime * result + ((enhet == null) ? 0 : enhet.hashCode());
        result = prime * result + id;
        result = prime * result + ((navn == null) ? 0 : navn.hashCode());
        return result;
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vare other = (Vare) obj;
        return this.id == other.id;
    }

}
