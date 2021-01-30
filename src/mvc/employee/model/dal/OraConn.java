package mvc.employee.model.dal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

	
	public class OraConn {
		
		Connection connection = null;
		
		public OraConn() {
			registerDriver();
		}
		
		private void registerDriver() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Sterownik Oracle JDBC został zarejestrownay");
			} catch (ClassNotFoundException ex) {
				System.out.println("Brak sterownika JDBC.");
			}
		}
		
		public void setConnection(
		String host, String user, String password) {
			try {
				connection = DriverManager.getConnection(host, user, password);
			} catch (SQLException ex) {
				System.out.println("Błąd połączeia. Sprawdź nazwy hista, użytkownika i hasło." + System.lineSeparator() + ex.getMessage());
			}
		}
		
		public Connection getConnection() {
			return connection;

		}
		public void testConnection() {
			try {
				if (connection != null) {
					System.out.println("Połączono");
					connection.close();
					System.out.println("Rozłączono.");
				} else {
					System.out.println("Brak połączenia z bazą!");
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
