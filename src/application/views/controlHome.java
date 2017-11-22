package application.views;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.ListIterator;

import application.MainApp;
import application.classes.Huesped;
import application.classes.Medicamento;
import application.classes.Responsable;
import application.classes.RepPastillas;
import application.models.HuespedBean;
import application.models.MedicamentoBean;
import application.models.ResponsableBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class controlHome {
	@FXML
	TextField searchField;
	@FXML
	Button reporte;
	@FXML
	MenuButton mainMenu;
	@FXML
	DatePicker repDate;
	@FXML
	TableView<RepPastillas> repPastillas;
	@FXML
	TableColumn<RepPastillas, String> colHuesped;
	@FXML
	TableColumn<RepPastillas, String> colMedicamento;
	@FXML
	TableColumn<RepPastillas, String> colResponsable;
	@FXML
	TableColumn<RepPastillas, String> colTelefono;
	
	private MainApp mainApp;
	
	public controlHome() {
		
	}
	
	@FXML
	private void initialize() {
		reporte(LocalDateTime.now().plusDays(7));
		
	}
	
	public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
	
	private void reporte(LocalDateTime date) {
		ObservableList<RepPastillas> data = FXCollections.observableArrayList();
		
		MedicamentoBean medB = new MedicamentoBean();
		HuespedBean huespB = new HuespedBean();
		ResponsableBean respB = new ResponsableBean();
		LinkedList<Medicamento> reportes = medB.report(date);
		ListIterator<Medicamento> iter = reportes.listIterator();
		
		if(!reportes.isEmpty()) {
			Huesped huesp = new Huesped();
			LinkedList<Responsable> resps = new LinkedList<Responsable>();
			while(iter.hasNext()) {
				Medicamento temp = iter.next();
				huesp = huespB.retrieve(temp.getIdHuesp());
				resps = respB.search(temp.getIdHuesp());
				data.add(new RepPastillas(huesp.nomCompleto(), temp.getNomMedicamento(), resps.getFirst().getNomCompleto(), resps.getFirst().getTelefono()));
			}
			repPastillas.setItems(data);
			colHuesped.setCellValueFactory(cellData -> cellData.getValue().NomHuespProperty());
			colMedicamento.setCellValueFactory(cellData -> cellData.getValue().NomMedProperty());
			colResponsable.setCellValueFactory(cellData -> cellData.getValue().NomRespProperty());
			colTelefono.setCellValueFactory(cellData -> cellData.getValue().TelRespProperty());
		}
		
	}
	
	@FXML
	private void reportar() {
		int selectedIndex = repPastillas.getSelectionModel().getSelectedIndex();
		reporte(LocalDateTime.now().plusDays(7));
	}
}
