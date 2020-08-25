package hairrang.jdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	public static void main(String[] args) {
		//connection_test01();
		//conn_test02();
		
		//conn_test03();
		
	}

	private static void conn_test03() {
		try (Connection conn = JdbcUtil.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT GUEST_NO, GUEST_NAME FROM GUEST");) {
			while (rs.next()) {
				int deptNo = rs.getInt("GUEST_NO");
				String deptName = rs.getString("GUEST_NAME");
				
				System.out.printf("%d %s %n", deptNo, deptName);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private static void conn_test02() {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl?useSSL=false";
		String user = "user_erp";
		String pwd = "rootroot";
		
		try (Connection conn = DriverManager.getConnection(url, user, pwd);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select dept_no, dept_name, floor from Department");) {
			while (rs.next()) {
				int deptNo = rs.getInt("dept_no");
				String deptName = rs.getString("dept_name");
				int floor = rs.getInt("floor");
				System.out.printf("%d %s %d%n", deptNo, deptName, floor);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	private static void connection_test01() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			//1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2. 데이터베이스 커넥션 생성 
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl?useSSL=false", "user_erp", "rootroot");
			// 3. Statement 생성
			stmt = conn.createStatement();
			// 4. 쿼리 실행
			rs = stmt.executeQuery("select dept_no, dept_name, floor from Department");
			// 5. 쿼리 실행 결과 출력
			while (rs.next()) {
				int deptNo = rs.getInt("dept_no");
				String deptName = rs.getString("dept_name");
				int floor = rs.getInt("floor");
				System.out.printf("%d %s %d%n", deptNo, deptName, floor);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} finally {
			if (rs != null)
				try { rs.close(); } catch (SQLException ex) {} // 6. 사용한 ResultSet 종료(select 인 경우)
			if (stmt != null)
				try { stmt.close(); } catch (SQLException ex) {} // 7. 사용한 Statement 종료
			if (conn != null)
				try { conn.close(); } catch (SQLException ex) {} // 8. 커넥션 종료
		}
	}
}
