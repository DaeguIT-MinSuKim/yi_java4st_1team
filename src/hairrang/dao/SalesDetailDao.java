package hairrang.dao;

import java.util.List;

import hairrang.dto.SalesDetail;



public interface SalesDetailDao {

	List<SalesDetail> selectSalesDetailByAll();

	SalesDetail selectSaleDetailsByNo(SalesDetail salesdetail);

	int insertSalesDetail(SalesDetail salesdetail);

	int updateSalesDetail(SalesDetail salesdetail);

	int deleteSalesDetail(SalesDetail salesdetail);
}
