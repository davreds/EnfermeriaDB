package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			final FlowPane container = new FlowPane();
			
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root, 700, 450);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			ScrollPane sp = new ScrollPane();
			container.getChildren().addAll();
			sp.setContent(container);
			
			primaryStage.setTitle("Asilo");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
