package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp3.hotel.bean.User;
import by.htp3.hotel.command.Command;
import by.htp3.hotel.command.util.QueryUtil;
import by.htp3.hotel.service.ServiceFactory;
import by.htp3.hotel.service.UserService;
import by.htp3.hotel.service.exception.ServiceAuthException;
import by.htp3.hotel.service.exception.ServiceException;

public class Logination implements Command{
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);
		
		UserService userService = ServiceFactory.getInstance().getUserService(); //при помощи DAOфабрики создаем обьект UserServiceImp 

//		String query = QueryUtil.createHttpQueryString(request);
//		request.getSession(true).setAttribute("prev_query", query);
		String query = QueryUtil.createHttpQueryString(request);
		HttpSession session = request.getSession(true);
		session.setAttribute("prev_query", query);
		session.setAttribute(LOGIN, login);
		
		System.out.println(query);
		System.out.println("после квери стринг" + session.getAttribute(LOGIN));
		//System.out.println(session.getAttribute("prev_query") + login);
	
		
		try {
			User user = userService.authorisation(login, password); // 
			
			request.setAttribute("user", user);
			
			request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);
		} catch (ServiceAuthException e) {
			
			request.setAttribute("errorMessage", "Wrong login or password Логинация");
			
			request.getRequestDispatcher("/WEB-INF/jsp/logination.jsp").forward(request, response);
			
		}  catch (ServiceException e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);		
		}
		
		
	}
	
	
	
	

}
