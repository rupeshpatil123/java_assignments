package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		try {
			Employee e = getEmployeeDetails(email);
			out.print(e);
			
			out.print("<br><a href='Logout'>Logout</a>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	private Employee getEmployeeDetails(String email) throws ClassNotFoundException, SQLException {

		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement(
				"select * from Employee where EmpNo = (select EmpNo from LoginCredential where emailID = ?)");
		p.setString(1, email);

		ResultSet r = p.executeQuery();
		if (r.next())
			return new Employee(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getInt(6),
					r.getString(7), r.getInt(8));

		return null;
	}

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem","root","1234");
	}

}
