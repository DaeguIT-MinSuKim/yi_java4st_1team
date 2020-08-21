package hairrang.dao.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hairrang.dao.SalesDao;
import hairrang.dao.impl.SalesDaoImpl;

public class SalesDaoTest {
	private SalesDao dao;
	
	@Before
	public void setUp() throws Exception {
		 dao=SalesDaoImpl.getInstace();
	}

	@After
	public void tearDown() throws Exception {
		dao=null;
	}

	@Test
	public void testSelectSalesByAll() {
		System.out.printf("%s()%n","testSelectSalesByAll()");
		
	}

	@Test
	public void testSelectSalesByNo() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSales() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSales() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSales() {
		fail("Not yet implemented");
	}

}
