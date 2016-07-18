package by.htp3.hotel.service;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.service.exception.ServiceException;

public interface PersonalAccountServise {
	User showUserInformation(String login)  throws ServiceException;
	
}
