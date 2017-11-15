package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import clases.Medicamento;

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
			String sql = "CREATE TABLE IF DOESN'T EXIST Medicamento" + 
					"(idHuesp varchar(20), " + 
					"nomMedicamento varchar(50), " + 
					"cantidad int, " + 
					"fecAct Timestamp, " + 
					"conMat int, " + 
					"conVesp int, " + 
					"conNoct int, " + 
					"conTot int, " + 
					"numEV int, " + 
					"nomEnfermero varchar(80), " + 
					"CONSTRAINT FK_EventoMed FOREIGN KEY (numEV) REFERENCES Evento(numEvento), " + 
					"CONSTRAINT FK_HuespMed FOREIGN KEY (idHuesp) REFERENCES Huesped(curp) On Delete Cascade, " + 
					"CONSTRAINT PK_Medicamento PRIMARY KEY (idHuesp, nomMedicamento));";
			st.executeQuery(sql);
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
			String sql = "INSERT INTO TABLE Medicamento("
					+ "(idHuesp, nomMedicamento, cantidad, fecAct, conMat, conVesp, conNoct, conTot, numEv, nomEnfermero)"
					+ "VALUES (" + m.getIdHuesp()
					+ ", " + m.getNomMedicamento()
					+ ", " + m.getCantidad()
					+ ", " + toTimestamp(m.getFecAct())
					+ ", " + m.getConMat()
					+ ", " + m.getConVesp()
					+ ", " + m.getConNoct()
					+ ", " + m.calcConsumo()
					+ ", " + m.getNumEv()
					+ ", " + m.getNomEnfermero() + ";";
			st.executeQuery(sql);
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
					+ ", fecAct = " + toTimestamp(m.getFecAct())
					+ ", conMat = " + m.getConMat()
					+ ", conVesp = " + m.getConVesp()
					+ ", conNoct = " + m.getConNoct()
					+ ", conTot = " + m.calcConsumo()
					+ ", numEv = " + m.getNumEv()
					+ ", nomEnfermero = " + m.getNomEnfermero()
					+ "WHERE idHuesp = " + m.getIdHuesp() + " AND nomMedicamento = " + m.getNomMedicamento() + ";";
			st.executeQuery(sql);
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
			rs = st.executeQuery("SELECT * FROM Medicamento WHERE idHuesp = " + idHuesp	
					+ " AND nomMedicamento = " + nomMedicamento + ";");
			m.setCantidad(rs.getInt("cantidad"));
			m.setFecAct(toLocalDateTime(rs.getString("fecAct")));
			m.setConMat(rs.getInt("conMat"));
			m.setConVesp(rs.getInt("conVesp"));
			m.setConNoct(rs.getInt("conNoct"));
			m.setNumEv(rs.getInt("numEv"));
			m.setNomEnfermero(rs.getString("nomEnfermero"));
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
					+ "WHERE idHuesp = " + m.getIdHuesp() + " AND nomMedicamento = " + m.getNomMedicamento() + ";";
			st.executeQuery(sql);
			st.close();
			c.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	//Transformaciones entre LocalDateTime y sql Timestamp
	private String toTimestamp(LocalDateTime ldt) {
		return ldt.toString().substring(0, 9) + " " + ldt.toString().substring(11);
	}

	private LocalDateTime toLocalDateTime(String timestamp) {
		return LocalDateTime.parse(timestamp.substring(0, 9) + "T" + timestamp.substring(11));
	}

}
