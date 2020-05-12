package authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogOutController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		synchronized(session) {
			session.invalidate();
		}
		Cookie[] cookie = request.getCookies();
		for(int i = 0; i < cookie.length; ++i) {
			if(cookie[i].getName().equals("JSESSIONID")) {
				Cookie alter = new Cookie("JSESSIONID", "");
				alter.setMaxAge(0);
				response.addCookie(alter);
				break;
			}
		}
		response.sendRedirect("index.html");
	}

}
