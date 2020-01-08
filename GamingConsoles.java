package article;

public class GamingConsoles extends Article {

	private Manufacturer manufacturer;

	public GamingConsoles(String name, Manufacturer manufacturer) {
		super(name);
		this.manufacturer = manufacturer;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Override
	public String toString() {
		return super.toString() + ", Hersteller: " + getManufacturer().value;
	}

}
