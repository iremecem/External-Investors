package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * A class to read information of a new news and to create news object according to the information in the text file.
 * @author Duygu Nur Yaldiz, Arda Göktoðan
 * @version 16.12.2018
 */
public class NewsFileReader {

	/** The news. */
	//Properties 
	News news;

	/**
	 * Instantiates a new news file reader.
	 *
	 * @param fileName the file name
	 * @throws FileNotFoundException the file not found exception
	 */
	public NewsFileReader( String fileName ) throws FileNotFoundException {
		
		String s = "C:\\Users\\erens\\Downloads\\";
		fileName = s + fileName;
		//Create file and scanner objects to read news's information
		
		File file = new File( fileName );
		Scanner in = new Scanner( file );

		//read all the information from the text file
		
		String text = "";
		int id = Integer.parseInt(in.nextLine());
		String title = in.nextLine();
		String author = in.nextLine();
		int compID = Integer.parseInt(in.nextLine());
		double effectRate = Double.parseDouble(in.nextLine());
		while( in.hasNextLine())
			text += in.nextLine();
		in.close();

		MarketTime date = new MarketTime();

		//create news object
		
		news = new News( id , title, author, text, date , compID, effectRate );
	}

	/**
	 * Gets the news.
	 *
	 * @return the news
	 */
	public News getNews() {
		return news;
	}
}
