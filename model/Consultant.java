package model;

// TODO: Auto-generated Javadoc
/**
 * A class that holds all necessary information of an consultant.
 * @author Eren Þenoðlu
 * @version 23.12.2018
 */
public class Consultant {

	//Properties
	
	/** The price. */
	private int price;
	
	/** The name. */
	private String name; 
	
	/** The success rate. */
	private int successRate;
	
	/** The text. */
	private String text;
	
	/** The photo. */
	private String photo;
	
	//Constructor
	/**
	 * Constructs a new account object by using given parameters.
	 * @param price cost of the consultant
	 * @param successRate the success rate of the predictions made by consultant 
	 * @param name the name of the consultant
	 * @param text the dialog message of the consultant
	 * @param photo the location of the photo file for consultant
	 */
	
	public Consultant(int price, int successRate, String name, String text,String photo ) {
	
	this.price = price;
	this.successRate = successRate;
	this.text = text;
	this.name = name;
	this.photo = photo;
	}
	
	/**
	 * According to given active user, takes the values of account from account, subtracts the cost and then sets. Returns true if user have
	 * enough money.
	 *
	 * @param activeUser the active user
	 * @return result boolean.
	 */
	
	public boolean consult(Account activeUser) {
		if(activeUser.getCash() >= price) {
			System.out.println(activeUser.getCash());
			activeUser.setCash(activeUser.getCash()-price);
			System.out.println(activeUser.getCash());
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the price.
	 *
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Returns the successRate.
	 *
	 * @return the successRate
	 */
	public int getRate() {
		return successRate;
	}
	
	/**
	 * Returns the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Returns the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the photo.
	 *
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	
	/**
	 * Gets the advice.
	 *
	 * @param activeUser the active user
	 * @param News the news
	 * @return the advice
	 */
	public String getAdvice(Account activeUser, News News) {
		return null;
	}
}
