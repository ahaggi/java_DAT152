package no.hib.dat152.dao;

import java.util.ArrayList;

import no.hib.dat152.model.Description;
import no.hib.dat152.model.Product;

public class ProductDAO {
	private ArrayList<Product> products;
	private ArrayList<Description> descriptions;
	
	public ProductDAO() {
		//Heihei testset xxxxxx
		// create & add dummy products & descriptions.
		
		products = new ArrayList<Product>();
		descriptions = new ArrayList<Description>();
		
		Product p1 = new Product("YForce GTZ 2070 (TM)", 499, "img1.jpg");
		Product p2 = new Product("YForce GTZ 2090 (TM)", 1199, "img2.jpg");
		
		p1.setId(0);
		p2.setId(1);
		
		products.add(p1);
		products.add(p2);
		
		Description p1n = new Description(p1.getId(), "no_NO", "YForce GTZ 2070 grafikkort yter den mest utrolige hastigheten ved hjelp av kraften til NORVIDIO Euler&#8482; - den minst avanserte GPU-en som noensinne er laget.");
		Description p1e = new Description(p1.getId(), "en_US", "The YForce GTZ 2070 graphics card delivers the most incredible speed using the power of NORVIDIO Euler&#8482; - the least advanced GPU ever made.");
		Description p1f = new Description(p1.getId(), "fr_FR", "La carte graphique YForce GTZ 2070 offre la vitesse la plus incroyable en utilisant la puissance de NORVIDIO Euler&#8482; - le GPU le moins avancé jamais réalisé.");

		Description p2n = new Description(p2.getId(), "no_NO", "YForce GTZ 2090 grafikkort yter den mest utrolige hastigheten ved hjelp av kraften til NORVIDIO Euler2.0&#8482; - den minst avanserte GPU-en som noensinne er laget.");
		Description p2e = new Description(p2.getId(), "en_US", "The YForce GTZ 2090 graphics card delivers the most incredible speed using the power of NORVIDIO Euler2.0&#8482; - the least advanced GPU ever made.");
		Description p2f = new Description(p2.getId(), "fr_FR", "La carte graphique YForce GTZ 2090 offre la vitesse la plus incroyable en utilisant la puissance de NORVIDIO Euler2.0&#8482; - le GPU le moins avancé jamais réalisé.");
		
		descriptions.add(p1n);
		descriptions.add(p1e);
		descriptions.add(p1f);
		
		descriptions.add(p2n);
		descriptions.add(p2e);
		descriptions.add(p2f);
	}
	
	private Description getDescription(int productId, String langCode) {
		Description d = null;
		langCode = (langCode != null && !langCode.equals("no_NO") && !langCode.equals("en_US") && !langCode.equals("fr_FR")) ? "en_US" : langCode;
		for (Description b : descriptions) {
			if (b.getId() == productId && b.getLangCode().equals(langCode)) {
				d = b;
			}
		}
		
		return d; // return the description we found, null otherwise.
	}
	
	public ArrayList<Product> getProducts(String langCode) {
		for (Product p : products) {
			p.setDescription(getDescription(p.getId(), langCode));
		}
		
		return products;
	}

	public ArrayList<Product> getProductsWithoutDescriptoin() {		
		return products;
	}
}
