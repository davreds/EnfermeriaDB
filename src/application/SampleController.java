package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SampleController {
	
	public void switchPerfil(ActionEvent event) throws IOException{
		Parent home_page_parent = FXMLLoader.load(getClass().getResource("PerfilHuesped.fxml"));
		Scene home_page_scene = new Scene(home_page_parent);
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		app_stage.hide();
		app_stage.setScene(home_page_scene);
		app_stage.show();
	}
};
