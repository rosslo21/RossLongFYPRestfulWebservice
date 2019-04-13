package ross.fyp.FYPRestfulWebService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	
	/**
	 * Method to create DB Connection
	 * @return
	 * @throws Exception
	 */

	@SuppressWarnings("finally")
	public static Connection createConnection() throws Exception{
		
		Connection con = null; 
		try 
		{
			Class.forName(Constants.dbClass);
			con = DriverManager.getConnection(Constants.dbUrl, Constants.dbUser, Constants.dbPwd);
		}catch(Exception e) {
			throw e;
		}finally {
			return con;
		}
		
	}
	
	/**
	 * Method to check whether username and password are correct 
	 * @param uname
	 * @param pwd
	 * @return
	 * @throws Exception
	 * 
	 */
	
	public static boolean checkLogin(String email, String password)throws Exception{
		boolean isUserAvailible = false;
		Connection dbConn = null; 
		Statement stmt = null;
		System.out.println("Connection made 2");
	
		
		try {
			try {
				dbConn = DBConnection.createConnection();
				dbConn = DriverManager.getConnection(Constants.dbUrl,"root", "root");
			}catch(Exception e) {
				//catch block
				e.printStackTrace();
			}
			//System.out.println("Connection made 2");
			stmt = dbConn.createStatement();
			String query = "Select * From employee_data WHERE email = '" + email + "' AND password = " + "'" + password + "'";
			//System.out.println("Connection made4");
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				//System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
				isUserAvailible = true;
				}
			}
			catch(SQLException sqle) {
				throw sqle;
			}catch (Exception e) {
			//auto-generated catch block
			if(dbConn != null) {
				dbConn.close();
			}
		}
		return isUserAvailible;
	}
	
	
	
	/**
	 * Method to insert uname and pwd into DB
	 * 
	 *@param name 
	 *@param uname
	 *@param pwd
	 *@return
	 *@throws SQLException 
	 *@throws Exception 
	 *
	 */
	
	
	
	public static boolean insertUser(String name, String email, String password, String companyId)throws SQLException, Exception{
		boolean insertStatus = false; 
		Connection dbConn = null;
		try {
			try {
				dbConn = DBConnection.createConnection();
				//dbConn = DriverManager.getConnection(Constants.dbUrl, "root", "root");
			}catch(Exception e) {
				//auto generated catch block
				e.printStackTrace();
			}
			Statement stmt = dbConn.createStatement();
			String query = "INSERT INTO employee_data " + "VALUES('"+name+ "', "+"'" + email + "','" + password +"','" + companyId + "')";
			System.out.println(query);
			int records = stmt.executeUpdate(query);
			//System.out.println(records);
			//when records are successfully inserted
			if(records > 0) {
				insertStatus = true;
			}
		}catch(SQLException sqle) {
			//sql.printStackTrace();
			throw sqle;
		}catch(Exception e) {
			//e.printStackTrace();
			//auto generated catchblock
			if(dbConn != null) {
				dbConn.close();		
			}
		throw e;
	}finally {
		if (dbConn != null) {
			dbConn.close();
			
		}
	}
		return insertStatus;
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
