package roomlist;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RoomListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoomListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("dsphong", Intermediate.getPhong());
		RequestDispatcher view = request.getRequestDispatcher("RoomListView.jsp");
		view.forward(request, response);
	}

}












