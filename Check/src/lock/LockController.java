package lock;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LockController")
public class LockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LockController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Intermediate.manage(request.getParameter("email"), request.getParameter("state"));
		RequestDispatcher view = request.getRequestDispatcher("LockView.jsp");
		view.forward(request, response);
	}

}
