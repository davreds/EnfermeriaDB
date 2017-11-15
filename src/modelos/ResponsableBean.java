package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Responsable;

public class ResponsableBean {
	//Parametros conexion BD
	static final String JDBC_Driver = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/Enfermeria";
	static final String DB_USER = "encarnados";
	static final String DB_PASS = "amss";
	private ResultSet rs = null;
	private Connection c = null;
	private Statement st = null;

	//Constructor
	public ResponsableBean() {
		try {
			Class.forName(JDBC_Driver);
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "CREATE TABLE IF DOESN'T EXIST Responsable" + 
					"(idHuesp varchar(20), " + 
					"nomCompleto varchar(80), " + 
					"telefono varchar(15), " + 
					"CONSTRAINT FK_HuespResp FOREIGN KEY (idHuesp) REFERENCES Huesped(curp) On Delete Cascade, " + 
					"CONSTRAINT PK_Responsbale PRIMARY KEY (idHuesp, nomCompleto));";
			st.executeQuery(sql);
			st.close();
			c.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	//Agregar Responsable a la BD
	public Responsable create(Responsable r) {
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "INSERT INTO TABLE Huesped("
					+ "(idHuesp, nomCompleto, telefono)"
					+ "VALUES (" + r.getIdHuesp()
					+ ", " + r.getNomCompleto()
					+ ", " + r.getTelefono() + ");";
			st.executeQuery(sql);
			st.close();
			c.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return r;
	}

	//Modificar Responsable en la BD
	public Responsable update(Responsable r) {
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "UPDATE Responsable SET telefono = " + r.getTelefono()
			+ " WHERE idHuesp = " + r.getIdHuesp() + "AND nomCompleto = " + r.getNomCompleto() +  ";";
			st.executeQuery(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return r;
	}

	//Traer Responsable de la BD
	public Responsable retrieve(String idHuesp, String nomCompleto) {
		Responsable r = new Responsable();
		r.setIdHuesp(idHuesp);
		r.setNomCompleto(nomCompleto);
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			rs = st.executeQuery("SELECT * FROM Huesped"
					+ "WHERE idHuesp = " + idHuesp + "AND nomCompleto = " + nomCompleto + ";");
			r.setTelefono(rs.getString("telefono"));
			rs.close();
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return r;
	}

	//Borrar Huesped de la BD
	public void delete(Responsable r) {
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "DELETE FROM Responsable"
					+ "WHERE idHuesp = " + r.getIdHuesp() + "AND nomCompleto = " + r.getNomCompleto() + ";";
			st.executeQuery(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
