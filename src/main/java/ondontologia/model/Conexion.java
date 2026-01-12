package ondontologia.model;

import java.sql.*;


public class Conexion {
	
	private static String URL="jdbc:mysql://localhost:3306/odontologo?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	private static String USER="root";
	private static String PASSWORD="";

	public static Connection getConexion() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
}
