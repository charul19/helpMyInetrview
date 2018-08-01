package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import BO.Candidate;
import BO.CandidateLogin;


public class CandidateDAO {
public static DataSource dataSource;
	
	public static Connection getConnection(){	
		Connection con=null;
		try{
			con=dataSource.getConnection();
		}
		catch(SQLException e){
			e.printStackTrace();
		} 
		return con;
	}
	
	public static int addCanditate(Candidate can){
		//write code to perform insert operation
		Connection con=null;
		
		int result = 0;
			
			try {
				con=getConnection();
				String sql="INSERT INTO reghmi VALUES(?,?,?,?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,can.getFname());
				ps.setString(2,can.getLname());
				ps.setString(3, can.getEmail());
				ps.setLong(4,can.getContact_no());
				ps.setString(5,can.getUname());
				ps.setString(6,can.getPassword());
				ps.setString(7,can.getRpassword());
				result=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				closeConnection(con);
			}			
			return result;
			
	}
	static void closeConnection(Connection con)
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

public static int fetchCanditate(CandidateLogin can){
	
	Connection con=null;
	PreparedStatement ps=null;
	int result=0;
	
	try {
		
		con = getConnection();
		String sql = "SELECT uname,password from reghmi where uname=?";
		ps = con.prepareStatement(sql);
		ps.setString(1,can.getUname());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			String password = rs.getString("password");
			String pass=can.getPassword();
			if(password.equals(pass))
			{
				result=result+1;
			}
	}
		rs.close();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}finally {
		closeConnection(con);
	}
	
	return result;
}
}
