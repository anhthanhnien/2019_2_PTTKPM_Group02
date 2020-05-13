package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PasswordChanging extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PasswordChanging() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			User user = (User) session.getAttribute("user");
			boolean check = Password.change(request.getParameter("oldpassword"), request.getParameter("newpassword1"), request.getParameter("newpassword2"), user.getEmail());
			if(!check) {
				RequestDispatcher view = request.getRequestDispatcher("passworderror.jsp");
				view.forward(request, response);
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher("ChangePasswordSucceeded.jsp");
				view.forward(request, response);
			}
		}
	}

}
