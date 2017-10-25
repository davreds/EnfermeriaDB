package clases;
import java.text.*;

public class Medicamento {
	private int idMedicamento;
	private int cantidad;
	private String descMedicamento;
	private int dosisMat;
	private int dosisVesp;
	private int dosisNoct;
	private SimpleDateFormat fechaActualizacion;
	private String enfermero;
	
	public Medicamento() {
		this.idMedicamento = 0;
		this.cantidad = 0;
		this.descMedicamento = "";
		this.dosisMat = 0;
		this.dosisVesp = 0;
		this.dosisNoct = 0;
		this.fechaActualizacion = new SimpleDateFormat();
		this.enfermero = "";
	}

	public Medicamento(int idMedicamento, int cantidad, String descMedicamento, int dosisMat, int dosisVesp, int dosisNoct, SimpleDateFormat fechaActualizacion, String enfermero) {
		super();
		this.idMedicamento = idMedicamento;
		this.cantidad = cantidad;
		this.descMedicamento = descMedicamento;
		this.dosisMat = dosisMat;
		this.dosisVesp = dosisVesp;
		this.dosisNoct = dosisNoct;
		this.fechaActualizacion = fechaActualizacion;
		this.enfermero = enfermero;
	}

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescMedicamento() {
		return descMedicamento;
	}

	public void setDescMedicamento(String descMedicamento) {
		this.descMedicamento = descMedicamento;
	}

	public int getDosisMat() {
		return dosisMat;
	}

	public void setDosisMat(int dosisMat) {
		this.dosisMat = dosisMat;
	}

	public int getDosisVesp() {
		return dosisVesp;
	}

	public void setDosisVesp(int dosisVesp) {
		this.dosisVesp = dosisVesp;
	}

	public int getDosisNoct() {
		return dosisNoct;
	}

	public void setDosisNoct(int dosisNoct) {
		this.dosisNoct = dosisNoct;
	}

	public SimpleDateFormat getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(SimpleDateFormat fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	public String getEnfermero() {
		return enfermero;
	}

	public void setEnfermero(String enfermero) {
		this.enfermero = enfermero;
	}
	
	public int getDosisDiaria() {
		return dosisMat + dosisVesp + dosisNoct;
	}

}
