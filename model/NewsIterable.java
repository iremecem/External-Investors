package model;

import java.io.FileNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * An interface containing next and shuffle methods.
 *
 * @author Duygu Nur Yaldiz
 * @version 09.12.2018
 */
public interface NewsIterable {

	/**
	 * Next.
	 *
	 * @return the news
	 * @throws FileNotFoundException the file not found exception
	 */
	//Methods
	public News next() throws FileNotFoundException ;
	
	/**
	 * Shuffle.
	 */
	public void shuffle();
	
}
