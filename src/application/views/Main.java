package application.views;
	

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;



public class Main extends Application {
	

	
	public static void main(String[] args) {
		/*HuespedBean bean = new HuespedBean();
		Huesped h = new Huesped("ucuniwu928392", "Daniel", "Arturo", "Gonzalez", "Lopez", LocalDate.parse("1990-01-12"), 'm', "link.com", LocalDate.parse("2017-11-10"), "Activo", 12, 4, "Padece");
		bean.create(h);
		*/
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			final FlowPane container = new FlowPane();
			
			Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root, 700, 450);
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
