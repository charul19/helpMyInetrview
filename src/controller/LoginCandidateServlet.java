package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.google.gson.Gson;

import BO.CandidateLogin;
import DAO.CandidateDAO;

/**
 * Servlet implementation class LoginCandidateServlet
 */
@WebServlet("/logcan")
public class LoginCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(name="oracledb")
	public DataSource dataSource;       
	   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CandidateDAO.dataSource=this.dataSource;
		
		}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
CandidateDAO.dataSource = this.dataSource;
		
		InputStreamReader reader = new InputStreamReader(req.getInputStream());
		BufferedReader br = new BufferedReader(reader);
		String jsonString = br.readLine();
		
		
		Gson gson = new Gson();
		CandidateLogin can =  gson.fromJson(jsonString, CandidateLogin.class);
		System.out.println(can);
		int i = CandidateDAO.fetchCanditate(can);
		System.out.println(i );
			
		if(i>0) {
			System.out.println("login successful");
			String resp = "Welcome, "+can.getUname();             
			res.getWriter().write(gson.toJson(resp));
			
		}else {
			res.getWriter().write("-1");
		}
	}
	}