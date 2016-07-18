package by.htp3.hotel.dao;

import by.htp3.hotel.dao.exception.DAOException;

public interface RegistrationDAO {
	void addNewUsers(String name, String lastname, String email,String login, String password) throws DAOException;
	}


