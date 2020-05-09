package Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSearching extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserSearching() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vector<Vector<Client>> temp = Client.search(request.getParameter("name"));
		if(temp == null || temp.size() == 0) {
			RequestDispatcher view = request.getRequestDispatcher("searchingerror.jsp");
			view.forward(request, response);
		}
		else {
			request.setAttribute("findingrs", temp);
			RequestDispatcher view = request.getRequestDispatcher("UserSearchingView.jsp");
			view.forward(request, response);
		}
	}

}
