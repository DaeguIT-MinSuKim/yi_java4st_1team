package hairrang.dao;

import java.util.List;


public interface SalesDao {

	List<SalesDao> selectSalesByAll();

	SalesDao selectSalesByNo(SalesDao sales);

	int insertSales(SalesDao sales);

	int updateSales(SalesDao sales);

	int deleteSales(SalesDao sales);

	SalesDao selectSameSalesEmployeeBySalesNo(SalesDao sales);
}
