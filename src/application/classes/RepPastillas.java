package application.classes;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RepPastillas {
	private final StringProperty nomHuesp;
	private final StringProperty nomMed;
	private final StringProperty nomResp;
	private final StringProperty telResp;
	
	public RepPastillas() {
		this(null, null, null, null);
	}
	
	public RepPastillas(String nomHuesp, String nomMed, String nomResp, String telResp) {
		super();
		this.nomHuesp = new SimpleStringProperty(nomHuesp);
		this.nomMed = new SimpleStringProperty(nomMed);
		this.nomResp = new SimpleStringProperty(nomResp);
		this.telResp = new SimpleStringProperty(telResp);
	}

	public String getNomHuesp() {
		return nomHuesp.get();
	}

	public void setNomHuesp(String nomHuesp) {
		this.nomHuesp.set(nomHuesp);
	}
	
	public StringProperty NomHuespProperty() {
		return nomHuesp;
	}

	public String getNomMed() {
		return nomMed.get();
	}

	public void setNomMed(String nomMed) {
		this.nomMed.set(nomMed);
	}
	
	public StringProperty NomMedProperty() {
		return nomMed;
	}
	
	public String getNomResp() {
		return nomResp.get();
	}

	public void setNomResp(String nomResp) {
		this.nomResp.set(nomResp);
	}

	public StringProperty NomRespProperty() {
		return nomResp;
	}
	
	public String getTelResp() {
		return telResp.get();
	}

	public void setTelResp(String telResp) {
		this.telResp.set(telResp);
	}
	
	public StringProperty TelRespProperty() {
		return telResp;
	}
}

