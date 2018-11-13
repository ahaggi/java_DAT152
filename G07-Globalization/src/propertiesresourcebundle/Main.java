package propertiesresourcebundle;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * The main app.
 *
 * @author Atle Geitung
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
	 */
	public static void main(final String[] args) {

		// Locale locale = Locale.getDefault();

//		Locale locale = new Locale("no");
//		Locale locale = new Locale("no","NO");
//		Locale locale = new Locale("no","NO_BM");
//		Locale locale = new Locale("no","NO_NN");
		Locale locale = new Locale("nn");
//		Locale locale = new Locale("nb");
//
//		Locale locale = new Locale("jp");
//		Locale locale = new Locale("de");
//		Locale locale = new Locale("en");
		
		ResourceBundle apptexts = ResourceBundle.getBundle("apptexts", locale);

		System.out.println("Chosen locale: " + locale);
		System.out.println("Bundle locale: " + apptexts.getLocale());

		System.out.print(apptexts.getString("whatsYourName") + " ");

		Scanner keyboard = new Scanner(System.in);
		String name = keyboard.nextLine();
		keyboard.close();

		System.out.println(apptexts.getString("hello") + " " + name + ". " + apptexts.getString("howAreYou"));
	}
}
