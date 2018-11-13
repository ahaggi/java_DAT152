package no.hib.dat152;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import no.hib.dat152.dao.ProductDAO;
import no.hib.dat152.model.Description;
import no.hib.dat152.model.Product;
import no.hib.dat152.utility.CurrencyConverter;
import no.hib.dat152.utility.Utility;

public class Main {
	 //
	private static HashMap<Integer, Integer> cart = new HashMap<Integer, Integer>();
	private static Locale locale = new Locale("en", "US");
	private static CurrencyConverter currencyConverter;
	private static Scanner input = new Scanner(System.in);
	private static ResourceBundle appText;
	private static ProductDAO productDAO = new ProductDAO();
	
	public static void showCart() {
		System.out.println(appText.getString("cart"));
		
		System.out.print("\t");
		System.out.printf("|%-35s|", appText.getString("name") + ":");
		System.out.printf("|%-35s|", appText.getString("shortDescription") + ":");
		System.out.printf("|%-35s|", appText.getString("price") + ":");
		System.out.printf("|%-35s|", appText.getString("quantity") + ":");
		System.out.printf("|%-35s|", appText.getString("total") + ":");
		System.out.println("");
		
		ArrayList<Product> products = productDAO.getProducts();
		
		Object[] keys = cart.keySet().toArray();
		Arrays.sort(keys);
		
		for (Object k : keys) {
			int i = (Integer) k;
			int amount = cart.get(i);
			Product p = products.get(i);
			
			Description d = productDAO.getDescription(p.getId(), locale.getLanguage());
			String shortDesc = Utility.shortText(d.getText(), 30);
			
			System.out.print((p.getId() + 1) + ".\t");
			System.out.printf("|%-35s|", p.getName());
			System.out.printf("|%-35s|", shortDesc);
			System.out.printf("|%-35s|", currencyConverter.format(p.getPrice()));
			System.out.printf("|%-35s|", amount);
			System.out.printf("|%-35s|", currencyConverter.format((p.getPrice() * amount)));
			System.out.println("");
		}
		
		showProducts();
	}
	
	public static void showProducts() {
		System.out.println(appText.getString("products") + ":");
		ArrayList<Product> products = productDAO.getProducts();
		int index = 1;
		for (Product p : products) {
			Description d = productDAO.getDescription(p.getId(), locale.getLanguage());
			System.out.println(index + ":");
			System.out.println(appText.getString("name") + ": " + p.getName());
			System.out.println(appText.getString("price") + ":" + currencyConverter.format(p.getPrice()));
			System.out.println(appText.getString("description") + ":" + d.getText());
			index++;
		}
		
		int productId;
		
		while (true) {
			System.out.println(appText.getString("addToCart") + appText.getString("changeLanguage") + ": ");
			String in = input.nextLine();
			try {
				productId = Integer.parseInt(in) - 1;
				break;
			} catch (NumberFormatException e) {
				System.out.println(appText.getString("invalid"));
			}
		}
		
		if (productId + 1 == 0) {
			selectLanguage();
		}
		
		if (cart.get(productId) != null) {
			cart.put(productId, cart.get(productId) + 1);
		} else {
			cart.put(productId, 1);
		}
		
		showCart();
	}
	
	public static void selectLanguage() {
		System.out.println("Select preferred language: ");
		System.out.println("1. English, US (default)");
		System.out.println("2. Norwegian, NO");
		System.out.println("3. French, FR");
		
		String l = input.nextLine();
		if (l == null) {
			// do nothing.
		} else if (l.equals("1")){
			locale = new Locale("en", "US");
		} else if (l.equals("2")) {
			locale = new Locale("no", "NO");
		} else if (l.equals("3")) {
			locale = new Locale("fr", "FR");
		}
		
		currencyConverter = new CurrencyConverter(locale);
		
		appText = ResourceBundle.getBundle("apptexts", locale);
		
		System.out.println("Datakomponenten AS");
		System.out.println(appText.getString("greeting") + " " + appText.getString("products"));
		
		showProducts();
	}
	
	public static void main(String[] args) {
		selectLanguage();
	}

}
