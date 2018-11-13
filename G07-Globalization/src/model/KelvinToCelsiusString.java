package model;

import java.util.Locale;

/**
 * Formating a degree in kelvin to celcius.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public class KelvinToCelsiusString implements KelvinToString {

    private static final int CELSIUS_NULL = 273;

    private Locale locale;

    /**
     * Constructs a new convertion object.
     */
    public KelvinToCelsiusString() {
    }

    /**
     * Constructs a new convertion object.
     *
     * @param locale locale
     */
    public KelvinToCelsiusString(final Locale locale) {
        this.locale = locale;
    }

    @Override
    public final String format(final Double kelvin) {
        double celsius = kelvin - CELSIUS_NULL;
        return String.format(locale, "%.1f\u00B0 Celsius", celsius);
    }

    @Override
    public final void setLocale(final Locale locale) {
        this.locale = locale;
    }

}
