package hairrang.dao.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hairrang.conn.JdbcUtil;

public class JdbcUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetConnection() {
		System.out.println("testGetConnection()");
		Connection con = JdbcUtil.getConnection();
		System.out.println(con);
		Assert.assertNotNull(con);
	}

}
