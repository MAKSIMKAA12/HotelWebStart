package by.htp3.hotel.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.htp3.hotel.dao.DAOFactory;
import by.htp3.hotel.dao.RegistrationDAO;

import by.htp3.hotel.dao.exception.DAOException;
import by.htp3.hotel.service.RegistrationServic;

import by.htp3.hotel.service.exception.ServiceException;
import by.htp3.hotel.service.exception.ServiceRegistrationException;

public class RegistrationServicImpl implements RegistrationServic {
	
	private static final String STRING_PATTERN = "";
	private static final String EMAIL_PATTERN ="([.[^@\\s]]+)@([.[^@\\s]]+)\\.([a-z]+)";
	private static final String LOGIN_PATTERN = "";
	private static final String PASSWORD_PATTERN ="";
	
	public static String[] wrongMessage =new String[5];
	
	
	
	public void addNewUsers(String name, String lastname, String email, String login, String password) throws ServiceException{
	System.out.println("Параметры из сервиса"+ name+ lastname+ email + login + password);
	boolean exceptionFlag = false;
	
	if (name == null || name.isEmpty()) {
		
		exceptionFlag = true;
		System.out.println("Wrong Name");
		wrongMessage[0] = "Wrong Name" ;
				
	}else {
		System.out.println("name ОК");
		wrongMessage[0] = " " ;
	}
	
		
		
	
	if (lastname == null || lastname.isEmpty()) {
		
		exceptionFlag = true;
		wrongMessage[1] = "Wrong LastName" ;
		System.out.println("Wrong LastName");
		
		
		
	}else {
		System.out.println("lastname ОК");
		wrongMessage[1] = " " ;
	}
	
	if (email == null || email.isEmpty()) {
		
		exceptionFlag = true;
		wrongMessage[2] = "Wrong eMail" ;
		System.out.println("Wrong eMail");
		
		
	}else {
		System.out.println("eMail ОК");
		wrongMessage[2] = " " ;
	}
	
	
	
	
	if (login == null || login.isEmpty()) {
		
		exceptionFlag = true;
		wrongMessage[3] = "Wrong login" ;
		System.out.println("Wrong login");
		
		
	}else {
		System.out.println("login ОК");
		wrongMessage[3] = " " ;
	}
	
	
	
	
	if (password == null || password.isEmpty()) {
		
		wrongMessage[4] = "Wrong password" ;
		exceptionFlag = true;
		
		
		
	}else {
		System.out.println("password ОК");
		wrongMessage[4] = " ";
	}
	
	
	
	
	if (exceptionFlag){
		
		throw new ServiceRegistrationException("Wrong name");
		
	}
	
	
	
	DAOFactory daoFactory = DAOFactory.getInstance();
	//RoomDAO dao = daoFactory.getRoomDAO();
	RegistrationDAO dao = daoFactory.getRegistrationDAO();
	
	try {
		dao.addNewUsers(name, lastname, email, login, password);
	} catch (DAOException e) {
		throw new ServiceException("Error in source!", e);

	}
	
	
	}
	
	
	
	 public static boolean checkInsertString(String patt, String inputStrig){  
	        Pattern p = Pattern.compile(patt);  
	        Matcher m = p.matcher(inputStrig);  
	        return m.matches();  
	    }  
	
	

}

