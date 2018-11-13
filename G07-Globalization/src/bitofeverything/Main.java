package bitofeverything;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import model.KelvinToString;
import model.TodayData;

/**
 * The main app.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public final class Main {

    /**
     * Hides the constructor.
     */
    private Main() {
    }

    /**
     * The main app.
     *
     * @param args Not used.
     * @throws InstantiationException fail
     * @throws IllegalAccessException fail
     * @throws ClassNotFoundException fail
     */
    public static void main(final String[] args) throws InstantiationException, IllegalAccessException,
    ClassNotFoundException {

        // Locale locale = Locale.getDefault();
        // Locale locale = new Locale("en");
        /** 1-local(lang)
         *  2-ResourceBundle apptexts (local)
         *  3-String apptexts.getString("tempFormat"), hvis "no-nb", blir det *.model.KelvinToCelsiusString
         *  **/

        Locale locale = new Locale("no");
        KelvinToString kelvinToString;
        ResourceBundle apptexts = ResourceBundle.getBundle("apptexts", locale);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);

        /**
         * 4- ResourceBundle appobjects = ResourceBundle.getBundle(en KLASSE som extends ListResourceBundle, og lager instanse av "passende klasse")
         * 5- kelvinToString = (KelvinToString) appobjects.getObject interface-peker som 
         * */
        // Alt.1 ListResourceBundle
        System.out.println("Alternative 1");

        ResourceBundle appobjects = ResourceBundle.getBundle("model.alt1.LocaleSensitiveLogic", locale);
        kelvinToString = (KelvinToString) appobjects.getObject("tempformat");

        System.out.println("Chosen locale: " + locale);
        System.out.println("Texts locale: " + apptexts.getLocale());
        System.out.println("Temps locale: " + appobjects.getLocale());

        System.out.print(apptexts.getString("todaysNews") + " ");
        System.out.println(dateFormat.format(new Date()) + ".");

        System.out.print(apptexts.getString("maxTodayWas") + " ");
        System.out.println(kelvinToString.format(TodayData.getMaxTemp()) + ".");

        /**
         * 4-String tempFormatClass = apptexts.getString("tempFormat") passende klasseNavn
         * 5-kelvinToString(interface)= Class.forName()
         * */
        // Alt.2   PropertyResourceBundle
        System.out.println("Alternative 2");

        String tempFormatClass = apptexts.getString("tempFormat");
        // tempFormat = NO *.model.KelvinToCelsiusString    US*.model.KelvinToFahrenheitString
        kelvinToString = (KelvinToString) Class.forName(tempFormatClass).newInstance();

        kelvinToString.setLocale(locale); //ikke nødvendig, den blir brukt for en metode i "den passende klssse"  

        System.out.println("Chosen locale: " + locale);
        System.out.println("Texts locale: " + apptexts.getLocale());

        System.out.print(apptexts.getString("todaysNews") + " ");
        System.out.println(dateFormat.format(new Date()) + ".");

        System.out.print(apptexts.getString("maxTodayWas") + " ");
        System.out.println(kelvinToString.format(TodayData.getMaxTemp()) + ".");

        // Alt.3
        /*
         * Hverken i Alt.1 eller Alt.2 er KelvinToString en lokaliserings-sensitiv klasse. I begge tilfeller har man
         * valgt korrekt implementasjon av KelvinToString indirekte (Alt.1 via en ListResourceBundle og Alt.2 via en
         * property i en PropertyResourceBundle).
         *
         * Hvis man ønsker en lokaliserings-sensitiv KelvinToString, må denne gjøres om til en abstrakt klasse og
         * forsynes med en lokale-sensitiv factory-metode som returnerer korrekt subklasse.
         *
         * Dette blir litt mindre fleksibelt enn Alt.1 og Alt.2 siden vi må endre factory-metoden hvis vi ønsker flere
         * språk (brudd på OCP). I Alt.1 og Alt.2 legger vi kun til ting, vi endrer ikke eksisterende.
         */

    }
}
