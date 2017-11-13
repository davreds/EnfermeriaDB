package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import clases.Huesped;

public class modeloHuesped {
	public modeloHuesped() {
		
	}
	
	public void agregarHuesped(Huesped huesp) {
		try {
			Class.forName("org.h2.Driver");
			Connection c = DriverManager.getConnection("jdbc:h2:../DB");
			Statement st = c.createStatement();
			String sql = "INSERT INTO HUESPED (curp, nombres, apellidos, fechaNacimiento, sexo, fotografia, fechaIngreso, status, numCuarto, numCama, descPadecimientos); +" +
							"VALUES("+ huesp.getCurp() + ", " + 
							huesp.getNombres() + ", " + 
							huesp.getApellidos() + ", " + 
							huesp.fechaNacimientotoString() + ", " + 
							huesp.getSexo() + ", " + 
							huesp.getFotografia() + ", " + 
							huesp.fechaIngresotoString() + ", " + 
							huesp.getStatus() + ", " + 
							huesp.numCuartotoString() + ", " + 
							huesp.numCamatoString() + ", " + 
							huesp.getDescPadecimientos() + ");";
			st.executeUpdate(sql);
			st.close();
			c.close();
		} catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getClass().getName()+ ": "+e.getMessage());
			System.exit(0);
		}
	}
	
	public Huesped pedirHuesped(String curp) {
		try {
			Class.forName("org.h2.Driver");
			Connection c = DriverManager.getConnection("jdbc:h2:../DB");
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM HUESPED");
			String curp;
			String nombres;
			String apellidos;
			SimpleDateFormat fechaNacimiento;;
			char sexo;
			String fotografia;
			SimpleDateFormat fechaIngreso;
			String status;
			int numCuarto;
			int numCama;
			String descPadecimientos;
			while(rs.next()) {
				String curp rs.getString("curp");
				status = rs.getString("status");
				nombres = rs.getString("nombres");
				apellidos = rs.getString("apellidos");
				fechaNacimiento = new SimpleDateFormat(rs.getString("fechaNacimiento"));
				sexo = rs.getString("sexo").charAt(0);
				fotografia = rs.getString("fotografia");
				fechaIngreso = new SimpleDateFormat(rs.getString("fechaIngreso"));
				numCuarto = rs.getInt("numCuarto");
				numCama = rs.getInt("numCama");
				descPadecimientos = rs.getString("descPadecimientos");
			}
			rs.close();
			st.close();
			c.close();
			Huesped ret = new Huesped(curp, status, nombres, apellidos, fechaNacimiento, sexo, fotografia, fechaIngreso, descPadecimientos, numCuarto, numCama);
			return ret;
		} catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getClass().getName()+ ": "+e.getMessage());
			System.exit(0);
		}
		
	}
}
