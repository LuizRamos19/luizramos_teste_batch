package batch.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Singleton {
	private static Singleton instancia;
	private Connection con;
	private String host = "//systemcall.database.windows.net:1433/db_call_manager";
	private String user = "luiz";
	private String password = "Modelo.10";
	private Singleton() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:jtds:sqlserver:"+host, user, password);
			System.out.println("Conexão estabelecida com sucesso ao banco de dados na nuvem!\n");
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Classe de banco de dados não encontrada");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Conexão entre o banco de dados não pode ser estabelecida");
		}			
	}
	public Connection getConnection() { 
		return con;
	}
	public synchronized static Singleton getInstance() {
		if (instancia == null) { 
			instancia = new Singleton();
		}
		return instancia;
	}
}
