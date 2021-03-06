package hairrang.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hairrang.conn.JdbcUtil;
import hairrang.dao.SalesDao;
import hairrang.dto.Event;
import hairrang.dto.Guest;
import hairrang.dto.Hair;
import hairrang.dto.Sales;

public class SalesDaoImpl implements SalesDao{
	private static final SalesDaoImpl instance = new SalesDaoImpl();
	
	private SalesDaoImpl() {};
	
	public static SalesDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Sales> selectSalesByAll() {
		String sql = "SELECT * FROM SALES s JOIN HAIR h ON (s.HAIR_NO = h.HAIR_NO ) JOIN GUEST g ON (g.GUEST_NO = s.GUEST_NO) JOIN EVENT e ON (s.EVENT_NO = e.EVENT_NO)";
		try(Connection con = JdbcUtil.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql);
					ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Sales> list = new ArrayList<Sales>();
				do {
					list.add(getSales(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	

	@Override
	public List<Sales> selectSalesByGuestNo(Sales sales) {
		String sql = "SELECT * FROM SALES s \r\n" + 
				"	JOIN HAIR h ON (s.HAIR_NO = h.HAIR_NO ) \r\n" + 
				"	JOIN GUEST g ON (g.GUEST_NO = s.GUEST_NO) \r\n" + 
				"	JOIN EVENT e ON (s.EVENT_NO = e.EVENT_NO)\r\n" + 
				"	WHERE s.GUEST_NO = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, sales.getSalesNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					List<Sales> list = new ArrayList<Sales>();
					do {
						list.add(getSales(rs));
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
	public int insertSales(Sales sales) {
		String sql = "INSERT INTO SALES VALUES (?,?,?,?,?)";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, sales.getSalesNo());
			pstmt.setDate(2, sales.getSalesDay());
			pstmt.setInt(3, sales.getGuestNo().getGuestNo());
			pstmt.setInt(4, sales.getEventNo().getEventNo());
			pstmt.setInt(5, sales.getHairNo().getHairNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Sales selectSalesByDate(Sales sales) {
		
		return null;
	}
	
	public Sales getSales(ResultSet rs) throws SQLException {

		/*
		 * int gno = rs.getInt("GUEST_NO"); String gname = rs.getString("GUEST_NAME");
		 * Date bday = rs.getDate("BIRTHDAY"); Date jday = rs.getDate("JOIN_DAY");
		 * String phone = rs.getString("PHONE"); int gender = rs.getInt("GENDER");
		 * String gnote = rs.getString("GUEST_NOTE"); Guest guest = new Guest(gno,
		 * gname, bday, jday, phone, gender, gnote);
		 * 
		 * 
		 * int eno = rs.getInt("EVENT_NO"); String ename = rs.getString("EVENT_NAME");
		 * double sale = rs.getInt("SALE"); Event event = new Event(eno, ename, sale);
		 * 
		 * 
		 * int no = rs.getInt("SALES_NO"); Date salesDay = rs.getDate("SALES_DAY"); Date
		 * salesTime = rs.getDate("SALES_TIME"); Sales sales = new Sales(no, salesDay,
		 * salesTime, guest, event);
		 */
		
		HairDaoImpl hdao = HairDaoImpl.getInstance();
		Hair hair = hdao.getHair(rs);
		
		//이후 헤어처럼 밑에 코드 수정
		int no = rs.getInt("EVENT_NO");
		String name = rs.getString("EVENT_NAME");
		
		Event event =  new Event(no, name, 0);
		
		int gno = rs.getInt("GUEST_NO");
		String gname = rs.getString("GUEST_NAME");
		Guest guset = new Guest(gno, gname, null, null, null, 0, null);
		
		int sno = rs.getInt("SALES_NO");
		Date day = rs.getDate("SALES_DAY");
		
		Sales sales = new Sales(sno, day, guset, event, hair);
		
		return sales;
	}

	
	
	/*
	 * @Override public int updateSales(Sales sales) { String sql =
	 * "UPDATE SALES \r\n" + "	SET SALES_DAY = ? ,\r\n" +
	 * "		SALES_TIME  = ? ,\r\n" + "		GUEST_NO = ? ,\r\n" +
	 * "		EVENT_NO = ? \r\n" + "	WHERE SALES_NO =?"; try(Connection con =
	 * JdbcUtil.getConnection(); PreparedStatement pstmt =
	 * con.prepareStatement(sql)){ pstmt.setDate(1, sales.getSalesDay());
	 * pstmt.setDate(2, sales.getSalesTime()); pstmt.setInt(3,
	 * sales.getGuestNo().getGuestNo()); pstmt.setInt(4,
	 * sales.getEventNo().getEventNo()); pstmt.setInt(5, sales.getSalesNo()); return
	 * pstmt.executeUpdate(); } catch (SQLException e) { throw new
	 * RuntimeException(e); } }
	 * 
	 * @Override public int deleteSales(Sales sales) { String sql =
	 * "DELETE SALES WHERE SALES_NO =?"; try(Connection con =
	 * JdbcUtil.getConnection(); PreparedStatement pstmt =
	 * con.prepareStatement(sql)){ pstmt.setInt(1, sales.getSalesNo()); return
	 * pstmt.executeUpdate(); } catch (SQLException e) { throw new
	 * RuntimeException(e); }
	 * 
	 * 
	 * }
	 */

}
