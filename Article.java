package article;

public class Article {

	public static int idCounter;

	private int ID;
	private String name;

	public Article(String name) {
		idCounter++;
		this.ID = idCounter;
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {	
		return "ID: " + getID() + ", Name: " + getName();
				 
	}
	
}
