package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

// TODO: Auto-generated Javadoc
/**
 * A class that connects properties of accounts to the database.
 * @author Eren Þenoðlu
 * @version 10.12.2018
 */

public class AccountDBConnector {

	/** The connection. */
	// Properties
	Connection connection = null;
	
	//Methods
	
	/**
	 * Creates a connection between database and model.
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
	 * Returns the number of accounts in the database.
	 * @return the number of accounts.
	 */
	public int getNumOfAccounts() {
		connect();
		try {
			int count = 0 ;
			Statement myState = (Statement) connection.createStatement() ;
			ResultSet myRs = myState.executeQuery("select count(userID) from accounts");
			while (myRs.next()) {
				count = myRs.getInt("count(userID)");
				 }
			return count ;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if( connection != null )
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}
		
	
	

	/**
	 * Gets the user name with.
	 *
	 * @param ID the ýd
	 * @return the user name with
	 */
	public String getUserNameWith( int ID )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from accounts where userID = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			String s=null;

			while(myRs.next()) {
				s=myRs.getString("username");
			}
			return s;
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
	 * Gets the password with.
	 *
	 * @param ID the ýd
	 * @return the password with
	 */
	public String getPasswordWith( int ID )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from accounts where userID = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			String s=null;
			while(myRs.next()) {
				s=myRs.getString("password");
			}
			return s;
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
	 * Gets the question with.
	 *
	 * @param ID the ýd
	 * @return the question with
	 */
	public String getQuestionWith( int ID )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from accounts where userID = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			String s=null;
			while(myRs.next()) {
				s = myRs.getString("question");
			}
			return s;
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
	 * Gets the answer with.
	 *
	 * @param ID the ýd
	 * @return the answer with
	 */
	public String getAnswerWith( int ID )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from accounts where userID = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			String s=null;
			while(myRs.next()) {
				s = myRs.getString("answer");
			}
			return s;
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
	 * Gets the cash with.
	 *
	 * @param ID the ýd
	 * @return the cash with
	 */
	public double getCashWith( int ID )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from accounts where userID = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			double s = 0;
			while( myRs.next() ) {
				s = myRs.getDouble( "cash" );
			}
			return s;
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
	 * Gets the first access with.
	 *
	 * @param ID the ýd
	 * @return the first access with
	 */
	public long getFirstAccessWith( int ID )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from accounts where userID = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			long s = 0;
			while( myRs.next() ) {
				s = myRs.getLong( "firstAccess" );
			}
			return s;
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
	 * Gets the last access with.
	 *
	 * @param ID the ýd
	 * @return the last access with
	 */
	public long getLastAccessWith( int ID )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from accounts where userID = ? ");
			myState.setInt(1,ID);
			ResultSet myRs = myState.executeQuery();
			long s = 0;
			while( myRs.next() ) {
				s = myRs.getLong( "lastAccess" );
			}
			return s;
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
	 * Sets the user name with.
	 *
	 * @param ID the ýd
	 * @param name the name
	 */
	public void setUserNameWith( int ID, String name)   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update accounts set username = ? where userID = ?");
			myState.setString(1,name);
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
	 * Sets the password with.
	 *
	 * @param ID the ýd
	 * @param password the password
	 */
	public void setPasswordWith( int ID, String password )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update accounts set password = ? where userID = ?");
			myState.setString(1,password);
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
	 * Sets the cash with.
	 *
	 * @param ID the ýd
	 * @param cash the cash
	 */
	public void setCashWith( int ID, double cash )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update accounts set cash = ? where userID = ?");
			myState.setDouble(1,cash);
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
	 * Sets the last access with.
	 *
	 * @param ID the ýd
	 * @param lastAccess the last access
	 */
	public void setLastAccessWith( int ID, long lastAccess )   {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("update accounts set lastAccess = ? where userID = ?");
			myState.setLong(1,lastAccess);
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
	 * Adds the new user.
	 *
	 * @param ID the ýd
	 * @param name the name
	 * @param password the password
	 * @param question the question
	 * @param answer the answer
	 * @param cash the cash
	 * @param firstAccess the first access
	 * @param lastAccess the last access
	 */
	public void addNewUser(int ID, String name, String password, String question,String answer,double cash,long firstAccess,long lastAccess) {
		connect();
		try {
			PreparedStatement myState = (PreparedStatement) connection.prepareStatement("insert into accounts values(?,?,?,?,?,?,?,?)");
			myState.setInt(1,ID);
			myState.setString(2,name);
			myState.setString(3,password);
			myState.setString(4,question);
			myState.setString(5,answer);
			myState.setDouble(6,cash);
			myState.setLong(7,firstAccess);
			myState.setLong(8,lastAccess);
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

