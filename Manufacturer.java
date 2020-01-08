package article;

public enum Manufacturer {

	SONY ("Sony"),
	MICROSOFT ("Microsoft");
	
	String value;
	Manufacturer(String value) {
		this.value = value;
	}
}
