import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VeriTabani {
	Connection c = null;
	public VeriTabani() {
		
	}
	public Connection connDb() {
		try {
			this.c = DriverManager.getConnection("jdbc:mariadb://localhost:3325/dukkan?user=root&password=1234");
			return c;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}
	
}
