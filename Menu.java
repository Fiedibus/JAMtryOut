package application;

import article.GamingConsoles;
import article.Genre;
import article.Manufacturer;
import article.VideoGames;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Menu extends BorderPane {

	ComboBox<String> videoGamesComboBox;
	ComboBox<Enum> genreComboBox;
	TextField nameTextField;
	TextField ageTextField;
	Button buyButton;
	Button sellButton;
	StorageView storage;

	public Menu() {
		leftGuiSide();
	}

	private void leftGuiSide() {
		this.storage = new StorageView();
		this.videoGamesComboBox = new ComboBox<String>();
		this.videoGamesComboBox.setPromptText("Artikel");
		this.nameTextField = new TextField();
		this.nameTextField.setPromptText("Name");
		this.ageTextField = new TextField();
		this.ageTextField.setPromptText("Altersbeschränkung");
		this.genreComboBox = new ComboBox<Enum>();
		this.genreComboBox.setPromptText("Genre");

		this.buyButton = new Button("Kaufen");
		this.sellButton = new Button("Verkaufen");

		VBox menuButtons = new VBox();
		HBox bottomButtons = new HBox();
		Region puffer = new Region();
		VBox.setVgrow(puffer, Priority.ALWAYS);
		bottomButtons.getChildren().addAll(this.buyButton, this.sellButton);
		menuButtons.getChildren().addAll(this.videoGamesComboBox, this.nameTextField, this.genreComboBox,
				this.ageTextField, puffer, bottomButtons);
		this.setLeft(menuButtons);
		this.setCenter(storage);

		fillTopComboBox();
		buttonLogic();
	}

	private void buttonLogic() {
		this.sellButton.setOnAction(e -> {
			this.storage.removeItemFromStorage();
		});

		this.buyButton.setOnAction(e -> {
			if (this.videoGamesComboBox.getSelectionModel().getSelectedItem().equals("Videospiele")) {
				storage.addItemToStorage(
						new VideoGames(this.nameTextField.getText(), Integer.parseInt(this.ageTextField.getText())));
			} else if (this.videoGamesComboBox.getSelectionModel().getSelectedItem().equals("Konsolen")) {
				storage.addItemToStorage(new GamingConsoles(this.nameTextField.getText(),
						(Manufacturer) this.genreComboBox.getSelectionModel().getSelectedItem()));
			}
		});
	}

	private void fillTopComboBox() {
		this.videoGamesComboBox.getItems().setAll("Videospiele", "Konsolen");
		this.videoGamesComboBox.setOnAction(e -> {
			if (this.videoGamesComboBox.getSelectionModel().getSelectedItem().equals("Videospiele")) {
				this.genreComboBox.getItems().setAll(Genre.values());
				this.storage.changeToGamesList();
				this.ageTextField.setVisible(true);
			} else if (this.videoGamesComboBox.getSelectionModel().getSelectedItem().equals("Konsolen")) {
				this.genreComboBox.getItems().setAll(Manufacturer.values());
				this.storage.changeToConsoleList();
				this.ageTextField.setVisible(false);
			}

		});

	}
}
