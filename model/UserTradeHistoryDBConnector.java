package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;



// TODO: Auto-generated Javadoc
/**
 * The Class UserTradeHistoryDBConnector.
 */
public class UserTradeHistoryDBConnector {

	
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
		 * Gets the user trade history.
		 *
		 * @param userID the user ID
		 * @return the user trade history
		 */
		public ArrayList<TradeAction> getUserTradeHistory( int userID )   {

			connect();
			StockDBConnector stockDB = new StockDBConnector();
			try {
				String compName;
				TradeAction result ;
				ArrayList<TradeAction> arr = new ArrayList<TradeAction>();
				PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from userTradeHistory where userID = ? ");
				myState.setInt(1,userID);
				ResultSet myRs = myState.executeQuery();
				while(myRs.next()) {
					compName = stockDB.getCompanyNameWith(myRs.getInt("stockID"));
					result = new TradeAction(compName,myRs.getBoolean("bs"),myRs.getInt("numOfStocks"),myRs.getDouble("value"),new MarketTime(myRs.getLong("date")));
					arr.add(result);
				}
				
				return arr;
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
		 * Adds the trade action.
		 *
		 * @param buyOrSell the buy or sell
		 * @param stockID the stock ID
		 * @param numberOfStocks the number of stocks
		 * @param date the date
		 * @param userID the user ID
		 * @param value the value
		 */
		public void addTradeAction( boolean buyOrSell,int stockID, int numberOfStocks, long date, int userID, double value) {
			connect();
			try {
				PreparedStatement myState = (PreparedStatement) connection.prepareStatement("insert into userTradeHistory values(?,?,?,?,?,?)");
				myState.setBoolean(1,buyOrSell);
				myState.setLong(2,stockID);
				myState.setInt(3,numberOfStocks);
				myState.setLong(4,date);
				myState.setInt(5,userID);
				myState.setDouble(6,value);
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


