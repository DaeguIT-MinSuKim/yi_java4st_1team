package hairrang.dao;

import java.util.List;

import hairrang.dto.Sales;


public interface SalesDao {

	List<Sales> selectSalesByAll();

	Sales selectSalesByNo(Sales sales);

	int insertSales(Sales sales);

	int updateSales(Sales sales);

	int deleteSales(Sales sales);

}
