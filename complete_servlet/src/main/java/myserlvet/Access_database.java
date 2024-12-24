package myserlvet;

import java.io.IOException; 
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/logincheck")
public class Access_database extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}



	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		Access_database ac= new Access_database();
		ac.login("", "");
	}



	public boolean login(String email ,String password) {
		Connection con=null;
		
		ServletContext sc= getServletContext();
		try {
			Class.forName(sc.getInitParameter("dbdriver"));
			con = DriverManager.getConnection(sc.getInitParameter("dburl"),sc.getInitParameter("dbuser"),sc.getInitParameter("dbpass"));
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery("select * from userlogin");
			if(rs.next()) { 
			 String id = rs.getString("email"); 
			 String str1 = rs.getString("password");
			 
			 System.out.println(id + str1);
			}

			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	
}
