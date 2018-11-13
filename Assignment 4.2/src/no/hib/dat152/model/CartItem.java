package no.hib.dat152.model;

/**
 * @author Oskar Elias Bråten 
 * @author Abdella Haji
 * @author Daniel Moberg
 * @author Sindre Fonnes
 *
 */
public class CartItem {
	private Product product;
	private int quantity;
	
	/**
	 * @param product
	 * @param quantity
	 */
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	/**
	 * @return Total Price
	 */
	public double getTotalPrice() {
		return quantity * product.getPrice();
	}

	/**
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
