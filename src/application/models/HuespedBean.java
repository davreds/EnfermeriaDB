package application.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;

import application.classes.Huesped;

public class HuespedBean {
	//Parametros conexion BD
	static final String JDBC_Driver = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/Enfermeria";
	static final String DB_USER = "encarnados";
	static final String DB_PASS = "amss";

	//Constructor
	public HuespedBean() {
		try {
			Class.forName(JDBC_Driver);
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Huesped" + 
					"(curp varchar(20)," + 
					"primNombre varchar(20)," + 
					"segNombre varchar(20)," + 
					"primApellido varchar(20)," + 
					"segApellido varchar(20)," + 
					"fecNac Date," + 
					"sexo Char," + 
					"foto varchar(200)," + 
					"fecIng Date," + 
					"status varchar(20)," + 
					"numCuarto int," + 
					"numCama int," + 
					"descPad varchar(500)," + 
					"CONSTRAINT PK_Huesped PRIMARY KEY (curp));";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	//Agregar Huesped a la BD
	public Huesped create(Huesped h) {
		try {
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			String sql = "INSERT INTO Huesped"
					+ "(curp, primNombre, segNombre, primApellido, segApellido, fecNac, sexo, foto, fecIng, status, numCuarto, numCama, descPad)"
					+ "VALUES ('" + h.getCurp()
					+ "', '" + h.getPrimNombre()
					+ "', '" + h.getSegNombre()
					+ "', '" + h.getPrimApellido()
					+ "', '" + h.getSegApellido()
					+ "', '" + h.getFecNac().toString()
					+ "', '" + h.getSexo()
					+ "', '" + h.getFoto()
					+ "', '" + h.getFecIng().toString()
					+ "', '" + h.getStatus()
					+ "', " + h.getNumCuarto()
					+ ", " + h.getNumCama()
					+ ", '" + h.getDescPad() + "');";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return h;
	}

	//Modificar Huesped en la BD
	public Huesped update(Huesped h) {
		try {
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			String sql = "UPDATE Huesped SET "
					+ "primNombre = '" + h.getPrimNombre()
					+ "', segNombre = '" + h.getSegNombre()
					+ "', primApellido = '" + h.getPrimApellido()
					+ "', segApellido = '" + h.getSegApellido()
					+ "', fecNac = '" + h.getFecNac().toString()
					+ "', sexo = '" + h.getSexo()
					+ "', foto = '" + h.getFoto()
					+ "', fecIng = '" + h.getFecIng().toString()
					+ "', status = '" + h.getStatus()
					+ "', numCuarto = " + h.getNumCuarto()
					+ ", numCama = " + h.getNumCama()
					+ ", descPad = '" + h.getDescPad()
					+ "' WHERE curp = '" + h.getCurp() + "';";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return h;
	}

	//Traer Huesped de la BD
	public Huesped retrieve(String curp) {
		Huesped h = new Huesped();
		h.setCurp(curp);
		try {
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Huesped WHERE curp = '" + curp + "';");
			h.setPrimNombre(rs.getString("primNombre"));
			h.setSegNombre(rs.getString("segNombre"));
			h.setPrimApellido(rs.getString("primApellido"));
			h.setSegApellido(rs.getString("segApellido"));
			h.setFecNac(LocalDate.parse(rs.getString("fecNac")));
			h.setSexo(rs.getString("sexo").charAt(0));
			h.setFoto(rs.getString("foto"));
			h.setFecIng(LocalDate.parse(rs.getString("fecIng")));
			h.setStatus(rs.getString("status"));
			h.setNumCuarto(rs.getInt("numCuarto"));
			h.setNumCama(rs.getInt("numCama"));
			h.setDescPad(rs.getString("descPad"));
			rs.close();
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return h;
	}

	//Borrar Huesped de la BD
	public void delete(Huesped h) {
		try {
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			String sql = "DELETE FROM Huesped"
					+ " WHERE curp = '" + h.getCurp() + "';";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//Busca todos los huespedes que cumplen con una condicion de busqueda
	public LinkedList<Huesped> search(String dato){
		LinkedList<Huesped> ll = new LinkedList<>();
		try {
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * "
					+ "FROM Huesped "
					+ "WHERE primNombre like '%" + dato + "%' "
					+ "OR segNombre like '%" + dato + "%' "
					+ "OR primApellido like '%" + dato + "%'"
					+ "OR segApellido like '%" + dato + "%';");
			Huesped temp = new Huesped();
			while(rs.next()) {
				temp.setCurp(rs.getString("curp"));
				temp.setPrimNombre(rs.getString("primNombre"));
				temp.setSegNombre(rs.getString("segNombre"));
				temp.setPrimApellido(rs.getString("primApellido"));
				temp.setSegApellido(rs.getString("segApellido"));
				temp.setFecNac(LocalDate.parse(rs.getString("fecNac")));
				temp.setSexo(rs.getString("sexo").charAt(0));
				temp.setFoto(rs.getString("foto"));
				temp.setFecIng(LocalDate.parse(rs.getString("fecIng")));
				temp.setStatus(rs.getString("status"));
				temp.setNumCuarto(rs.getInt("numCuarto"));
				temp.setNumCama(rs.getInt("numCama"));
				temp.setDescPad(rs.getString("descPad"));
				ll.addLast(temp);
			}
			rs.close();
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return ll;
	}
	/*
	public boolean exists(String curp) {
		try {	S
			Connection c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			Statement st = c.createStatement();
		}
	}*/
}
