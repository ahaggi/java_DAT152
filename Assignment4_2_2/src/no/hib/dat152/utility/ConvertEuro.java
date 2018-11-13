package no.hib.dat152.utility;

public class ConvertEuro {
	private static final double rateNOK = 9.35;
	private static final double rateUSD = 1.19;
	
	public static double toNOK(double amount) {
		return amount * rateNOK;
	}
	
	public static double toUSD(double amount) {
		return amount * rateUSD;
	}
	
	public static double toEUR(double amount) {
		return amount;
	}
}
