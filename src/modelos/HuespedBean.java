package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import clases.Huesped;

public class HuespedBean {
	//Parametros conexion BD
	static final String JDBC_Driver = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/Enfermeria";
	static final String DB_USER = "encarnados";
	static final String DB_PASS = "amss";
	private ResultSet rs = null;
	private Connection c = null;
	private Statement st = null;

	//Constructor
	public HuespedBean() {
		try {
			Class.forName(JDBC_Driver);
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "CREATE TABLE IF DOESN'T EXIST Huesped" + 
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
			st.executeQuery(sql);
			st.close();
			c.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	//Agregar Huesped a la BD
	public Huesped create(Huesped h) {
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "INSERT INTO TABLE Huesped("
					+ "(curp, primNombre, segNombre, primApellido, segApellido, fecNac, sexo, foto, fecIng, status, numCuarto, numCama. descPad)"
					+ "VALUES (" + h.getCurp()
					+ ", " + h.getPrimNombre()
					+ ", " + h.getSegNombre()
					+ ", " + h.getPrimApellido()
					+ ", " + h.getSegApellido()
					+ ", " + h.getFecNac().toString()
					+ ", " + h.getSexo()
					+ ", " + h.getFoto()
					+ ", " + h.getFecIng().toString()
					+ ", " + h.getStatus()
					+ ", " + h.getNumCuarto()
					+ ", " + h.getNumCama()
					+ ", " + h.getDescPad() + ");";
			st.executeQuery(sql);
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
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "UPDATE Huesped SET "
					+ "primNombre = " + h.getPrimNombre()
					+ ", segNombre = " + h.getSegNombre()
					+ ", primAmpellido = " + h.getPrimApellido()
					+ ", segApellido = " + h.getSegApellido()
					+ ", fecNac = " + h.getFecNac().toString()
					+ ", sexo =" + h.getSexo()
					+ ", foto = " + h.getFoto()
					+ ", fecIng = " + h.getFecIng().toString()
					+ ", status = " + h.getStatus()
					+ ", numCuarto = " + h.getNumCuarto()
					+ ", numCama = " + h.getNumCama()
					+ ", descPad = " + h.getDescPad()
					+ " WHERE curp = " + h.getCurp() + ";";
			st.executeQuery(sql);
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
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			rs = st.executeQuery("SELECT * FROM Huesped WHERE curp = " + curp + ";");
			h.setPrimNombre(rs.getString("primerNombre"));
			h.setSegNombre(rs.getString("segundoNombre"));
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
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "DELETE FROM Huesped"
					+ "WHERE curp = " + h.getCurp() + ";";
			st.executeQuery(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
