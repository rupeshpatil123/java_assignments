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

/**
 * Servlet implementation class Payslip
 */
@WebServlet("/Payslip")
public class GeneratePayslip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeneratePayslip() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String month=request.getParameter("month");
		String emailID = (String)session.getAttribute("email");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		try {
			int workingDays=getWorkingDays(month);
			Employee e=getEmployeeDetails(emailID);
			int salary =e.getSalary();
			int perdaysalary= salary /30;
			int salarybyday=(perdaysalary*workingDays);
			int PF=2000;
			
			
			
	
			out.print("<!DOCTYPE html>\n"
					+ "<html>\n"
					+ "<head>\n"
					+ "<meta charset=\"UTF-8\">\n"
					+ " <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
					+ "        integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
					+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"\n"
					+ "        integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\"\n"
					+ "        crossorigin=\"anonymous\"></script>\n"
					+ "\n"
					+ "    <title>Pay Slip</title>\n"
					+ "\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "		<div class=\"container mt-5 mb-5\">\n"
					+ "    <div class=\"row\">\n"
					+ "    	<h4>National Payment Corporation of India</h4>\n"
					+ "        <div class=\"col-md-12\">\n"
					+ "            <div class=\"text-center lh-1 mb-2\">\n"
					+ "                <h6 class=\"fw-bold\">Payslip</h6> <span class=\"fw-normal\">Payment slip for the month "+month+"</span>\n"
					+ "            </div>\n"
					+ "            \n"
					+ "            <div class=\"row\">\n"
					+ "                <div class=\"col-md-10\">\n"
					+ "                    <div class=\"row\">\n"
					+ "                        <div class=\"col-md-6\">\n"
					+ "                            <div> <span class=\"fw-bolder\">EMP Code : </span> "+e.getEmpNo()+"<small class=\"ms-3\"></small> </div>\n"
					+ "                        </div>\n"
					+ "                        <div class=\"col-md-6\">\n"
					+ "                            <div> <span class=\"fw-bolder\">EMP Name : "+e.geteName()+"</span> <small class=\"ms-3\"></small> </div>\n"
					+ "                        </div>\n"
					+ "                    </div>\n"
					+ "                    <div class=\"row\">\n"
					+ "                        <div class=\"col-md-6\">\n"
					+ "                            <div> <span class=\"fw-bolder\">Department: "+e.getDeptNo()+"</span> <small class=\"ms-3\"></small> </div>\n"
					+ "                        </div>\n"
					+ "                        <div class=\"col-md-6\">\n"
					+ "                            <div> <span class=\"fw-bolder\">Hiredate : "+e.getHireDate()+"</span> <small class=\"ms-3\"></small> </div>\n"
					+ "                        </div>\n"
					+ "                    </div>\n"
					+ "                    <div class=\"row\">\n"
					+ "                        <div class=\"col-md-6\">\n"
					+ "                            <div> <span class=\"fw-bolder\">Role: </span> "+e.getJob()+"<small class=\"ms-3\"></small> </div>\n"
					+ "                        </div>\n"
					+ "                        <div class=\"col-md-6\">\n"
					+ "                            <div> <span class=\"fw-bolder\">Working Days : </span> "+workingDays+"<small class=\"ms-3\"></small> </div>\n"
					+ "                        </div>\n"
					+ "                        \n"
					+ "                    </div>\n"
					+ "                </div>\n"
					+ "                <table class=\"mt-4 table table-bordered\">\n"
					+ "                    <thead class=\"bg-lite text-black\">\n"
					+ "                        <tr>\n"
					+ "                            <th scope=\"col\">Earnings</th>\n"
					+ "                            <th scope=\"col\">Amount</th>\n"
					+ "                            <th scope=\"col\">Deductions</th>\n"
					+ "                            <th scope=\"col\">Amount</th>\n"
					+ "                        </tr>\n"
					+ "                    </thead>\n"
					+ "                    <tbody>\n"
					+ "                        <tr>\n"
					+ "                            <th scope=\"row\">Basic + da</th>\n"
					+ "                            <td>"+salarybyday*0.5+"</td>\n"
					+ "                            <td>PF</td>\n"
					+ "                            <td>"+PF+"</td>\n"
					+ "                        </tr>\n"
					+ "                        <tr>\n"
					+ "                            <th scope=\"row\">HRA</th>\n"
					+ "                            <td>"+salarybyday*0.2+"</td>\n"
					+ "                        </tr>\n"
					+ "                        <tr>\n"
					+ "                            <th scope=\"row\">Allowance</th>\n"
					+ "                            <td>"+salarybyday*0.2+"</td>\n"
					+ "                        </tr>\n"
					+ "                        <tr>\n"
					+ "                            <th scope=\"row\">Mediclaim</th>\n"
					+ "                            <td>"+salarybyday*0.1+"</td>\n"
					+ "					    </tr>\n"
					+ "                        \n"
					+ "                    </tbody>\n"
					+ "                </table>\n"
					+ "            </div>\n"
					+ "            <div class=\"row\">\n"
					+ "                <div class=\"col-md-4\"> <br> <span class=\"fw-bold\">Net Pay : "+(salary - PF)+"</span> </div>               \n"
					+ "            </div>\n"
					+"<a href='Home'>Back</a>"
					+"&nbsp;&nbsp;"
					+"<a href='Login.html'>Logout</a>"
					+ "        </div>\n"
					+ "    </div>\n"
					+ "</div>\n"
					+ "</body>\n"
					+ "</html>");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public Employee getEmployeeDetails(String emailID) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement p=conn.prepareStatement("select * from Employee where EmpNo=(select EmpNo from LoginCredential where emailID=? )");
		p.setString(1, emailID);
		ResultSet r= p.executeQuery();
		if(r.next())
			return new Employee(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getInt(5),r.getInt(6),r.getString(7),r.getInt(8));
		return null;
		
		
	}
	
	public int getWorkingDays(String month) throws ClassNotFoundException, SQLException {
		Connection conn=getConnection();
		PreparedStatement p=conn.prepareStatement("select Workingdays from Time_sheet where curr_month=?");
		p.setString(1, month);
		
		ResultSet rs=p.executeQuery();
		if(rs.next())
			return rs.getInt(1);
		
		
		return 0;
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagementSystem","root","1234");
	}


}
