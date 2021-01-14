package model;

import java.io.FileNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class NewsTest.
 *
 * @author Acer
 */
public class NewsTest {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		AllNews all = new AllNews();
		
		System.out.println(all.next().toString());
		System.out.println(all.next().toString());
		System.out.println(all.next().toString());
		System.out.println(all.next().toString());
		
	}

}
