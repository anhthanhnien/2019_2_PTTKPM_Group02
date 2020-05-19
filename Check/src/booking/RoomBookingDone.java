package booking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import authentication.User;


public class RoomBookingDone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoomBookingDone() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			ArrayList<Room> temp = (ArrayList<Room>) session.getAttribute("roomlist");
			User user = (User) session.getAttribute("user");
			String start = (String) session.getAttribute("start");
			String end = (String) session.getAttribute("end");
			int night = (int) session.getAttribute("night");
			ArrayList<Integer> price = (ArrayList<Integer>) session.getAttribute("price");
			Booking.book(temp, user.getEmail(), start, end, night, price);
		}
		RequestDispatcher view = request.getRequestDispatcher("RoomBookingCompleted.jsp");
		view.forward(request, response);
	}

}


























