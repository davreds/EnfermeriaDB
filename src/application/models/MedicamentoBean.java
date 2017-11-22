package application.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;

import application.classes.Medicamento;

public class MedicamentoBean {
	//Parametros conexion BD
	static final String JDBC_Driver = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/Enfermeria";
	static final String DB_USER = "encarnados";
	static final String DB_PASS = "amss";
	private ResultSet rs = null;
	private Connection c = null;
	private Statement st = null;

	//Constructor
	public MedicamentoBean() {
		try {
			Class.forName(JDBC_Driver);
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Medicamento" + 
					"(idHuesp varchar(20), " + 
					"nomMedicamento varchar(50), " + 
					"cantidad int, " + 
					"fecAct Timestamp, " + 
					"conMat int, " + 
					"conVesp int, " + 
					"conNoct int, " + 
					"conTot int, " + 
					"CONSTRAINT FK_HuespMed FOREIGN KEY (idHuesp) REFERENCES Huesped(curp) On Delete Cascade, " + 
					"CONSTRAINT PK_Medicamento PRIMARY KEY (idHuesp, nomMedicamento));";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	//Agregar Medicamento a la BD
	public Medicamento create(Medicamento m) {
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "INSERT INTO Medicamento"
					+ "(idHuesp, nomMedicamento, cantidad, fecAct, conMat, conVesp, conNoct, conTot)"
					+ "VALUES ('" + m.getIdHuesp()
					+ "', '" + m.getNomMedicamento()
					+ "', " + m.getCantidad()
					+ ", '" + toTimestamp(m.getFecAct())
					+ "', " + m.getConMat()
					+ ", " + m.getConVesp()
					+ ", " + m.getConNoct()
					+ ", " + m.calcConsumo() + ");";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException ex){
			ex.printStackTrace();
		}
		return m;
	}

	//Modificar Medicamento en la BD
	public Medicamento update(Medicamento m) {
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "UPDATE Medicamento SET "
					+ "cantidad = " + m.getCantidad()
					+ ", fecAct = '" + toTimestamp(m.getFecAct())
					+ "', conMat = " + m.getConMat()
					+ ", conVesp = " + m.getConVesp()
					+ ", conNoct = " + m.getConNoct()
					+ ", conTot = " + m.calcConsumo()
					+ " WHERE idHuesp = '" + m.getIdHuesp() + "' AND nomMedicamento = '" + m.getNomMedicamento() + "';";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return m;
	}

	//Traer Medicamento de la BD
	public Medicamento retrieve(String idHuesp, String nomMedicamento) {
		Medicamento m = new Medicamento();
		m.setIdHuesp(idHuesp);
		m.setNomMedicamento(nomMedicamento);
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			rs = st.executeQuery("SELECT * FROM Medicamento WHERE idHuesp = '" + idHuesp	
					+ "' AND nomMedicamento = '" + nomMedicamento + "';");
			m.setCantidad(rs.getInt("cantidad"));
			m.setFecAct(toLocalDateTime(rs.getString("fecAct")));
			m.setConMat(rs.getInt("conMat"));
			m.setConVesp(rs.getInt("conVesp"));
			m.setConNoct(rs.getInt("conNoct"));
			rs.close();
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return m;
	}

	//Borrar Medicamento de la BD
	public void delete(Medicamento m) {
		try {
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			String sql = "DELETE FROM Medicamento"
					+ " WHERE idHuesp = '" + m.getIdHuesp() + "' AND nomMedicamento = '" + m.getNomMedicamento() + "';";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	//Medicamentos en reporte de pastillas
	public LinkedList<Medicamento> report(LocalDateTime date){
		LinkedList<Medicamento> lm = new LinkedList<Medicamento>();
		try {
			Medicamento temp = new Medicamento();
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			st = c.createStatement();
			rs = st.executeQuery("SELECT * FROM Medicamento;");
			while(rs.next()) {
				temp.setNomMedicamento(rs.getString("nomMedicamento"));
				temp.setCantidad(rs.getInt("cantidad"));
				temp.setFecAct(toLocalDateTime(rs.getString("fecAct")));
				temp.setConMat(rs.getInt("conMat"));
				temp.setConVesp(rs.getInt("conVesp"));
				temp.setConNoct(rs.getInt("conNoct"));
				if(!temp.availability(date))
					lm.addLast(temp);
			}
			rs.close();
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return lm;
	}

	//Transformaciones entre LocalDateTime y sql Timestamp
	private String toTimestamp(LocalDateTime ldt) {
		return ldt.toString().substring(0, 10) + " " + ldt.toString().substring(11,19);
	}

	private LocalDateTime toLocalDateTime(String timestamp) {
		return LocalDateTime.parse(timestamp.substring(0, 10) + "T" + timestamp.substring(11,19));
	}
	
}
