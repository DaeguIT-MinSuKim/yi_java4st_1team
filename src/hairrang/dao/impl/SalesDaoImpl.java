package hairrang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hairrang.conn.JdbcUtil;
import hairrang.dao.SalesDao;
import hairrang.dto.Sales;

public class SalesDaoImpl implements SalesDao{
	private static final SalesDaoImpl instance = new SalesDaoImpl();
	
	private SalesDaoImpl() {};
	
	public static SalesDaoImpl getInstace() {
		return instance;
	}

	@Override
	public List<Sales> selectSalesByAll() {
		String sql = "SELECT * FROM SALES";
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
	public Sales selectSalesByNo(Sales sales) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSales(Sales sales) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSales(Sales sales) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSales(Sales sales) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Sales getSales(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
	}

}
