package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;

public class UpdetePersonalAccount implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("WEB-INF/jsp/UpdetePersonalAccaunt.jsp").forward(request, response);

	}

}
