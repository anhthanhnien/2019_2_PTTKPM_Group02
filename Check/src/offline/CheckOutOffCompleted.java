package offline;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckOutOffCompleted")
public class CheckOutOffCompleted extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckOutOffCompleted() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			ArrayList<HoaDon> temp = (ArrayList<HoaDon>) session.getAttribute("list");
			Intermediate.checkOut(temp);
		}
		request.setAttribute("xong", "true");
		RequestDispatcher view = request.getRequestDispatcher("CheckOutOffDone.jsp");
		view.forward(request, response);
	}
}













