package by.htp3.hotel.command.impl;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.util.QueryUtil;
import by.htp3.hotel.service.PersonalAccountServise;

import by.htp3.hotel.service.ServiceFactory;

import by.htp3.hotel.service.exception.ServiceException;


public class PersonalAccount implements Command  {

	
	private static final String LOGIN = "login";
	User user;
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		
		String query = QueryUtil.createHttpQueryString(request);
		HttpSession session = request.getSession(true);
		session.setAttribute("prev_query", query);
		
		
		System.out.println(query);
		System.out.println(" продолжение получени " + session.getAttribute(LOGIN));
		


		System.out.println(query + " логин сесиии" + session.getAttribute(LOGIN));
		
		
		String loginsesii = (String) session.getAttribute(LOGIN);;
		
		PersonalAccountServise personalAccountServise = ServiceFactory.getInstance().getPersonalAccountServise();
		try {
			user = personalAccountServise.showUserInformation(loginsesii);
			request.setAttribute("user", user);
			
			
			
			
			System.out.println("Personal accaunt = " +"имя "+ user.getName()+" фамилия" + user.getSurname() +"полчта"+ user.getEmail() +"Логин"+ user.getLogin()+"пароль"+user.getPassword());
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
		
		
		request.setAttribute("Name",user.getName());
		request.setAttribute("LastName", user.getSurname());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("login", user.getLogin());
		request.setAttribute("password", user.getPassword());
		request.getRequestDispatcher("/WEB-INF/jsp/personalAccount.jsp").forward(request, response);
		
	}

	
	
	
	
}
