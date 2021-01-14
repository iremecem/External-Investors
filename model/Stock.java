
package model;
// TODO: Auto-generated Javadoc
/**
 * 
 * This class represents the Stock objects and includes relevant functions.
 * @author Arda Göktoðan, Duygu Nur Yaldýz
 * @version 16.12.2018 
 * 
 */
public class Stock {

	//constants

	/** The ýnýtýal value. */
	public final double INITIAL_VALUE;

	/** The Constant BUY_SELL_RATIO. */
	public static final double BUY_SELL_RATIO = 0.85 ;
	
	/** The Constant EXTENDION_VALUE. */
	public static final double EXTENDION_VALUE = 10;
	
	/** The Constant CHANGE_RATE. */
	public static final double CHANGE_RATE = 0.05;
	
	/** The Constant MIN_VALUE. */
	public static final int MIN_VALUE = 5;

	//properties

	/** The buy value. */
	private double buyValue;
	
	/** The sell value. */
	private double sellValue;
	
	/** The company name. */
	private String companyName;
	
	/** The company ID. */
	private int companyID;
	
	/** The stock history. */
	private StockHistory stockHistory;
	
	/** The DB connector. */
	StockDBConnector DBConnector = new StockDBConnector();


	/**
	 * Constructs stock object with given companyID, set the properties of
	 * stock according to the values in the database.
	 *
	 * @param companyID the company ID
	 */
	public Stock( int companyID ) {

		//DATABASE CONNECTION
		
		buyValue = DBConnector.getBuyValueWith( companyID );
		sellValue = DBConnector.getSellValueWith( companyID );
		companyName = DBConnector.getCompanyNameWith( companyID );
		this.companyID = companyID;
		INITIAL_VALUE = DBConnector.getInitialValueWith( companyID );
		stockHistory = new StockHistory( companyID );

	}

	/**
	 * increases the value of stock according to number of sold stocks.
	 *
	 * @param numberOfStocks the number of stocks
	 */
	public void increase( int numberOfStocks ) {
		
		buyValue = buyValue + ( CHANGE_RATE * numberOfStocks );

		//set the sell value according to new buy value
		
		sellValue = buyValue * BUY_SELL_RATIO;
		
		
		//reflect changes of buy value and sell value to database
		
		DBConnector.setBuyValueWith( companyID , buyValue );
		
		DBConnector.setSellValueWith( companyID , sellValue );
		
		//add new change to stock history
		
		stockHistory.add( new StockHistoryDatum( buyValue , sellValue , new MarketTime() , companyID ) );
		
	}

	
	/**
	 * decreases the value of stock according to number of bought stocks.
	 *
	 * @param numberOfStocks the number of stocks
	 */
	public void decrease( int numberOfStocks ) {
		
		buyValue = Math.max( buyValue - ( CHANGE_RATE * numberOfStocks ) , MIN_VALUE );

		//set the sell value according to new buy value
		
		sellValue = buyValue * BUY_SELL_RATIO;
		
		//reflect changes of buy value and sell value to database
		
		DBConnector.setBuyValueWith( companyID , buyValue );
		
		DBConnector.setSellValueWith( companyID , sellValue );
		
		//add new change to stock history
		
		stockHistory.add( new StockHistoryDatum( buyValue , sellValue , new MarketTime() , companyID ) );

	}

	/**
	 * returns the difference between of stock value in two different time.
	 *
	 * @param firstDate first date of difference
	 * @param lastDate second date of difference
	 * @return difference of stock value between first date and second date
	 */
	public double getDifference( MarketTime firstDate, MarketTime lastDate ) {

		return stockHistory.getDifference(firstDate, lastDate);

	}

	/**
	 * returns the buy value.
	 *
	 * @return buy value
	 */
	public double getBuyValue() {
		return buyValue;
	}

	/**
	 * returns the sell value.
	 *
	 * @return sell value
	 */
	public double getSellValue() {
		return sellValue;
	}

	/**
	 * returns the company name.
	 *
	 * @return company name
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * returns the company id.
	 *
	 * @return company id
	 */
	public int getCompanyID() {
		return companyID;
	}

	/**
	 * returns the stock history of stock.
	 *
	 * @return stock history
	 */
	public StockHistory getStockHistory() {
		return stockHistory;
	}

	/**
	 * set the buy value.
	 *
	 * @param buyValue new buy value
	 */
	public void setBuyValue(double buyValue) {
		
		this.buyValue = buyValue;
		
		DBConnector.setBuyValueWith( companyID , buyValue );
		

	}

	/**
	 * set the sell value.
	 *
	 * @param sellValue new sell value.
	 */
	public void setSellValue(double sellValue) {
		
		this.sellValue = sellValue;
		
		DBConnector.setSellValueWith( companyID , sellValue );
		
		//add new change to stock history
		
		
	}
	
	/**
	 * returns the string representation of a single stock.
	 * @return the string representation of a single stock.
	 */
	public String toString() {
		
		String s = new String();
		s = "CompanyName : "+ companyName;
		s += "\nbuyValue = " + buyValue + "  SellValue = " + sellValue + "\n";
		
		return s;
	}



}
