package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;


// TODO: Auto-generated Javadoc
/**
 * The Class StockDBConnector.
 */
public class StockDBConnector {

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
	 * Gets the buy value with.
	 *
	 * @param ID the ýd
	 * @return the buy value with
	 */
	public double getBuyValueWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stocks where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			double result = 0;
			while(myRs.next()) {
				result = myRs.getDouble("buyvalue");
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
	 * Gets the sell value with.
	 *
	 * @param ID the ýd
	 * @return the sell value with
	 */
	public double getSellValueWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stocks where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			double result = 0;
			while(myRs.next()) {
				result = myRs.getDouble("sellvalue");
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
	 * Gets the company name with.
	 *
	 * @param ID the ýd
	 * @return the company name with
	 */
	public String getCompanyNameWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stocks where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			String result = null;
			while(myRs.next()) {
				result = myRs.getString("companyname");
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
		return null;
	}
	
	/**
	 * Gets the ýnitial value with.
	 *
	 * @param ID the ýd
	 * @return the ýnitial value with
	 */
	public double getInitialValueWith( int ID)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stocks where id = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			double result = 0;
			while(myRs.next()) {
				result = myRs.getInt("initialValue");
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
	 * Sets the buy value with.
	 *
	 * @param ID the ýd
	 * @param current the current
	 */
	public void setBuyValueWith( int ID, double current)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update stocks set buyvalue = ? where id = ?");
			myState.setDouble(1,current);
			myState.setInt(2,ID);
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
	 * Sets the sell value with.
	 *
	 * @param ID the ýd
	 * @param current the current
	 */
	public void setSellValueWith( int ID, double current)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update stocks set sellvalue = ? where id = ?");
			myState.setDouble(1,current);
			myState.setInt(2,ID);
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
	
}
