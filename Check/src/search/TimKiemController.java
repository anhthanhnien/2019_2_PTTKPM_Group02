package search;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TimKiemController")
public class TimKiemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TimKiemController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", Intermediate.search(request.getParameter("search")));
		RequestDispatcher view = request.getRequestDispatcher("SortedList.jsp");
		view.forward(request, response);
	}

}
