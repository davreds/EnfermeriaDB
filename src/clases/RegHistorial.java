package clases;
import java.text.*;

public class RegHistorial {
	private int numRegistro;
	private String tipoRegistro;
	private SimpleDateFormat fechaRegistro;
	private String descRegistro;
	private String enfermero;
	
	public RegHistorial() {
		super();
		this.numRegistro = 0;
		this.tipoRegistro = "";
		this.fechaRegistro = new SimpleDateFormat();
		this.descRegistro = "";
		this.enfermero = "";
	}
	
	public RegHistorial(int numRegistro, String tipoRegistro, SimpleDateFormat fechaRegistro, String descRegistro, String enfermero) {
		super();
		this.numRegistro = numRegistro;
		this.tipoRegistro = tipoRegistro;
		this.fechaRegistro = fechaRegistro;
		this.descRegistro = descRegistro;
		this.enfermero = enfermero;
	}

	public int getNumRegistro() {
		return numRegistro;
	}

	public void setNumRegistro(int numRegistro) {
		this.numRegistro = numRegistro;
	}

	public String getTipoRegistro() {
		return tipoRegistro;
	}

	public void setTipoRegistro(String tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}

	public SimpleDateFormat getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(SimpleDateFormat fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getDescRegistro() {
		return descRegistro;
	}

	public void setDescRegistro(String descRegistro) {
		this.descRegistro = descRegistro;
	}

	public String getEnfermero() {
		return enfermero;
	}

	public void setEnfermero(String enfermero) {
		this.enfermero = enfermero;
	}
	
}
