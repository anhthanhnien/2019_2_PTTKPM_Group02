package booking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RoomBookingProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoomBookingProcess() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Room> temp = Room.getRoom(Integer.parseInt(request.getParameter("quantity")), request.getParameter("type"), request.getParameter("start"), request.getParameter("end"));
		if(temp != null && temp.size() != 0) {
			HttpSession session = request.getSession();
			synchronized(session) {
				session.setAttribute("start", request.getParameter("start"));
				session.setAttribute("end", request.getParameter("end"));
				session.setAttribute("roomlist", temp);
			}
			RequestDispatcher view = request.getRequestDispatcher("RoomBookingSearch.jsp");
			view.forward(request, response);
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("RoomBookingNotFound.jsp");
			view.forward(request, response);
		}
	}

}
