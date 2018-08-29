package dbfunctions;

import java.sql.*;


public class DataBaseFunctions {

	String jdbc_driver;
	String db_url;
	String uname;
	String pass;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	int ok;
	
	
	
	public DataBaseFunctions() {
		super();
		jdbc_driver="com.mysql.jdbc.Driver";
		db_url="jdbc:mysql://localhost:3306/placefreshers";
		uname="root";
		pass="";
		con=null;
		stmt=null;
		pstmt=null;
		rs=null;
		ok=0;
	}

	public void init()
	{
		try {
			Class.forName(jdbc_driver);
			con=DriverManager.getConnection(db_url,uname,pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet selectQuery(String sql){
		try {
			init();
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/*public PreparedStatement insertQuery(String sql){
		try {
			init();
			pstmt= con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}*/
	
	public PreparedStatement updateQuery(String sql){
		try {
			init();
			pstmt= con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
}
