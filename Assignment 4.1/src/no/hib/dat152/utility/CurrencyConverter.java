package no.hib.dat152.utility;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyConverter {
	private Locale locale;
	private NumberFormat nf;
	private final double rateNOK = 9.35;
	private final double rateUSD = 1.19;
	
	public CurrencyConverter(Locale locale) {
		this.locale = locale;
		this.nf = NumberFormat.getCurrencyInstance(locale);
	}
	
	public String format(double amount) {
		if (locale.equals(new Locale("en", "US"))) {
			return nf.format(amount * rateUSD);
		} else if (locale.equals(new Locale("no", "NO"))) {
			return nf.format(amount * rateNOK);
		} else {
			return nf.format(amount);
		}
	}
}
