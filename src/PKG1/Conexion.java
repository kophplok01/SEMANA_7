package PKG1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
	
	private static String url = "jdbc:mysql://localhost: 3306";
	private static String usuario= "root";
	private static String password = "123456";

	public static Connection conectar () {
		
		Connection conexion = null;
      
		
		try {
			
			
			conexion = DriverManager.getConnection(url, usuario, password);
			  Statement stmt = conexion.createStatement();
			  String sql = "CREATE DATABASE IF NOT EXISTS AUTOS1";

		         stmt.executeUpdate(sql);
		        
		         conexion = DriverManager.getConnection(url+"/AUTOS1", usuario, password);
		

		}catch(SQLException e){
			
			System.out.println("error "+ e.getMessage() );
			
		}
		return conexion;
			
		
	}
}
