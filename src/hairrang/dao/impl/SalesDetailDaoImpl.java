package hairrang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hairrang.conn.JdbcUtil;
import hairrang.dao.SalesDetailDao;
import hairrang.dto.Hair;
import hairrang.dto.Sales;
import hairrang.dto.SalesDetail;

public class SalesDetailDaoImpl implements SalesDetailDao {
	private static final SalesDetailDaoImpl instance = new SalesDetailDaoImpl();
	
	private SalesDetailDaoImpl() {};
	
	public static SalesDetailDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<SalesDetail> selectSalesDetailByAll() {
		String sql = "SELECT DETAIL_NO , s.*,h.*,g.*,e.*\r\n" + 
				"	FROM SALES_DETAIL sd \r\n" + 
				"		JOIN SALES s ON (sd.SALES_NO = s.SALES_NO ) \r\n" + 
				"			JOIN HAIR h ON (sd.HAIR_NO = h.HAIR_NO )\r\n" + 
				"				JOIN GUEST g ON (g.GUEST_NO = s.GUEST_NO )\r\n" + 
				"					JOIN EVENT e ON (s.EVENT_NO = e.EVENT_NO )";
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
		
		HairDaoImpl hairDao = HairDaoImpl.getInstance();
		
		Hair hair = hairDao.getHair(rs);
		
		SalesDaoImpl salesDao = SalesDaoImpl.getInstance();
		
		Sales sales = salesDao.getSales(rs);
		
		
		int no = rs.getInt("DETAIL_NO");
		SalesDetail salesDetail = new SalesDetail(no,sales ,hair);
		return salesDetail;
	}


}
