package no.hib.dat152.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import no.hib.dat152.dao.ProductDAO;

public class Cart {
	private ProductDAO productDAO;
	private HashMap<Integer, Integer> cartItems;

	public Cart() {
		productDAO = new ProductDAO();
		cartItems = new HashMap<Integer, Integer>(); // productId, quantity
		//TODO er det bedre å ha en var double Total som oppdateres etter hver kall av addItem??
	}

	public double getTotalPriceForEachItem(int productId) {
		double totalPrice = 0;
		if (cartItems.size() != 0) {
			ArrayList<Product> products = productDAO.getProductsWithoutDescriptoin();
			// TODO sjekk at produktet fins i begge (products + cartItems)
			Product p = products.get(productId);
			int amount = cartItems.get(productId);
			totalPrice = p.getPrice() * amount;
		}
		return totalPrice;

	}

	public double getTotalPrice() {
		double total = 0;
		if (cartItems.size() != 0) {

			Object[] keys = cartItems.keySet().toArray();
			// Arrays.sort(keys);

			for (Object k : keys) {
				int p_id = (Integer) k;
				double price = getTotalPriceForEachItem(p_id);
				total += price;
			}
		}

		return total;
	}
	
	
	public void addItem(int p_Id) {

		if (cartItems.containsKey(p_Id)) {
			cartItems.put(p_Id, cartItems.get(p_Id) + 1);
		} else {
			cartItems.put(p_Id, 1);
		}

	}

	

 
//	public List<Integer> getCartItemList() {
//		List<Integer> itemsIdList  = new ArrayList<Integer>();
//		
//		Object[] keys = cartItems.keySet().toArray();
//		Arrays.sort(keys);
//				
//		for (Object k : keys) {
//			int i = (Integer) k;
//			int amount = cartItems.get(i);
//			Product p = products.get(i);
//			cartList.add(new CartItem(p, amount));
//		}
//
//		
//		return null;
//		
//	}
		public HashMap<Integer, Integer> getCartItems() {
		return cartItems;
	}

	public void setCartItems(HashMap<Integer, Integer> cartItems) {
		this.cartItems = cartItems;
	}

}
