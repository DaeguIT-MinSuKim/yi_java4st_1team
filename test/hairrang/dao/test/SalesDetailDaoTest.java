package hairrang.dao.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hairrang.dao.SalesDetailDao;
import hairrang.dao.impl.SalesDetailDaoImpl;
import hairrang.dto.SalesDetail;
import junit.framework.Assert;

public class SalesDetailDaoTest {
	private SalesDetailDao dao;

	@Before
	public void setUp() throws Exception {
		dao=SalesDetailDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao=null;
	}

	//@Test
	public void testSelectSalesDetailByAll() {
		System.out.printf("%s()%n","testSelectSalesDetailByAll()");
		List<SalesDetail> list = dao.selectSalesDetailByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	//@Test
	public void testSelectSaleDetailsByNo() {
		fail("Not yet implemented");
	}

	//@Test
	public void testInsertSalesDetail() {
		fail("Not yet implemented");
	}

	//@Test
	public void testUpdateSalesDetail() {
		fail("Not yet implemented");
	}

	//@Test
	public void testDeleteSalesDetail() {
		fail("Not yet implemented");
	}

}
