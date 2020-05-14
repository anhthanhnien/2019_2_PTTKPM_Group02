package authentication;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FeedbackController() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			User user = (User) session.getAttribute("user");
			Feedback.saveFeedback(request.getParameter("fb"), request.getParameter("rate"), user.getEmail(), user.getName());
		}
		RequestDispatcher view = request.getRequestDispatcher("FeedbackView.jsp");
		view.forward(request, response);
	}

}
