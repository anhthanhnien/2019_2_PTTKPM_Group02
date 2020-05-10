package Admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewTurnOver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewTurnOver() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TurnOver> temp = TurnOver.getTurnOver(request.getParameter("month"), request.getParameter("year"));
		if(temp != null) {
			int sum = 0;
			for(int i = 0; i < temp.size(); ++i) {
				sum += temp.get(i).getTotal();
			}
			request.setAttribute("sum", sum);
			request.setAttribute("ans", temp);
			RequestDispatcher view = request.getRequestDispatcher("TurnOverInfo.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("ans", temp);
			RequestDispatcher view = request.getRequestDispatcher("TurnOverInfo.jsp");
			view.forward(request, response);
		}
	}

}
