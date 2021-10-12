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
	public static String [] modelos;
	
	PreparedStatement preparedStatement1 = null;
	ResultSet resultSet1 = null;
	
	public void REGISTRAR_MARCA (String Marca) {
		
		conexion = Conexion.conectar();
		try {	
	Statement stmt = conexion.createStatement();
			
    String sql = "CREATE TABLE IF NOT EXISTS MARCAS" +
            "(MARCA VARCHAR (20) not NULL, " +
            " PRIMARY KEY ( MARCA ))";
    
    stmt.executeUpdate(sql);
			
		} catch(SQLException e1) 
		{JOptionPane.showMessageDialog(null, e1.getMessage());
		
		};
		
		
	
	
	
	try {
		
		preparedStatement = conexion.prepareStatement("Insert into MARCAS (MARCA) values (?)" );
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
    		
    		preparedStatement = conexion.prepareStatement("SELECT * FROM autos.marcas" );
    		resultSet = preparedStatement.executeQuery();
    	
    	
    		
    	}catch(SQLException e4){
    		JOptionPane.showMessageDialog(null, e4.getMessage());
    	};
    	
    	return resultSet;
    	
    }
    
    public ResultSet LISTA_DE_LINEAS (String Marca) {
    	conexion = Conexion.conectar();
    	try {
    		
    		preparedStatement = conexion.prepareStatement("SELECT * FROM autos."+Marca );
    		resultSet = preparedStatement.executeQuery();
    	
    	
    		
    	}catch(SQLException e4){
    		JOptionPane.showMessageDialog(null, e4.getMessage());
    	};
    	
    	return resultSet;
    	
    }
    
    public String [] Modelo (String Marca, String Linea) {
    	conexion = Conexion.conectar();
   
    	try {
    		
    		preparedStatement = conexion.prepareStatement("SELECT MODELO_RG_INI FROM autos."+Marca+"  WHERE LINEA = '"+Linea+"'");
    		resultSet = preparedStatement.executeQuery();
    		resultSet.next();
    		preparedStatement1 = conexion.prepareStatement("SELECT MODELO_RG_FIN FROM autos."+Marca+"  WHERE LINEA = '"+Linea+"'");
    		resultSet1 = preparedStatement1.executeQuery();
    		resultSet1.next();
    		
    		
    		String foundType = resultSet.getString(1);
    		String foundTyp2e = resultSet1.getString(1);
    		int ini = Integer.parseInt(foundType);
    		int fin = Integer.parseInt(foundTyp2e);
    		int h = fin - ini;
    		int [] numeros = new int [h+1];
    		modelos = new String [h+1];
    		int i = 0;
    		int cont = 0;
    		int cont2 = 0;
    	      for (i = ini; i <= fin; i++) {
    	    	  numeros [cont] = i;
    	    	  cont= cont+1;
    	        
    	        }
    	
    		
    		 for (i = ini; i <=fin; i++) {
   	    	  modelos [cont2] = String.valueOf(numeros[cont2]);
   	    	  cont2= cont2+1;
   	        
   	        }
    		 
    	}catch(SQLException e4){
    		JOptionPane.showMessageDialog(null, e4.getMessage());
    	};
    	
  
		return modelos;
    	
    }
}
