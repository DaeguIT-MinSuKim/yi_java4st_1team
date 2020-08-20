package hairrang.dao;

import java.util.List;


public interface Sales {

	List<Sales> selectSalesByAll();

	Sales selectSalesByNo(Sales sales);

	int insertSales(Sales sales);

	int updateSales(Sales sales);

	int deleteSales(Sales sales);

	Sales selectSameSalesEmployeeBySalesNo(Sales sales);
}
