package no.hib.dat152.model;

public class Description {
	private Integer id;
	private String langCode;
	private String text;
	
	public Description(int id, String langCode, String text) {
		this.id = id;
		this.langCode = langCode;
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLangCode() {
		return langCode;
	}

	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
