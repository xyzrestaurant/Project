package com.example.utility;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionUtility {

	public Connection create() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con  = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system" ,"sys1234");
		return con;
	}
}
