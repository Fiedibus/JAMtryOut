package article;

import application.Main;

public class VideoGames extends Article {

	private Genre genre;
	private int ageRestriction;

	public VideoGames(String name, Genre genre, int ageRestriction) {
		super(name);
		this.genre = genre;
		this.ageRestriction = ageRestriction;

	}

	public VideoGames(String name, int ageRestriction) {
		super(name);
		this.genre = Genre.ACTION;
		this.ageRestriction = ageRestriction;

	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public int getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(int ageRestriction) {
		this.ageRestriction = ageRestriction;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Genre: " + getGenre().value + ", Alterbeschränkung: " + getAgeRestriction();
	}

}
