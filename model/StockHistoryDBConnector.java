package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;



// TODO: Auto-generated Javadoc
/**
 * The Class StockHistoryDBConnector.
 */
public class StockHistoryDBConnector {
		
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
		 * Gets the stock history datum.
		 *
		 * @param ID the ýd
		 * @return the stock history datum
		 */
		public ArrayList<StockHistoryDatum> getStockHistoryDatum( int ID )   {

			connect();
			
			try {
				StockHistoryDatum a ;
				ArrayList<StockHistoryDatum> arr = new ArrayList<StockHistoryDatum>();
				PreparedStatement myState = (PreparedStatement) connection.prepareStatement("select * from stockHistory where stockID = ? ");
				myState.setInt(1,ID);
				ResultSet myRs = myState.executeQuery();
				while(myRs.next()) {
					a = new StockHistoryDatum(myRs.getDouble("buyValue"),myRs.getDouble("sellValue"),new MarketTime(myRs.getLong("date")));
					arr.add(a);
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
		 * Adds the stock history.
		 *
		 * @param buyValue the buy value
		 * @param sellValue the sell value
		 * @param date the date
		 * @param stockID the stock ID
		 */
		public void addStockHistory(double buyValue,double sellValue, long date, int stockID) {
			connect();
			try {
				PreparedStatement myState = (PreparedStatement) connection.prepareStatement("insert into stockHistory values(?,?,?,?)");
				myState.setDouble(1,buyValue);
				myState.setDouble(2,sellValue);
				myState.setLong(3,date);
				myState.setInt(4,stockID);
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


