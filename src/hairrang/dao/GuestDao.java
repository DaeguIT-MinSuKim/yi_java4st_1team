package hairrang.dao;

import java.util.List;

import hairrang.dto.Guest;



public interface GuestDao {
	List<Guest> selectGuestByAll();
	
	Guest selectGuestByNo(Guest guest);
	
	List<Guest> selectGuestByName(Guest guest);
	
	int insertGuest(Guest guest);
	
	int updateGuest(Guest guest);
	
	int deleteGuest(Guest guest);

	int getGuestCurrVal();

	//이름으로 검색
	List<Guest> searchGuestByName(Guest guest);
}
