package application;

import article.Article;
import article.GamingConsoles;
import article.Genre;
import article.Manufacturer;
import article.VideoGames;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class StorageView extends ListView<Article> {

	private ObservableList<Article> gamesList = FXCollections.observableArrayList();
	private ObservableList<Article> consolesList = FXCollections.observableArrayList();

	public StorageView() {
		this.gamesList.add(new VideoGames("Rocket League", Genre.OTHER, 6));
		this.gamesList.add(new VideoGames("CS:GO", Genre.ACTION, 16));
		this.gamesList.add(new VideoGames("Genital Jousting", Genre.ACTION_ADVENTURE, 0));

		this.consolesList.add(new GamingConsoles("PS4", Manufacturer.SONY));
		this.consolesList.add(new GamingConsoles("XBox - One", Manufacturer.MICROSOFT));

	}

	public void changeToGamesList() {
		setItems(gamesList);
	}

	public void changeToConsoleList() {
		setItems(consolesList);
	}

	public void removeItemFromStorage() {
		Article selectedItem = this.getSelectionModel().getSelectedItem();

		if (selectedItem instanceof VideoGames) {
			this.gamesList.remove(selectedItem);
		}
		if (selectedItem instanceof GamingConsoles) {
			this.consolesList.remove(selectedItem);
		}

	}

	public void addItemToStorage(Article selectedItem) {

		if (selectedItem instanceof VideoGames) {
			this.gamesList.add(selectedItem);
		}
		if (selectedItem instanceof GamingConsoles) {
			this.consolesList.add(selectedItem);
		}

	}
}
