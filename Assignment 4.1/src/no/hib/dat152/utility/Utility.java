package no.hib.dat152.utility;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class Utility {
	
	public static String copyright(String text, int sinceYear) {
		return "\u00a9 " + RomanNumeral.toRoman(sinceYear) + " - " +
			   RomanNumeral.toRoman(Calendar.getInstance().get(Calendar.YEAR)) +
			   " " + text;
	}
	
	public static String shortText(String text, int length) {
		if (text.length() < length) {
			return text;
		} else {
			return text.substring(0, length) + " ...";
		}
	}
}
