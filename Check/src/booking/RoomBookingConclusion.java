package booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RoomBookingConclusion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RoomBookingConclusion() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int total = 0, i = 0;
		ArrayList<Integer> price = new ArrayList<Integer>();
		String[] id = request.getParameterValues("choice");
		int night = Integer.parseInt(request.getParameter("night"));
		HttpSession session = request.getSession();
		synchronized(session) {
			ArrayList<Room> temp = (ArrayList<Room>) session.getAttribute("roomlist");
			int length = temp.size();
			while(i < length) {
				if(Arrays.binarySearch(id, String.valueOf(temp.get(i).getId())) < 0) {
					temp.remove(i);
					--length;
				}
				else {
					price.add(night * temp.get(i).getPrice());
					total += night * temp.get(i).getPrice();
					++i;
				}
			}
			session.setAttribute("night", night);
			session.setAttribute("total", total);
			session.setAttribute("roomlist", temp);
			session.setAttribute("price", price);
		}
		RequestDispatcher view = request.getRequestDispatcher("RoomBookingConfirmation.jsp");
		view.forward(request, response);
	}

}






























