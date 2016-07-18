package by.htp3.hotel.service.impl;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.dao.DAOFactory;
import by.htp3.hotel.dao.PersonalAccountDAO;

import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.service.PersonalAccountServise;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;


public class PersonalAccountServiseImpl implements PersonalAccountServise {

	@Override
	public User showUserInformation(String login) throws ServiceException {
		
		System.out.println("Параметры из сервиса"+ login);
		DAOFactory daoFactory = DAOFactory.getInstance();
		PersonalAccountDAO dao = daoFactory.getPersonalAccountDAO();
		
		User user;
		try {
			user = dao.showUserInformation(login);
			
			
			System.out.println("Передачи из дао параметров"+ user.getEmail());
			if(user == null){
				throw new ServiceAuthException("Нет параметров user null");
			}
			
		} catch (DAOException e) {
			
			throw new ServiceException("Error in source!", e);
			
		}
		
		
		return user;
	}

}
