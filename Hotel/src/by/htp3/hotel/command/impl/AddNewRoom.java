package by.htp3.hotel.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp3.hotel.command.Command;
import by.htp3.hotel.service.RoomService;
import by.htp3.hotel.service.ServiceFactory;

import by.htp3.hotel.service.exception.ServiceException;

public class AddNewRoom implements Command {

	private static final String TYPE_RUM = "type";
	private static final String PRICE_A_DAY = "price_a_day";
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String type = request.getParameter(TYPE_RUM);
		String priceADay = request.getParameter(PRICE_A_DAY);

		try {
			RoomService roomService = ServiceFactory.getInstance().getRoomService();
			roomService.addNewRoom(type, priceADay);

			response.sendRedirect("http://localhost:8080/Hotel/Controller?command=show_free_rooms");
		} catch (ServiceException e) {
			e.printStackTrace();
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

}
