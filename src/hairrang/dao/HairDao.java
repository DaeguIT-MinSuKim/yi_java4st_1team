package hairrang.dao;

import java.util.List;

import hairrang.dto.Hair;


public interface HairDao {

	List<Hair> selectHairByAll();

	Hair selectHairByNo(Hair hair);

	int insertHair(Hair hair);

	int updateHair(Hair hair);

	int deleteHair(Hair hair);
	
	List<String> selectHairByName();
}
