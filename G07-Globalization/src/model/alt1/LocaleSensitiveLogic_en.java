package model.alt1;

import java.util.ListResourceBundle;
import java.util.Locale;

import model.KelvinToFahrenheitString;

/**
 * Locate kelvin to English.
 *
 * @author Atle Geitung
 */
public class LocaleSensitiveLogic_en extends ListResourceBundle {

    @Override
    protected final Object[][] getContents() {

        Object[][] oo = { { "tempformat", new KelvinToFahrenheitString(new Locale("en")) } };
        return oo;
    }

}
