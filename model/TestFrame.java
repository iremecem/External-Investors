package model;
import GUI.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

// TODO: Auto-generated Javadoc
/**
 * The Class TestFrame.
 */
public class TestFrame extends JFrame{
	
	/** The time listener. */
	TimeListener timeListener = new TimeListener() ;
	
	/** The value. */
	double value = 0;

	/** The timer. */
	Timer timer = new Timer( 1 , timeListener );
	
	/** The market time. */
	MarketTime marketTime = new MarketTime();
	
	/** The sc. */
	Scanner sc = new Scanner( System.in );
	
	/** The mod. */
	int mod = 0;
	
	/** The stocks. */
	ArrayList<Stock> stocks = new ArrayList<Stock>();
	
	/** The num of stocks. */
	int numOfStocks;
	
	
	/**
	 * Instantiates a new test frame.
	 */
	public TestFrame() {
		
		timer.start();
		
		for( int i = 0 ; i < 10 ; i++ ) {
			
			stocks.add( new Stock( i ) );
			
			System.out.println( stocks.get( i ) );
			
		}
	}
	
	/**
	 * The listener interface for receiving time events.
	 * The class that is interested in processing a time
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addTimeListener<code> method. When
	 * the time event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see TimeEvent
	 */
	class TimeListener implements ActionListener{


		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			MarketTime.increaseCurrentTime();

			//System.out.println(  MarketTime.getCurrentTime() );
			
			mod++;
			if( mod == 100 ) {
				
				mod = 0;
				marketTime = new MarketTime();
				System.out.println(  marketTime );
				value += 0.1;

			}
			
			for( int i = 0 ; i < stocks.size() ; i++ ) {
				
				stocks.get( i ).increase( 2 );
				
			}
			
			
		


		}

	}
}
