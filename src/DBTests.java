import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBTests {
	public static void main(String[] args) {
		try {
			Class.forName("org.h2.Driver");
			Connection c = DriverManager.getConnection("jdbc:h2:../DB");
			Statement st = c.createStatement();
			String sql = "CREATE TABLE HUESPED" +
						 "(curp				VARCHAR(20) PRIMARY KEY NOT NULL, " +
						 "nombres			VARCHAR(42) NOT NULL, " +
						 "apellidos			VARCHAR(42) NOT NULL, " +
						 "fechaNacimiento	date, " +
						 "sexo				char, " +
						 "fotografia		VARCHAR(2083), " +
						 "fechaIngreso		date, " +
						 "status			VARCHAR(20), " +
						 "numCuarto			int, " +
						 "numCama			int, " +
						 "descPadecimientos	TEXT);";
			st.executeUpdate(sql);
			st.close();
			c.close();
		}
		catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getClass().getName()+ ": "+e.getMessage());
			System.exit(0);
		}
	}
}
