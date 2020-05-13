package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class NameChanging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NameChanging() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			User user = (User) session.getAttribute("user");
			Name.changeName(request.getParameter("newname"), user.getEmail());
			user.setName(request.getParameter("newname"));
			session.setAttribute("user", user);
		}
		RequestDispatcher view = request.getRequestDispatcher("namechangingview.jsp");
		view.forward(request, response);
	}

}
