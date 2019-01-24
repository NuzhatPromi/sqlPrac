package io.naztech.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lombok.extern.slf4j.*;


@Slf4j
public class DBConnection {
//	private static final Logger logger=LoggerFactory.getLogger(DBConnection.class);

	private static Connection conn;
	private static DBConnection instance=null;

	private DBConnection() {
		try {
				conn = DriverManager.getConnection("jdbc:sqlserver://vNTDACWSSQLD002:1433;"
						+ "databaseName=DEV_TEST;user=dev_test_dbo;password=dev_test_dbo123");
			log.info("connection created.");
			//conn.close();		
		} catch (Exception e) {
			log.error("Connection error: "+e.getMessage());
			//log.info("error");
		}
	}
 public static DBConnection getInstance() {
	if (instance==null) {
		instance=new DBConnection();
		return instance;
	}
	else {
		return instance;
	}
	
}
	
	public Connection getConnection() {
		return conn;
		
	}

	public static void closeAll(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs!=null)
	    {
	        try
	        {
	            rs.close();

	        }
	        catch(SQLException e)
	        {
	            log.error("The result set cannot be closed.", e);
	        	//log.info("error");
	        }
	    }
	    if (stmt != null)
	    {
	        try
	        {
	            stmt.close();
	        } catch (SQLException e)
	        {
	           log.error("The statement cannot be closed.", e);
	        	//log.info("error");
	        }
	    }
	    if (conn != null)
	    {
	        try
	        {
	            conn.close();
	        } catch (SQLException e)
	        {
	           log.error("The data source connection cannot be closed.", e);
	        	//log.info("error");
	        }
	    }
	}
	public static void main(String[] args) {
		//System.out.println("successfull");
		new DBConnection();
	}
}
