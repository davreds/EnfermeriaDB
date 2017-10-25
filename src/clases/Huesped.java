package clases;
import java.text.*;

public class Huesped {
	//Atributos de la clase
	private String curp;
	private String status;
	private String nombres;
	private String apellidos;
	private SimpleDateFormat fechaNacimiento;
	private char sexo;
	private String fotografia;
	private SimpleDateFormat fechaIngreso;
	private String descPadecimientos;
	private int numCuarto;
	private int numCama;
	
	public Huesped() {
		this.curp = "";
		this.status = "";
		this.nombres = "";
		this.apellidos = "";
		this.fechaNacimiento = new SimpleDateFormat();
		this.sexo = 0;
		this.fotografia = "";
		this.fechaIngreso = new SimpleDateFormat();
		this.descPadecimientos = "";
		this.numCuarto = 0;
		this.numCama = 0;
	}
	
	public Huesped(String curp, String status, String nombres, String apellidos, SimpleDateFormat fechaNacimiento, char sexo, String fotografia, SimpleDateFormat fechaIngreso, String descPadecimientos, int numCuarto, int numCama) {
		this.curp = curp;
		this.status = status;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.fotografia = fotografia;
		this.fechaIngreso = fechaIngreso;
		this.descPadecimientos = descPadecimientos;
		this.numCuarto = numCuarto;
		this.numCama = numCama;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public SimpleDateFormat getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(SimpleDateFormat fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getFotografia() {
		return fotografia;
	}

	public void setFotografia(String fotografia) {
		this.fotografia = fotografia;
	}

	public SimpleDateFormat getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(SimpleDateFormat fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getDescPadecimientos() {
		return descPadecimientos;
	}

	public void setDescPadecimientos(String descPadecimientos) {
		this.descPadecimientos = descPadecimientos;
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
	
	
}
