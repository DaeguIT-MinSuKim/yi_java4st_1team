package hairrang.conn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	public static Connection getConnection() {
		
		Connection con = null;
		String proptiesPath = "Db.properties";
		
		try (InputStream is = ClassLoader.getSystemResourceAsStream(proptiesPath)) {
			
			Properties props = new Properties();
			props.load(is);
			
			String url = props.getProperty("url");
			con = DriverManager.getConnection(url, props);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return con;
	}
}