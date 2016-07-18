package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;

import by.htp3.hotel.service.RegistrationServic;

import by.htp3.hotel.service.ServiceFactory;

import by.htp3.hotel.service.exception.ServiceException;
import by.htp3.hotel.service.exception.ServiceRegistrationException;
import by.htp3.hotel.service.impl.RegistrationServicImpl;

public class Registration implements Command {

	private static final String NAME = "name";
	private static final String LASTNAME = "lastname";
	private static final String E_MAIL = "email";
	private static final String LOGIN = "login";
	private static final String PASSWORD = "password";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String name = request.getParameter(NAME);
		String lastname = request.getParameter(LASTNAME);
		String email = request.getParameter(E_MAIL);
		String login = request.getParameter(LOGIN);
		String password = request.getParameter(PASSWORD);

		RegistrationServic registrationServic = ServiceFactory.getInstance().getRegistrationServic(); 


		try {
			registrationServic.addNewUsers(name, lastname, email, login, password);

			request.getRequestDispatcher("/WEB-INF/jsp/showNewUser.jsp").forward(request, response);
			
		} catch (ServiceRegistrationException e) {

			request.setAttribute("errorMessageName", RegistrationServicImpl.wrongMessage[0]);
			request.setAttribute("errorMessageLastName", RegistrationServicImpl.wrongMessage[1]);
			request.setAttribute("email", RegistrationServicImpl.wrongMessage[2]);
			request.setAttribute("login", RegistrationServicImpl.wrongMessage[3]);
			request.setAttribute("password", RegistrationServicImpl.wrongMessage[4]);
			request.getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(request, response);

		} catch (ServiceException e) {
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}
}
