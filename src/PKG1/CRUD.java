package PKG1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CRUD {
	
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	PreparedStatement preparedStatement1 = null;
	ResultSet resultSet1 = null;
	
	public void REGISTRAR_MARCA (String Marca) {
		
		conexion = Conexion.conectar();
		try {	
	Statement stmt = conexion.createStatement();
			
    String sql = "CREATE TABLE IF NOT EXISTS MARCAS2" +
            "(MARCA VARCHAR (20) not NULL, " +
            " PRIMARY KEY ( MARCA ))";
    
    stmt.executeUpdate(sql);
			
		} catch(SQLException e1) 
		{JOptionPane.showMessageDialog(null, e1.getMessage());
		
		};
		
		
	
	
	
	try {
		
		preparedStatement = conexion.prepareStatement("Insert into MARCAS2 (MARCA) values (?)" );
		preparedStatement.setString(1, Marca);
		
		int resultado = preparedStatement.executeUpdate();
		if (resultado > 0) {
			JOptionPane.showMessageDialog(null, "Nueva Marca añadida");
			Statement stmt = conexion.createStatement();
			
		    String sql = "CREATE TABLE IF NOT EXISTS "+Marca+" " +
		            "(LINEA VARCHAR (20) not NULL, " +
		            "MODELO_RG_INI VARCHAR (20) not NULL, " +
		            "MODELO_RG_FIN VARCHAR (20) not NULL, " +
		            " PRIMARY KEY ( LINEA ))";
		    
		    

		  stmt.executeUpdate(sql);
			
		}
		
	} catch (SQLException e2) {
		
		if (e2.getErrorCode()== 1062) {
			
			JOptionPane.showMessageDialog(null, "La Marca '"+ Marca + "' ya se encuentra registrada en la base de datos");
		}else {

			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	
	
	};

	public void REGISTRAR_LINEA (String Marca, String Linea, String M_Ini, String M_Fin) {
		
		conexion = Conexion.conectar();
	
	try {
		
		preparedStatement = conexion.prepareStatement("Insert into "+Marca+" (LINEA, MODELO_RG_INI, MODELO_RG_FIN) values (?,?,?)" );
		preparedStatement.setString(1, Linea);
		preparedStatement.setString(2, M_Ini);
		preparedStatement.setString(3, M_Fin);
		
		
		int resultado = preparedStatement.executeUpdate();
		if (resultado > 0) {
			JOptionPane.showMessageDialog(null, "Nuevos Registros añadidos para la Marca: "+Marca);
			
			
		}
		
	} catch (SQLException e2) {
		
		if (e2.getErrorCode()== 1062) {
			
			JOptionPane.showMessageDialog(null, "La Linea '"+ Linea + "' ya se encuentra registrada en la base de datos");
		}else {

			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
	
	
	};

    public ResultSet LISTA_DE_MARCAS () {
    	conexion = Conexion.conectar();
    	try {
    		
    		preparedStatement = conexion.prepareStatement("SELECT * FROM autos1.marcas2" );
    		resultSet = preparedStatement.executeQuery();
    	
    	
    		
    	}catch(SQLException e4){
    		JOptionPane.showMessageDialog(null, e4.getMessage());
    	};
    	
    	return resultSet;
    	
    }
    
    public ResultSet LISTA_DE_LINEAS (String Marca) {
    	conexion = Conexion.conectar();
    	try {
    		
    		preparedStatement = conexion.prepareStatement("SELECT * FROM autos1."+Marca );
    		resultSet = preparedStatement.executeQuery();
    	
    	
    		
    	}catch(SQLException e4){
    		JOptionPane.showMessageDialog(null, e4.getMessage());
    	};
    	
    	return resultSet;
    	
    }
    
    public ResultSet Modelo (String Marca, String Linea) {
    	conexion = Conexion.conectar();
    	try {
    		
    		JOptionPane.showMessageDialog(null, Linea + Marca);
    		preparedStatement = conexion.prepareStatement("SELECT MODELO_RG_FIN FROM autos1."+Marca+ " WHERE LINEA = '"+Linea+"'" );
    		resultSet = preparedStatement.executeQuery();
    		
    		JOptionPane.showMessageDialog(null,resultSet.toString());
    	
    		
    		
    	}catch(SQLException e4){
    		JOptionPane.showMessageDialog(null, e4.getMessage());
    	};
    	
    	return resultSet;
    	
    }
}
