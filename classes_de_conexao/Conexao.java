package classes_de_conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane; 

public class Conexao {
	
	private static String driver = "org.postgresql.Driver";
	private static String user = "postgres";
	private static String password = "docker";
	private static String url = "jdbc:postgresql://localhost:5432/metabase";
	
	public static Connection faz_conexao() throws SQLException {
		
		try {
			
			Class.forName(driver);
			Connection db = null;
			
			db = (Connection) DriverManager.getConnection(url, user, password);
			//JOptionPane.showMessageDialog(null, "Conexão bem-sucedida!");
			return db;
			
		} catch (ClassNotFoundException error) {
			//JOptionPane.showMessageDialog(null, "Não foi possível conectar!");
			throw new SQLException(error.getException());			
		}
	}
}
