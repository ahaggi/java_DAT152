package no.hib.dat152.model;

/**
 * @author Oskar Elias Bråten 
 * @author Abdella Haji
 * @author Daniel Moberg
 * @author Sindre Fonnes
 *
 */
public class Product {
	private Integer id;
	private String name;
	private Double price;
	private String imageFile;
	private Description description;
	
	/**
	 * @param name
	 * @param price
	 * @param imageFile
	 */
	public Product(String name, double price, String imageFile) {
		this.name = name;
		this.price = price;
		this.imageFile = imageFile;
	}

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return price
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * @param price
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * @return imageFile
	 */
	public String getImageFile() {
		return imageFile;
	}

	/**
	 * @param imageFile
	 */
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	/**
	 * @return description
	 */
	public Description getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(Description description) {
		this.description = description;
	}
}
