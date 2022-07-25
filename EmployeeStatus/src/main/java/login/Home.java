
package login;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String empname = (String)session.getAttribute("empName");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
	
		
		
			out.print("<html><head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
				+ "        integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"\n"
				+ "        integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\"\n"
				+ "        crossorigin=\"anonymous\"></script>\n"
				
				+ "    <title>Home </title>"
				+ "</head>");
		//out.print("Welcome "+empname);
		out.print("<body>"
				+ "    <div class=\"container\">"
				+" <h3 style = 'color :orange;'>WELCOME to the Employee Portal: "+empname  +"<h3>"
				
				+ " <form class=\"form\" name=\"TimeSheet\" action=\"TimeSheet\" method=\"post\">"
				+ "  <div class=\"row\">"
				
				+ "<div class=\"col-md-2\">"
				
				+ "<label class=\"form-label\">Working Days</label> </div>"
				+ "</div>"
			
				+ "<div class=\"col-md-4\">"
				+ "<input type=\"number\" name=\"workingDays\" class=\"form-control\">"
				+ "</div>"

				+ "<div class=\"row\">"
				+ "<div class=\"col-md-4\">"
			
				+ "<label class=\"form-label\">Month</label>\n"
				+ "<input type=\"month\" name=\"curmonth\" class=\"form-control\">"
				+ "</div>"
				+ "</div>"
				+ "&nbsp;"
				+ "<div class=\"row\">\n"
				+ "<div class=\"col-md-4\">"
				
				+ "<button type=\"submit\" class=\"btn btn-primary\">Add </button>"
				+"&nbsp;"
				+"&nbsp;"
				+ "<button type=\"submit\" class=\"btn btn-info\" ><a href=\"Payslip.html\">View Pay Slip</a></button>"
				+"<br>"
				+"<button type=\"submit\" class=\"btn btn-outline-info\" ><a href=\"Login.html\">Log out</a></button>"
				+ "</div>"
				+ "</div>"
				
				+ "  </form>"
			
				+ "  </div>"
			
				+ "</body>"
				
				+ "</html>	");
	
		
	}


	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem","root","1234");

	}
	

	

}
