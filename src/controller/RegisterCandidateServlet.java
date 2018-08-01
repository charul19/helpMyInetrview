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
import javax.sql.DataSource;

import com.google.gson.Gson;

import BO.Candidate;
import DAO.CandidateDAO;


@WebServlet("/regcan")
public class RegisterCandidateServlet extends HttpServlet {
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
		System.out.println(jsonString);
		
		Gson gson = new Gson();
		Candidate can =  gson.fromJson(jsonString, Candidate.class);
		
		int i = CandidateDAO.addCanditate(can);
		if(i>0) {
			System.out.println("added");
			res.getWriter().write(can.getUname());
		}else {
			res.getWriter().write("-1");
		}
	}
}