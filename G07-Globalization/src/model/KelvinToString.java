package model;

import java.util.Locale;

/**
 * Interface for classes for formatting kelvin.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public interface KelvinToString {

    /**
     * A formattedes text for kelvin.
     *
     * @param kelvin degree in kelvin
     * @return formatted string
     */
    String format(Double kelvin);

    /**
     * Sets locale.
     *
     * @param locale new locale
     */
    void setLocale(Locale locale);

}
