package no.hib.dat152.model;

/**
 * @author Oskar Elias Bråten 
 * @author Abdella Haji
 * @author Daniel Moberg
 * @author Sindre Fonnes
 *
 */
public class Description {
	private Integer id;
	private String langCode;
	private String text;
	
	/**
	 * @param id
	 * @param langCode
	 * @param text
	 */
	public Description(int id, String langCode, String text) {
		this.id = id;
		this.langCode = langCode;
		this.text = text;
	}

	/**
	 * @return Product id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param sets Product id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return langCode
	 */
	public String getLangCode() {
		return langCode;
	}

	/**
	 * @param langCode
	 */
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	/**
	 * @return text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
	}
}
