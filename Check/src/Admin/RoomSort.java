package Admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoomSort() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", Sort.sort(request.getParameter("type"), request.getParameter("value"), request.getParameter("avail")));
		RequestDispatcher view = request.getRequestDispatcher("SortedList.jsp");
		view.forward(request, response);
	}

}
