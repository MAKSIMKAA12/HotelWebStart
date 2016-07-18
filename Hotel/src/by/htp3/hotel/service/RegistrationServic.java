package by.htp3.hotel.service;

import by.htp3.hotel.service.exception.ServiceException;

public interface RegistrationServic {
	
	void addNewUsers(String name, String lastname, String email,String login, String password)  throws ServiceException;
}
