package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TimeSheet
 */
@WebServlet("/TimeSheet")
public class TimeSheet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeSheet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		int empno = (int) session.getAttribute("empNo");
		String workdays = request.getParameter("workingDays");
		int workingdays = Integer.parseInt(workdays);
		System.out.println(workingdays);
		String curmonth = request.getParameter("curmonth");
		try {
			updateTimeSheet(empno, workingdays, curmonth);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem","root","1234");

	}
	public void updateTimeSheet(int empno,int workingdays,String month) throws SQLException, ClassNotFoundException {
		Connection connect = getConnection();
		PreparedStatement p = connect.prepareStatement("insert into Time_sheet values(?,?,?)");
		p.setInt(1, empno);
		p.setString(2, month);
		p.setInt(3, workingdays);
		
		
		p.executeUpdate();
	}

}
