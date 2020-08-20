package hairrang.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hairrang.dao.HairDao;
import hairrang.dto.Hairgoods;

public class HairDaoImpl implements HairDao{
	private static final HairDaoImpl instance = new HairDaoImpl();
	
	private HairDaoImpl() {}
	
	public static HairDao getInstance() {
		return instance;
		
	}
	
	private Hairgoods getHair(ResultSet rs) throws SQLException {
		int no = rs.getInt("HAIR_NO");
		return null;
		
		
	}

	@Override
	public List<Hairgoods> selectHairgoodsByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hairgoods selectHairgoodsByNo(Hairgoods hair) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertHairgoods(Hairgoods hair) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateHairgoods(Hairgoods hair) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteHairgoods(Hairgoods hair) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Hairgoods selectSameHairgoodsEmployeeByHairgoodsNo(Hairgoods hair) {
		// TODO Auto-generated method stub
		return null;
	}
}
