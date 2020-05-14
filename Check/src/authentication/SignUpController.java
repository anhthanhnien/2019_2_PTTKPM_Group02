package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SignUpController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Registration client = new Registration(request.getParameter("email"), request.getParameter("pass"), request.getParameter("name"));
		try {
			if(client.register() == 1) {
				response.sendRedirect("login.html");
			}
			else {
				response.sendRedirect("signuperror.html");
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
