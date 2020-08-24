package hairrang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hairrang.conn.JdbcUtil;
import hairrang.dao.BookingDao;
import hairrang.dto.Booking;
import hairrang.dto.Guest;
import hairrang.dto.Hair;

public class BookingDaoImpl implements BookingDao {

	private static final BookingDaoImpl instance = new BookingDaoImpl();
	
	public static BookingDaoImpl getInstance() {
		return instance;
	}
	
	@Override
	public List<Booking> selectBookByAll() {
		
		String sql = "SELECT BOOK_NO, GUEST_NO, BOOK_DAY, HAIR_NO, BOOK_NOTE FROM BOOKING";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery() ) {
			
			if(rs.next()) {
				List<Booking> list = new ArrayList<>();
				
				do {
					list.add(getBook(rs));
				} while(rs.next());
				
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Booking> selectBookByGuestNo(Guest guest) {
		
		String sql = "SELECT BOOK_NO, GUEST_NO, BOOK_DAY, HAIR_NO, BOOK_NOTE FROM BOOKING WHERE GUEST_NO = ?";
		
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setInt(1, guest.getGuestNo());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				List<Booking> list = new ArrayList<>();
				
				do {
					list.add(getBook(rs));
				} while(rs.next());
				
				return list;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBook(Booking book) {
//		INSERT INTO BOOKING
//		values(BOOKING_SEQ.NEXTVAL, 1, SYSDATE, 1, '10분 늦을 수도 있다고 하심');
		String sql = "INSERT INTO BOOKING VALUES(BOOKING_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			System.out.println(book.getGuestNo().getGuestNo());
			System.out.println(new java.sql.Date(book.getBookDate().getTime()));
			System.out.println(book.getHairNo().getHairNo());
			System.out.println(book.getBookNote());
			
			pstmt.setInt(1, book.getGuestNo().getGuestNo());
			pstmt.setDate(2, new java.sql.Date(book.getBookDate().getTime()));
			pstmt.setInt(3, book.getHairNo().getHairNo());
			pstmt.setString(4, book.getBookNote());
			
			return pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBook(Booking book) {
		return 0;
	}

	@Override
	public int deleteBook(Booking book) {
		return 0;
	}

	private Booking getBook(ResultSet rs) throws SQLException {
		
		/*
		 * java.util.Date utilDate = new java.util.Date(rs.getDate("regdate").getTime());
			java.util.Date utilDate = rs.getTimestamp("regdate");
			  //->java.sql.Timestamp가  Date을 상속하기 때문에 이렇게 쓸 수 있음
		 */
		
		int no = rs.getInt("BOOK_NO");
		Guest guestNo = new Guest(rs.getInt("GUEST_NO"));
		Date bookDate = new Date(rs.getDate("BOOK_DAY").getTime());
		Hair hairNo = new Hair(rs.getInt("HAIR_NO"));
		String note = rs.getString("BOOK_NOTE");
		
		Booking book = new Booking(no, guestNo, bookDate, hairNo, note);

//		System.out.println(book);
//		System.out.println(book.getBookDateStr() + " " + book.getBookTimeStr());
		
		return book;
	}
	
}
