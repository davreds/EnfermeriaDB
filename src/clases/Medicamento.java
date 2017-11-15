package clases;
import java.time.LocalDateTime;

public class Medicamento {
	//Atributos
	private String idHuesp;
	private String nomMedicamento;
	private int cantidad;
	private LocalDateTime fecAct;
	private int conMat;
	private int conVesp;
	private int conNoct;
	private int numEv;
	private String nomEnfermero;
	
	//Constructor vacio
	public Medicamento() {
		this.idHuesp = "";
		this.nomMedicamento = "";
		this.cantidad = 0;
		this.fecAct = LocalDateTime.of(0,1,1,0,0,0);
		this.conMat = 0;
		this.conVesp = 0;
		this.conNoct = 0;
		this.numEv = 0;
		this.nomEnfermero = "";
	}
	
	//Constructor sin evento
	public Medicamento(String idHuesp, String nomMedicamento, int cantidad, LocalDateTime fecAct, int conMat,
			int conVesp, int conNoct, int conTot, String nomEnfermero) {
		super();
		this.idHuesp = idHuesp;
		this.nomMedicamento = nomMedicamento;
		this.cantidad = cantidad;
		this.fecAct = fecAct;
		this.conMat = conMat;
		this.conVesp = conVesp;
		this.conNoct = conNoct;
		this.numEv = 0;
		this.nomEnfermero = nomEnfermero;
	}

	//Constructor con evento
	public Medicamento(String idHuesp, String nomMedicamento, int cantidad, LocalDateTime fecAct, int conMat,
			int conVesp, int conNoct, int conTot, int numEv, String nomEnfermero) {
		super();
		this.idHuesp = idHuesp;
		this.nomMedicamento = nomMedicamento;
		this.cantidad = cantidad;
		this.fecAct = fecAct;
		this.conMat = conMat;
		this.conVesp = conVesp;
		this.conNoct = conNoct;
		this.numEv = numEv;
		this.nomEnfermero = nomEnfermero;
	}

	public String getIdHuesp() {
		return idHuesp;
	}

	public void setIdHuesp(String idHuesp) {
		this.idHuesp = idHuesp;
	}

	public String getNomMedicamento() {
		return nomMedicamento;
	}

	public void setNomMedicamento(String nomMedicamento) {
		this.nomMedicamento = nomMedicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public LocalDateTime getFecAct() {
		return fecAct;
	}

	public void setFecAct(LocalDateTime fecAct) {
		this.fecAct = fecAct;
	}

	public int getConMat() {
		return conMat;
	}

	public void setConMat(int conMat) {
		this.conMat = conMat;
	}

	public int getConVesp() {
		return conVesp;
	}

	public void setConVesp(int conVesp) {
		this.conVesp = conVesp;
	}

	public int getConNoct() {
		return conNoct;
	}

	public void setConNoct(int conNoct) {
		this.conNoct = conNoct;
	}

	public int getNumEv() {
		return numEv;
	}

	public void setNumEv(int numEv) {
		this.numEv = numEv;
	}

	public String getNomEnfermero() {
		return nomEnfermero;
	}

	public void setNomEnfermero(String nomEnfermero) {
		this.nomEnfermero = nomEnfermero;
	}
	
	public int calcConsumo() {
		return conMat + conVesp + conNoct;
	}
}
