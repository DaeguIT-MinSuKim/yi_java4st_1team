package hairrang.dao.impl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hairrang.dao.GuestDao;
import hairrang.dto.Guest;
import hairrang.jdbc.conn.JdbcUtil;


public class GuestDaoImpl implements GuestDao {
	
	private static final GuestDaoImpl instance = new GuestDaoImpl();
	
	private GuestDaoImpl() {};
	
	public static GuestDaoImpl getInstance() {
		return instance;
	}
	
	//resultset executequery -> 데이터검색할때쓰기. 주어진 sql문 실행하고 결과는 resultset객체에 반환
	//int executeupdate -> insert, update, delete같은 데이터변경할때. sql문 실행하고 영향을 받은 행의 개수나 0 반환
	//void close() -> statement객체의 db와 jdbc리소스 즉시 반환 

	
	@Override
	public int getGuestCurrVal() {
		String sql = "SELECT LAST_NUMBER FROM USER_SEQUENCES WHERE SEQUENCE_NAME = 'GUEST_SEQ'";
		
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			if(rs.next()) {
				return rs.getInt("LAST_NUMBER");
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return 0;
	}

	
	@Override
	public List<Guest> selectGuestByAll() {
		String sql = "SELECT GUEST_NO, GUEST_NAME, BIRTHDAY, JOIN_DAY, PHONE, GENDER, GUEST_NOTE FROM GUEST ORDER BY GUEST_NO";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			
			if(rs.next()) {
				List<Guest> list = new ArrayList<>();
				do {
					list.add(getGuest(rs));
				}while(rs.next());
				return list;
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}


	
	@Override
	public List<Guest> searchGuestByName(Guest guest){
		String sql = "SELECT GUEST_NO, GUEST_NAME, BIRTHDAY, JOIN_DAY, PHONE, GENDER, GUEST_NOTE FROM GUEST WHERE GUEST_NAME LIKE '%' || ? || '%'";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, "%" + guest.getGuestName() + "%");
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<Guest> list = new ArrayList<>();
					do {
						list.add(getGuest(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
		
	}
	
	@Override
	public List<Guest> selectGuestByName(Guest guest) {
		//동명이인 데이터 추가
		String sql = "SELECT  GUEST_NO, GUEST_NAME, BIRTHDAY, JOIN_DAY, PHONE, GENDER, GUEST_NOTE FROM GUEST WHERE GUEST_NAME = ?";
			try(Connection con = JdbcUtil.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setString(1, guest.getGuestName());
				
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						List<Guest> list = new ArrayList<>();
						do {
							list.add(getGuest(rs));
						}while(rs.next());
						return list;
					}
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return null;
	}
	
	@Override
	public Guest selectGuestByNo(Guest guest) {
		String sql = "SELECT GUEST_NO, GUEST_NAME, BIRTHDAY, JOIN_DAY, PHONE, GENDER, GUEST_NOTE FROM GUEST WHERE GUEST_NO= ?";
			try(Connection con = JdbcUtil.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)){
				pstmt.setInt(1, guest.getGuestNo());
				try(ResultSet rs = pstmt.executeQuery()){
					if(rs.next()) {
						return getGuest(rs);
					}
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
		return null;
	}
	
	
	
	@Override
	public int insertGuest(Guest guest) {
		String sql =  "INSERT INTO GUEST VALUES(GUEST_SEQ.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?)";
		try(Connection con= JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
				
			pstmt.setString(1, guest.getGuestName());
			pstmt.setTimestamp(2, new java.sql.Timestamp(guest.getBirthday().getTime()));
			pstmt.setString(3, guest.getPhone());
			pstmt.setInt(4, guest.getGender());
			pstmt.setString(5, guest.getGuestNote());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	
	@Override
	public int updateGuest(Guest guest) {
		String sql = "UPDATE GUEST SET GUEST_NAME = ?, BIRTHDAY =? , PHONE = ?, GENDER = ?, GUEST_NOTE = ? WHERE GUEST_NO = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
		
			pstmt.setString(1, guest.getGuestName());
			pstmt.setTimestamp(2, new java.sql.Timestamp(guest.getBirthday().getTime()));
			pstmt.setString(3, guest.getPhone());
			pstmt.setInt(4, guest.getGender());
			pstmt.setString(5, guest.getGuestNote());
			pstmt.setInt(6, guest.getGuestNo());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	
	}

	@Override
	public int deleteGuest(Guest guest) {
		String sql = "DELETE FROM GUEST WHERE GUEST_NO = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, guest.getGuestNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	private Guest getGuest(ResultSet rs) throws SQLException {
		Guest guest = new Guest();
		//SELECT GUEST_NO, GUEST_NAME, BIRTHDAY, JOIN_DAY, PHONE, GENDER, GUEST_NOTE FROM GUEST;
		try {
			guest.setGuestNo(rs.getInt("GUEST_NO"));
			guest.setGuestName(rs.getString("GUEST_NAME"));
			guest.setBirthday(rs.getDate("BIRTHDAY"));
			guest.setJoinDay(rs.getDate("JOIN_DAY"));
			guest.setPhone(rs.getString("PHONE"));
			guest.setGender(rs.getInt("GENDER"));
			guest.setGuestNote(rs.getString("GUEST_NOTE"));
		}catch(SQLException e) {
			
		}
		return guest;
	}

}