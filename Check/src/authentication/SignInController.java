package authentication;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignInController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		if(user.check(request.getParameter("username"), request.getParameter("pass")) == true) {
			HttpSession session = request.getSession();
		    synchronized(session) {
		    	session.setAttribute("user", user);
		    }
			if(user.getRole().equals("client")) {
				RequestDispatcher view = request.getRequestDispatcher("LoginSucceeded.jsp");
				view.forward(request, response);
			}
			else if(user.getRole().equals("locked")) {
				response.sendRedirect("error2.html");
			}
			else {
				RequestDispatcher view = request.getRequestDispatcher("AdminLoginSucceeded.jsp");
				view.forward(request, response);
			}
		}
		else {
			response.sendRedirect("error.html");
		}
		
	}

}
