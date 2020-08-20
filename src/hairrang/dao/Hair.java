package hairrang.dao;

import java.util.List;

import hairrang.dto.Hairgoods;

public interface Hair {

	List<Hairgoods> selectHairgoodsByAll();

	Hairgoods selectHairgoodsByNo(Hairgoods hair);

	int insertHairgoods(Hairgoods hair);

	int updateHairgoods(Hairgoods hair);

	int deleteHairgoods(Hairgoods hair);

	Hairgoods selectSameHairgoodsEmployeeByHairgoodsNo(Hairgoods hair);
}
