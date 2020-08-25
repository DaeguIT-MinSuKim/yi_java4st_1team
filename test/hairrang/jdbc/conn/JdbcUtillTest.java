package hairrang.jdbc.conn;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import hairrang.dto.Guest;

class JdbcUtillTest {

	@Test
	void testGetConnection() {
		System.out.printf("%s()%n", "testGetConnection");
		Connection con = JdbcUtil.getConnection();
		//System.out.println(con);
		Assert.assertNotNull(con);
	}

}
