package hairrang.dao;

import java.util.List;

import hairrang.dto.Sales;


public interface SalesDao {

	List<Sales> selectSalesByAll();

	// 날짜 조건 필요함
	// where sales_day between ( and ) 아닐까... 잘 찾아봐
	Sales selectSalesByDate(Sales sales);
	
	// 언니쪽(고객검색)에서 필요한 메서드임 만들어야 해
	List<Sales> selectSalesByGuestNo(Sales sales);

	int insertSales(Sales sales);
	
	// insert할 때 주의점
	// 스윙에서는 List<Hair>로 갖고 있는데 이거 알아서 짜갈라서 잘 인서트 해주거라
	// hair_no, hair_name, price 있을 거 아뇨...?
	// 이지수가 펌이랑 염색을 했다.
	// list.get(0).getNo() <-- 이게 hair_no 펌
	// list.get(1).getNo() <-- 이게 hair_no 염색
	// insert into sales values(n, 날짜, 20번고객(이지수), 생일(이벤트번호), 펌);
	// insert into sales values(n + 1, 날짜, 20번고객(이지수), 생일(이벤트번호), 염색);
	

	/* 필요없지만 구색 갖춘 메서드 */
	/*
	 * int updateSales(Sales sales); int deleteSales(Sales sales);
	 */
	

}
