package application.classes;

public class Responsable {
	//Atributos
	private String idHuesp;
	private String nomCompleto;
	private String telefono;
	
	//Constructor vacio
	public Responsable() {
		super();
		this.idHuesp = "";
		this.nomCompleto = "";
		this.telefono = "";
	}
	
	//Constructor con parametros
	public Responsable(String idHuesp, String nomCompleto, String telefono) {
		super();
		this.idHuesp = idHuesp;
		this.nomCompleto = nomCompleto;
		this.telefono = telefono;
	}
	
	//Metodos get y set
	public String getIdHuesp() {
		return idHuesp;
	}

	public void setIdHuesp(String idHuesp) {
		this.idHuesp = idHuesp;
	}

	public String getNomCompleto() {
		return nomCompleto;
	}

	public void setNomCompleto(String nomCompleto) {
		this.nomCompleto = nomCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
