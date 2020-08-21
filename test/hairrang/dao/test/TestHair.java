package hairrang.dao.test;

import hairrang.dao.HairDao;
import hairrang.dao.impl.HairDaoImpl;
import hairrang.dto.Hair;

public class TestHair {

	public static void main(String[] args) {

		HairDao dao = HairDaoImpl.getInstance();
		
		int res = dao.insertHair(new Hair(2,"펌",3000));
		System.out.println(res);
	}

}
