package model.alt1;

import java.util.ListResourceBundle;

import model.KelvinToKelvinString;

/**
 * Locate kelvin using default locale.
 *
 * @author Atle Geitung
 */
public class LocaleSensitiveLogic extends ListResourceBundle {

    @Override
    protected final Object[][] getContents() {

        Object[][] oo = { { "tempformat", new KelvinToKelvinString() } };
        return oo;
    }

}
