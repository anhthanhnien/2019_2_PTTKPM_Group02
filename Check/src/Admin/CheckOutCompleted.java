package Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckOutCompleted extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckOutCompleted() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			RefreshRoom.refresh((String)session.getAttribute("roomid"), request.getParameter("email"));
		}
		RequestDispatcher view = request.getRequestDispatcher("CheckOutDone.jsp");
		view.forward(request, response);
	}

}
