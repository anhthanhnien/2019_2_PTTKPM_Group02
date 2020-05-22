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


@WebServlet("/CheckOutOffController")
public class CheckOutOffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckOutOffController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<HoaDon> temp = Intermediate.getHoaDon(request.getParameter("id"), request.getParameter("email"), request.getParameter("end"), request.getParameter("night"));
		if(temp != null) {
			int total = 0;
			HttpSession session = request.getSession();
			synchronized(session) {
				session.setAttribute("list", temp);
			}
			for(int i = 0; i < temp.size(); ++i) {
				total += temp.get(i).getPrice2();
			}
			request.setAttribute("billvalue", total);
			RequestDispatcher view = request.getRequestDispatcher("CheckOutOffView.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("notvalid", "dung");
			RequestDispatcher view = request.getRequestDispatcher("CheckOutOff.jsp");
			view.forward(request, response);
		}
	}

}
