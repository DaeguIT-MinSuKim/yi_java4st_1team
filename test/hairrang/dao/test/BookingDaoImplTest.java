package hairrang.dao.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import hairrang.dao.BookingDao;
import hairrang.dao.impl.BookingDaoImpl;
import hairrang.dto.Booking;
import hairrang.dto.Guest;
import hairrang.dto.Hair;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookingDaoImplTest {

	private BookingDao dao;
	
	@Before
	public void setUp() {
		dao = BookingDaoImpl.getInstance();
	}

	@After
	public void tearDown() {
		dao = null;
	}

	@Test
	public void test04SelectBookByAll() {
		System.out.println("testSelectBookByAll()");
		List<Booking> list = dao.selectBookByAll();
		Assert.assertNotNull(list);
		System.out.println("> 전체 예약 내역 조회");
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test05SelectBookByGuestNo() {
		System.out.println("testSelectBookByAll()");
		Guest guest = new Guest(1);
		List<Booking> list = dao.selectBookByGuestNo(guest);
		Assert.assertNotNull(list);
		System.out.printf("> 회원번호 %d번 고객의 예약 내역 조회\n", guest.getGuestNo());
		list.stream().forEach(System.out::println);
		System.out.println();
	}

	@Test
	public void test01InsertBook() {
		System.out.println("testInsertBook()");
		Booking book = new Booking(1, new Guest(1), new Date(), new Hair(1), "10분 늦을 수 있다고 함");
		int res = dao.insertBook(book);
		Assert.assertEquals(1, res);
		System.out.println(book);
		System.out.println();
	}

	@Test
	public void test02UpdateBook() {
		fail("Not yet implemented");
	}

	@Test
	public void test03DeleteBook() {
		fail("Not yet implemented");
	}

}
