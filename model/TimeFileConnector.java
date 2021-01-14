package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * This class is responsible for the store and read current time from text file.
 * @author Arda Göktoðan
 * @version 16.12.2018
 */
public class TimeFileConnector {
	
	//properties
	
	/** The file. */
	File file = new File("C:\\Users\\erens\\Desktop\\time.txt");
	
	/** The in. */
	Scanner in;
	
	/** The pw. */
	PrintWriter pw;
	
	/**
	 * reads the time from text file and returns it.
	 *
	 * @return the long
	 */
	public long readTime(){
		
		try {
			in = new Scanner( file );
			long time = in.nextLong();
			return time;
        } catch ( FileNotFoundException e) {
        	System.out.println(" Time file not found :(");
        }
		
		return 0;
		
	}
	
	/**
	 * writes the time to text file.
	 * @param time time that is going to be written to text file.
	 */
	public void writeTime( long time ) {
		try {
			pw = new PrintWriter( file );	
		} catch ( FileNotFoundException e) {
        	System.out.println(" Time file not found :(");
        }

		pw.print( time );
		pw.close();
	}

	

}
