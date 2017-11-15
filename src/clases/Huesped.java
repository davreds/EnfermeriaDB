package clases;

import java.time.LocalDate;

public class Huesped {
	//Atributos de la clase
	private String curp;
	private String primNombre;
	private String segNombre;
	private String primApellido;
	private String segApellido;
	private LocalDate fecNac;
	private char sexo;
	private String foto;
	private LocalDate fecIng;
	private String status;
	private int numCuarto;
	private int numCama;
	private String descPad;

	//Constructor vacio
	public Huesped() {
		super();
		this.curp = "";
		this.primNombre = "";
		this.segNombre = "";
		this.primNombre = "";
		this.segNombre = "";
		this.fecNac = LocalDate.of(0,1,1);
		this.sexo = 0;
		this.foto = "";
		this.fecIng = LocalDate.of(0,1,1);
		this.status = "";
		this.numCuarto = 0;
		this.numCama = 0;
		this.descPad = "";
	}
	
	//Constructor con parametros
	public Huesped(String curp, String primNombre, String segNombre, String primApellido,
			String segApellido, LocalDate fecNac, char sexo, String foto, LocalDate fecIng,
			String status, int numCuarto, int numCama, String descPad) {
		super();
		this.curp = curp;
		this.primNombre = primNombre;
		this.segNombre = segNombre;
		this.primApellido = primApellido;
		this.segApellido = segApellido;
		this.fecNac = fecNac;
		this.sexo = sexo;
		this.foto= foto;
		this.fecIng = fecIng;
		this.status = status;
		this.numCuarto = numCuarto;
		this.numCama = numCama;
		this.descPad = descPad;
	}
	
	
	//Metodos get y set
	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getPrimNombre() {
		return primNombre;
	}

	public void setPrimNombre(String primNombre) {
		this.primNombre = primNombre;
	}

	public String getSegNombre() {
		return segNombre;
	}

	public void setSegNombre(String segNombre) {
		this.segNombre = segNombre;
	}

	public String getPrimApellido() {
		return primApellido;
	}

	public void setPrimApellido(String primApellido) {
		this.primApellido = primApellido;
	}

	public String getSegApellido() {
		return segApellido;
	}

	public void setSegApellido(String segApellido) {
		this.segApellido = segApellido;
	}

	public LocalDate getFecNac() {
		return fecNac;
	}

	public void setFecNac(LocalDate fecNac) {
		this.fecNac = fecNac;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getFecIng() {
		return fecIng;
	}

	public void setFecIng(LocalDate fecIng) {
		this.fecIng = fecIng;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getNumCuarto() {
		return numCuarto;
	}

	public void setNumCuarto(int numCuarto) {
		this.numCuarto = numCuarto;
	}

	public int getNumCama() {
		return numCama;
	}

	public void setNumCama(int numCama) {
		this.numCama = numCama;
	}

	public String getDescPad() {
		return descPad;
	}

	public void setDescPad(String descPad) {
		this.descPad = descPad;
	}

}
