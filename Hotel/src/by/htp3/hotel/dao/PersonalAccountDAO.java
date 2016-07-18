package by.htp3.hotel.dao;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.service.exception.ServiceException;

public interface PersonalAccountDAO {
	User showUserInformation(String login)  throws ServiceException, DAOException;
	
}
