package model;

import java.util.Locale;

/**
 * Formating kelvin.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public class KelvinToKelvinString implements KelvinToString {

    @Override
    public final String format(final Double kelvin) {
        return String.format("%.1f Kelvin", kelvin);
    }

    @Override
    public void setLocale(final Locale locale) {
    }

}
