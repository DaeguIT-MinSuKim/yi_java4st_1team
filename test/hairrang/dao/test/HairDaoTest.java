package hairrang.dao.test;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hairrang.dao.HairDao;
import hairrang.dao.impl.HairDaoImpl;
import hairrang.dto.Hair;



public class HairDaoTest {
	private HairDao dao;

	@Before
	public void setUp() throws Exception {
		dao=HairDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao=null;
	}

	@Test
	public void testSelectHairByAll() {
		System.out.printf("%s()%n","testSelectHairByAll()");
		List<Hair> list =  dao.selectHairByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	//@Test
	public void testSelectHairByNo() {
		System.out.printf("%s()%n","testSelectHairByNo()");
		Hair selectHair = dao.selectHairByNo(new Hair(2));
		Assert.assertNotNull(selectHair);
		System.out.println(selectHair);
	}

	//@Test
	public void testInsertHair() {
		System.out.printf("%s()%n","testInsertHair()");
		Hair newHair = new Hair(2,"펌",3000);
		int res = dao.insertHair(newHair);
		Assert.assertEquals(1, res);
	}

	//@Test
	public void testUpdateHair() {
		System.out.printf("%s()%n","testUpdateHair()");
		Hair updqtHair = dao.selectHairByNo(new Hair(2));
		updqtHair.setHairName("빨간염색");
		updqtHair.setPrice(4500);
		
		dao.updateHair(updqtHair);
		Assert.assertNotNull(updqtHair);
		System.out.println(updqtHair);
	}

	//@Test
	public void testDeleteHair() {
		System.out.printf("%s()%n","testDeleteHair()");
		Hair deleteHair = dao.selectHairByNo(new Hair(2));
		dao.deleteHair(deleteHair);
		Assert.assertNotNull(deleteHair);
		System.out.println(deleteHair);
		
	}

	

}
