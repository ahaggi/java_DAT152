package model.alt1;

import java.util.ListResourceBundle;
import java.util.Locale;

import model.KelvinToCelsiusString;

/**
 * Locate kelvin to Norwegian.
 *
 * @author Atle Geitung
 */
public class LocaleSensitiveLogic_no extends ListResourceBundle {

    @Override
    protected final Object[][] getContents() {

        Object[][] oo = { { "tempformat", new KelvinToCelsiusString(new Locale("no")) } };
        return oo;
    }

}
