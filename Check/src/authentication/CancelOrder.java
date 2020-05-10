package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CancelOrder() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			User user = (User) session.getAttribute("user");
			Intermediate.cancelOrder(user.getEmail(), request.getParameter("start"), request.getParameter("end"));
		}
		RequestDispatcher view = request.getRequestDispatcher("CancelOrderView.jsp");
		view.forward(request, response);
	}

}
