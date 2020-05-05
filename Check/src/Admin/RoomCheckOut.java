package Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RoomCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RoomCheckOut() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Checkout> arr = Checkout.check(request.getParameter("id"), request.getParameter("email"));
		HttpSession session = request.getSession();
		if(arr != null) {
			int total = 0;
			for(int i = 0; i < arr.size(); ++i) {
				total += arr.get(i).getPrice2();
			}
			synchronized(session) {
				session.setAttribute("roomid", request.getParameter("id"));
				request.setAttribute("billvalue", total);
				request.setAttribute("bill", arr);
			}
			RequestDispatcher view = request.getRequestDispatcher("CheckOutView.jsp");
			view.forward(request, response);
		}
		else {
			RequestDispatcher view = request.getRequestDispatcher("checkouterror.jsp");
			view.forward(request, response);
		}
	}

}
