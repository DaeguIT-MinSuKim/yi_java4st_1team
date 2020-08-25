package hairrang.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hairrang.conn.JdbcUtil;
import hairrang.dao.SalesDetailDao;
import hairrang.dto.Event;
import hairrang.dto.Guest;
import hairrang.dto.Hair;
import hairrang.dto.Sales;
import hairrang.dto.SalesDetail;

public class SalesDetailDaoImpl implements SalesDetailDao {
	private static final SalesDetailDaoImpl instance = new SalesDetailDaoImpl();
	
	private SalesDetailDaoImpl() {};
	
	public static SalesDetailDaoImpl getInstance() {
		return instance;
	}

	
	/* 쓸모 없어졌삼 빠이... 세일즈디테일바이얼 알아서 이사가세욤 
	 * 컬럼 전체로 셀렉트 해줘서 스윙 쪽에서 잘 지지고 볶아서 원하는 컬럼만 JTable화 하기 
	 * Sales 객체에서 List<Hair> 가지고 있기. (찐 DB 테이블에서는 다른 영업번호로 Hair 기록하면 됨)
	 * */
	
	
	@Override
	public List<SalesDetail> selectSalesDetailByAll() {
		String sql = "SELECT DETAIL_NO , sd.SALES_NO , s.SALES_DAY , s.GUEST_NO ,g.GUEST_NAME  ,h.HAIR_NAME ,h.PRICE  ,e.EVENT_NAME \r\n" + 
				"	FROM SALES_DETAIL sd JOIN SALES s ON (sd.SALES_NO = s.SALES_NO )\r\n" + 
				"			JOIN GUEST g ON (g.GUEST_NO = s.GUEST_NO )\r\n" + 
				"			JOIN HAIR h ON (h.HAIR_NO = sd.HAIR_NO )\r\n" + 
				"			JOIN EVENT e ON (e.EVENT_NO = s.EVENT_NO )";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs= pstmt.executeQuery()){
			if(rs.next()) {
				List<SalesDetail> list = new ArrayList<SalesDetail>();
				do {
					list.add(getSalesDetail(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	
	@Override
	public SalesDetail selectSaleDetailsByNo(SalesDetail salesdetail) {
		String sql = "";
		
		return null;
	}

	@Override
	public int insertSalesDetail(SalesDetail salesdetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSalesDetail(SalesDetail salesdetail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSalesDetail(SalesDetail salesdetail) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private SalesDetail getSalesDetail(ResultSet rs) throws SQLException {
		//int eNo = rs.getInt("EVENT_NO");
		String eName = rs.getString("EVENT_NAME");
		Event event = new Event(0, eName, 0);
		
		//int hNo = rs.getInt("HAIR_NO");
		String hName =rs.getString("HAIR_NAME");
		int hPrice = rs.getInt("PRICE");
		Hair hair = new Hair(0,hName,hPrice);
		
		
		
		int gNo = rs.getInt("GUEST_NO");
		String gName = rs.getString("GUEST_NAME");
		Guest guset = new Guest(gNo, gName, null, null, null, 0, null);
		
		
		int sNo = rs.getInt("SALES_NO");
		Date sDay = rs.getDate("SALES_DAY");
		Sales sales = new Sales(sNo, sDay, null, guset, event);
		
		
		int sdNo = rs.getInt("DETAIL_NO");
		SalesDetail sd = new SalesDetail(sdNo, sales, hair);
		
		return sd;
	}


}
