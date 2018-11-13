package model;

import java.util.Locale;

/**
 * Formating a degree in kelvin to fahrenheit.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public class KelvinToFahrenheitString implements KelvinToString {

    private static final int CELSIUS_NULL = 273;
    private static final int CELCIUS_FAHRENHEIT_NULL = 32;
    private static final double CELCIUS_FAHRENHEIT = 1.8;

    private Locale locale;

    /**
     * Constructs a new convertion object.
     */
    public KelvinToFahrenheitString() {
    }

    /**
     * Constructs a new convertion object.
     *
     * @param locale locale
     */
    public KelvinToFahrenheitString(final Locale locale) {
        this.locale = locale;
    }

    @Override
    public final String format(final Double kelvin) {
        double fahrenheit = (kelvin - CELSIUS_NULL) * CELCIUS_FAHRENHEIT + CELCIUS_FAHRENHEIT_NULL;
        return String.format(locale, "%.1f\u00B0 Fahrenheit", fahrenheit);
    }

    @Override
    public final void setLocale(final Locale locale) {
        this.locale = locale;
    }

}
