package by.htp3.hotel.dao;


import by.htp3.hotel.dao.impl.SOLRegistrationDAO;
import by.htp3.hotel.dao.impl.SQLPersonalAccountDAO;
import by.htp3.hotel.dao.impl.SQLRoomDAO;
import by.htp3.hotel.dao.impl.SQLUserDAO;


public final class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

	private UserDAO userDAO = new SQLUserDAO();
	private RoomDAO roomDAO = new SQLRoomDAO();
	private RegistrationDAO registrationDAO = new SOLRegistrationDAO();
	private PersonalAccountDAO personalAccountDAO = new SQLPersonalAccountDAO(); 
	
	private DAOFactory(){}
	
	
	public UserDAO getUserDAO(){
		return userDAO;
	}
	
	public RoomDAO getRoomDAO(){
		return roomDAO;
	}
	
	
	
	
	public RegistrationDAO getRegistrationDAO() {
		return registrationDAO;
	}
	
		


	public PersonalAccountDAO getPersonalAccountDAO() {
		return personalAccountDAO;
	}




	public static DAOFactory getInstance(){
		return instance;
	}
	
}
