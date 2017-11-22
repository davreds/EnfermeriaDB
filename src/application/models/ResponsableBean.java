package application.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import application.classes.Responsable;

public class ResponsableBean {
	//Parametros conexion BD
	static final String JDBC_Driver = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/Enfermeria";
	static final String DB_USER = "encarnados";
	static final String DB_PASS = "amss";

	//Constructor
	public ResponsableBean() {
		try {
			Class.forName(JDBC_Driver);
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Responsable" + 
					"(idHuesp varchar(20), " + 
					"nomCompleto varchar(80), " + 
					"telefono varchar(15), " + 
					"CONSTRAINT FK_HuespResp FOREIGN KEY (idHuesp) REFERENCES Huesped(curp) On Delete Cascade, " + 
					"CONSTRAINT PK_Responsbale PRIMARY KEY (idHuesp, nomCompleto));";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	//Agregar Responsable a la BD
	public Responsable create(Responsable r) {
		try {
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			String sql = "INSERT INTO Huesped"
					+ "(idHuesp, nomCompleto, telefono)"
					+ "VALUES ('" + r.getIdHuesp()
					+ "', '" + r.getNomCompleto()
					+ "', '" + r.getTelefono() + "');";
			st.executeUpdate(sql);
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
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			String sql = "UPDATE Responsable SET telefono = '" + r.getTelefono()
			+ "' WHERE idHuesp = '" + r.getIdHuesp() + "' AND nomCompleto = '" + r.getNomCompleto() +  "';";
			st.executeUpdate(sql);
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
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Responsable "
					+ "WHERE idHuesp = '" + idHuesp + "' AND nomCompleto = '" + nomCompleto + "';");
			r.setTelefono(rs.getString("telefono"));
			rs.close();
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return r;
	}

	//Borrar Responsable de la BD
	public void delete(Responsable r) {
		try {
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			String sql = "DELETE FROM Responsable"
					+ " WHERE idHuesp = '" + r.getIdHuesp() + "' AND nomCompleto = '" + r.getNomCompleto() + "';";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//Buscar responsables
	public LinkedList<Responsable> search(String idHuesp){
		LinkedList<Responsable> lr = new LinkedList<Responsable>();
		try {
			Responsable temp = new Responsable();
			temp.setIdHuesp(idHuesp);
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Responsable "
					+ "WHERE idHuesp = '" + idHuesp + "';");
			while(rs.next()) {
				temp.setNomCompleto(rs.getString("nomCompleto"));
				temp.setTelefono(rs.getString("telefono"));
				lr.addLast(temp);
			}
			rs.close();
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lr;
	}
}
