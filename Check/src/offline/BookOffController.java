package offline;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookOffController")
public class BookOffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookOffController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Intermediate.bookOffline(request.getParameter("id"), request.getParameter("email"), request.getParameter("start"))) {
			RequestDispatcher view = request.getRequestDispatcher("BookOffView.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("valid", "notvalid");
			RequestDispatcher view = request.getRequestDispatcher("BookOff.jsp");
			view.forward(request, response);
		}
	}

}
