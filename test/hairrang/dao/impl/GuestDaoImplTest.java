package hairrang.dao.impl;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import hairrang.dao.GuestDao;
import hairrang.dto.Guest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GuestDaoImplTest {

	private GuestDao dao;
	
	@Before
	public void setUp() throws Exception {
		dao = GuestDaoImpl.getInstance();
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
	}

	@Test
	public void test01SelectGuestByAll() {
		System.out.printf("%s()%n", "test01SelectGuestByAll");
		List<Guest> list = dao.selectGuestByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}
	
	@Test
	public void test02InsertGuest() throws ParseException {
		System.out.printf("%s()%n", "test04SInsertGuest");
		
		Date now = new Date();
		
		Calendar c = Calendar.getInstance();
		c.set(1994, 10, 6);
		Date birth = new Date(c.getTimeInMillis());
		
		
		Guest newGuest = new Guest(6, "김혜진", birth, now, "010-5656-5656", 1, "");
		int res = dao.insertGuest(newGuest);
		Assert.assertEquals(1, res);
		System.out.println(newGuest);
		System.out.println("-----확인-----");
		List<Guest> list = dao.selectGuestByAll();
		list.stream().forEach(System.out::println);
		System.out.println();
		
	}

	@Test
	public void test03SelectGuestByNo() {
		System.out.printf("%s()%n", "test02SelectGuestByNo");
		Guest selectNo = dao.selectGuestByNo(new Guest(6));
		Assert.assertNotNull(selectNo);
		System.out.println(selectNo);
		System.out.println();
	}
	
	

	@Test
	public void test04SelectGuestByName() {
		System.out.printf("%s()%n", "test03SelectGuestByName");
		List<Guest> list = dao.selectGuestByName(new Guest("고연정"));
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
		System.out.println();
	}


	@Test
	public void test05UpdateGuest() {
		System.out.printf("%s()%n", "test05UpdateGuest");
		Guest update = dao.selectGuestByNo(new Guest(6));
		
		Calendar c = Calendar.getInstance();
		c.set(1999, 05, 29);
		Date birth = new Date(c.getTimeInMillis());
		
		update.setGuestName("김변경");
		update.setBirthday(birth);
		update.setPhone("010-5290-5290");
		update.setGender(2);
		update.setGuestNote("변경변경");
		
		int res = dao.updateGuest(update);
		Assert.assertEquals(1, res);
				
		System.out.println(update);
		System.out.println("->김변경, 1999-05-29, 010-5290-5290, 2, 변경변경");
		
		List<Guest> list = dao.selectGuestByAll();
		list.stream().forEach(System.out::println);
		System.out.println();
		
	}

	@Test
	public void test06DeleteGuest() {
		System.out.printf("%s()%n", "test06DeleteGuest");
		Guest delete = new Guest(6);
		int res = dao.deleteGuest(delete);
		Assert.assertEquals(1, res);
		System.out.println("-----확인-----");
		List<Guest> list = dao.selectGuestByAll();
		list.stream().forEach(System.out::println);
		System.out.println();
	}
	
	@Test
	public void test07getNextVal() {
		System.out.printf("%s()%n", "test07eleteGuest");
		int res = dao.getGuestCurrVal();
		Assert.assertTrue(true);
		System.out.println(res);
	}
	
	@Test
	public void test08SearchGuestByName() {
		System.out.printf("%s()%n", "test08SearchGuestByName");
		String search = "고연";
		List<Guest> list = dao.searchGuestByName(new Guest(search));
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
}
