package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

	Stage primaryStage;
	Scene startScene;
	Menu startScenePane;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.startScenePane = new Menu();
		this.startScene = new Scene(this.startScenePane, 800, 600);
		this.startScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		this.primaryStage.setTitle("Mein Videospielshop");
		this.primaryStage.setScene(this.startScene);
		this.primaryStage.show();
	}

}
