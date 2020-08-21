package hairrang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import hairrang.conn.JdbcUtil;
import hairrang.dao.HairDao;
import hairrang.dto.Hair;

public class HairDaoImpl implements HairDao{
	private static final HairDaoImpl instance = new HairDaoImpl();
	
	private HairDaoImpl() {}
	
	public static HairDaoImpl getInstance() {
		return instance;
		
	}
	
	@Override
	public List<Hair> selectHairByAll() {
		String sql =  "SELECT * FROM hair";
		try(Connection con = JdbcUtil.getConnection();
					PreparedStatement ptst =  con.prepareStatement(sql);
					ResultSet rs = ptst.executeQuery()){
				if(rs.next()) {
						List<Hair> list = new ArrayList<Hair>();
						do {
							list.add(getHair(rs));
						}while(rs.next());
						return list;
					}
				} catch (SQLException e) {
					throw new  RuntimeException(e);
				}
		return null;
	}

	

	@Override
	public Hair selectHairByNo(Hair hair) {
		String sql = "SELECT * FROM HAIR WHERE HAIR_NO =?";
		try(Connection con = JdbcUtil.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, hair.getHairNo());
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getHair(rs);
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}

	@Override
	public int insertHair(Hair hair) {
		String sql = "INSERT INTO HAIR VALUES (?,?,?)";
		try(Connection con = JdbcUtil.getConnection();
					PreparedStatement ptmt = con.prepareStatement(sql)){
			
			ptmt.setInt(1,hair.getHairNo());
			ptmt.setString(2, hair.getHairName());
			ptmt.setInt(3, hair.getPrice());
			return ptmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public int updateHair(Hair hair) {
		String sql = "UPDATE HAIR SET HAIR_NAME = ?,PRICE = ? WHERE HAIR_NO =?";
		try(Connection con = JdbcUtil.getConnection();
					PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, hair.getHairName());
			pstmt.setInt(2, hair.getPrice());
			pstmt.setInt(3, hair.getHairNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int deleteHair(Hair hair) {
		String sql = "DELETE FROM HAIR WHERE HAIR_NO = ?";
		try(Connection con = JdbcUtil.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, hair.getHairNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	private Hair getHair(ResultSet rs) throws SQLException {
		int no = rs.getInt("HAIR_NO");
		String name = rs.getString("HAIR_NAME");
		int price = rs.getInt("PRICE");
		return new Hair(no, name, price);
	}

}
