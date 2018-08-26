package login.sumit.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
@MultipartConfig

public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public LoginRegister() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomerDAO cd = new CustomerDAOImpl();
		String username = request.getParameter("username");
		String password = request.getParameter("password1");
		String submitType = request.getParameter("submit");

		Customer c = cd.getCustomer(username, password);
		// determining what page sent us here, login or register
		if (submitType.equals("Login") && c != null && c.getName() != null) {
			request.setAttribute("message", c.getName());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);

		} else if (submitType.equals("Register")) {

			c.setName(request.getParameter("name"));
			c.setUsername(username);
			c.setPassword(password);
			cd.insertCustomer(c);
			
			// successMessage in login page
			request.setAttribute("successMessage", "Registration done, please login to continue.");
			// path, return updated response from altered request
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {
			request.setAttribute("message", "Data not found. Please register.");
			// path, return updated response from altered request
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
