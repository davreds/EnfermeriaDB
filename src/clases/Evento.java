package clases;

import java.time.LocalDateTime;

public class Evento {
	//Atributos de la clase
	private String idHuesp;
	private int numEvento;
	private String tipoEvento;
	private LocalDateTime fecReg;
	private String descEvento;
	private String nomEnfermero;
	private boolean bReceta;
	private String dirReceta;
	
	//Constructor vacio
	public Evento() {
		super();
		this.idHuesp = "";
		this.numEvento = 0;
		this.tipoEvento = "";
		this.fecReg = LocalDateTime.of(0, 1, 1, 0, 0, 0);
		this.descEvento = "";
		this.nomEnfermero = "";
		this.bReceta = false;
		this.dirReceta = "";
	}
	
	//Constructor con parametros
	public Evento(String idHuesp, int numEvento, String tipoEvento, LocalDateTime fecReg, String descEvento,
			String enfermero, String dirReceta) {
		super();
		this.idHuesp = idHuesp;
		this.numEvento = numEvento;
		this.tipoEvento = tipoEvento;
		this.fecReg = fecReg;
		this.descEvento = descEvento;
		this.nomEnfermero = enfermero;
		this.dirReceta = dirReceta;
		this.bReceta = (dirReceta != "");
	}

	//Metodos get y set
	public String getIdHuesp() {
		return idHuesp;
	}
	
	public void setIdHuesp(String idHuesp) {
		this.idHuesp = idHuesp;
	}
	
	public int getNumEvento() {
		return numEvento;
	}

	public void setNumEvento(int numEvento) {
		this.numEvento = numEvento;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public LocalDateTime getFecReg() {
		return fecReg;
	}

	public void setFecReg(LocalDateTime fecReg) {
		this.fecReg = fecReg;
	}

	public String getDescEvento() {
		return descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public String getNomEnfermero() {
		return nomEnfermero;
	}

	public void setNomEnfermero(String enfermero) {
		this.nomEnfermero = enfermero;
	}

	public boolean hasReceta() {
		return bReceta;
	}

	public String getDirReceta() {
		return dirReceta;
	}

	public void setDirReceta(String dirReceta) {
		this.dirReceta = dirReceta;
		this.bReceta = (dirReceta != "");
	}
}
