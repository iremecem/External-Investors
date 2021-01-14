package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;



// TODO: Auto-generated Javadoc
/**
 * The Class NewsDBConnector.
 */
public class NewsDBConnector {

	/** The connection. */
	Connection connection = null;
	
	/**
	 * Connect.
	 */
	public void connect() {
		
		String url = "jdbc:mysql://localhost:3306/projectdb?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey&autoReconnect=true&useSSL=false";
		String username = "externalForces";
		String password = "xxxx";

		try{
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			throw new IllegalStateException("Cannot connect the database!", e);
		}
	}
	
	
	/**
	 * Gets the news date with.
	 *
	 * @param ID the ýd
	 * @return the news date with
	 */
	public long getNewsDateWith( int ID )   {
		
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from newscontainer where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			Long result = (long) 0 ;
			while(myRs.next()) {
				result = myRs.getLong("date");
			}
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( connection != null )
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}
	
	/**
	 * Gets the news ID with.
	 *
	 * @param ID the ýd
	 * @return the news ID with
	 */
	public int getNewsIDWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from newscontainer where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			int result =  0 ;
			while(myRs.next()) {
				result = myRs.getInt("newsID");
			}
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( connection != null )
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}
	
	/**
	 * Adds the news.
	 *
	 * @param ID the ýd
	 * @param date the date
	 * @param newsID the news ID
	 */
	public void addNews(int ID, long date, int newsID) {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("insert into newscontainer values(?,?,?)");
			myState.setInt(1,ID);
			myState.setLong(2,date);
			myState.setInt(3,newsID);
			myState.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( connection != null )
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	/**
	 * Gets the number of news.
	 *
	 * @return the number of news
	 */
	public int getNumberOfNews() {
		connect();
		try {
			int a = 0 ;
			Statement myState = (Statement) connection.createStatement() ;
			ResultSet myRs = myState.executeQuery("select count(id) from newscontainer");
			while (myRs.next()) {
				a = myRs.getInt("count(id)");
				 }
			return a ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if( connection != null )
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return 0;
	}
}
