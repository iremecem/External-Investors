package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;


// TODO: Auto-generated Javadoc
/**
 * The Class StockOwnerDBConnector.
 */
public class StockOwnerDBConnector {

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
			throw new IllegalStateException(":(((((Cannot connect the database!", e);
		}
	}
	
	/**
	 * Gets the num of stocks with.
	 *
	 * @param userID the user ID
	 * @param stockID the stock ID
	 * @return the num of stocks with
	 */
	public int getNumOfStocksWith( int userID, int stockID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stockOwner where userID = ? and stockID = ?  ");
			myState.setInt(1,userID);
			myState.setInt(2,stockID);
			ResultSet myRs = myState.executeQuery();
			int count = 0;

			while(myRs.next()) {
				count = myRs.getInt("numOfStocks");
			}
			return count;
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
	 * Sets the num of stocks with.
	 *
	 * @param userID the user ID
	 * @param stockID the stock ID
	 * @param numOfStocks the num of stocks
	 */
	public void setNumOfStocksWith( int userID, int stockID, int numOfStocks)   {
		connect();
		try {
			
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update stockOwner set numOfStocks = ? where userID = ? and stockID = ?");
			myState.setInt(1,numOfStocks);
			myState.setInt(2,userID);
			myState.setInt(3,stockID);
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
	 * Adds the stock owner.
	 *
	 * @param userID the user ID
	 */
	public void addStockOwner(int userID) {
		connect();
		try {
			PreparedStatement myState;
			for(int i = 0 ; i < 10 ; i++) {
			myState = (PreparedStatement) connection.prepareStatement("insert into stockOwner values(?,?,?)");
			myState.setInt(1,userID);
			myState.setLong(2,i);
			myState.setInt(3,0);
			myState.executeUpdate();
			}
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
}
