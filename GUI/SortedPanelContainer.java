/*
 * 
 */
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class SortedPanelContainer.
 */
public class SortedPanelContainer {

	/** The panels. */
	// Properties
	ArrayList<SortedPanel> panels; 
	
	/** The stocks. */
	ArrayList<Stock> stocks;
	
	/** The top frame. */
	JFrame topFrame;
	
	/** The market. */
	Market market;
	
	/**
	 * Instantiates a new sorted panel container.
	 *
	 * @param frame the frame
	 */
	public SortedPanelContainer(JFrame frame) {
		
		panels = new ArrayList<SortedPanel>();
		topFrame = frame;
		//add (new SortedPanel( new Stock(0) ));
		
	}
	
	/**
	 * Adds panel to container.
	 *
	 * @param panel the panel to be added
	 */
	public void add (SortedPanel panel) {
		panels.add(panel);
		
	}
	
	/**
	 * Sort by ýncreasing value.
	 *
	 * @return the array list
	 */
	public ArrayList<SortedPanel> sortByIncreasingValue( ) {
		
		stocks = ((ExternalInvestors)topFrame).getMarket().getSortedList(true);
		//System.out.println( stocks );
		
		panels = new ArrayList<SortedPanel>();
		for ( Stock stock: stocks ) {
			
			//System.out.println( panels );
			add (new SortedPanel( stock,topFrame ));
		}
		return panels;
	}
	
	/**
	 * Sort by decreasing value.
	 *
	 * @return the array list
	 */
	public ArrayList<SortedPanel> sortByDecreasingValue( ) {
		stocks = ((ExternalInvestors)topFrame).getMarket().getSortedList(false);
		
		//System.out.println( stocks );
		panels = new ArrayList<SortedPanel>();
		for (Stock stock: stocks) {
			
			add (new SortedPanel(stock , topFrame ));
		}
		return panels;
	}
	
	/**
	 * Sort by ýncreasing value.
	 *
	 * @param market the market
	 * @return the array list
	 */
	// @overloading
	public ArrayList<SortedPanel> sortByIncreasingValue (Market market) {
		stocks = market.getSortedList(true);
		//System.out.println( stocks );
		
		panels = new ArrayList<SortedPanel>();
		for ( Stock stock: stocks ) {
			
			//System.out.println( panels );
			add (new SortedPanel(stock , topFrame));
		}
		return panels;
	}
	
	/**
	 * Sort by decreasing value.
	 *
	 * @param market the market
	 * @return the array list
	 */
	// @overloading
	public ArrayList<SortedPanel> sortByDecreasingValue(Market market) {
		stocks = market.getSortedList(false);
		
		//System.out.println( stocks );
		panels = new ArrayList<SortedPanel>();
		for (Stock stock: stocks) {
			
			add (new SortedPanel(stock , topFrame ));
		}
		return panels;
	}

	/**
	 * Sort by ýncreasing change.
	 *
	 * @param market the market
	 * @return the array list
	 */
	public ArrayList<SortedPanel> sortByIncreasingChange(Market market) {
		stocks = market.getDailySortedList(true);
		
		//System.out.println( stocks );
		panels = new ArrayList<SortedPanel>();
		for (Stock stock: stocks) {
			
			add (new SortedPanel(stock , topFrame ));
		}
		return panels;
	}

	/**
	 * Sort by decreasing change.
	 *
	 * @param market the market
	 * @return the array list
	 */
	public ArrayList<SortedPanel> sortByDecreasingChange(Market market) {
		stocks = market.getDailySortedList(false);
		panels = new ArrayList<SortedPanel>();
		for (Stock stock: stocks) {
			
			add (new SortedPanel(stock, topFrame));
		}
		return panels;
	}
	
	/**
	 * Sort by ýncreasing change.
	 *
	 * @return the array list
	 */
	public ArrayList<SortedPanel> sortByIncreasingChange() {
		stocks = ((ExternalInvestors)topFrame).getMarket().getDailySortedList(true);
		panels = new ArrayList<SortedPanel>();
		for (Stock stock: stocks) {
			
			add (new SortedPanel(stock, topFrame));
		}
		return panels;
	}
	
	/**
	 * Sort by decreasing change.
	 *
	 * @return the array list
	 */
	public ArrayList<SortedPanel> sortByDecreasingChange() {
		stocks = ((ExternalInvestors)topFrame).getMarket().getDailySortedList(false);
		panels = new ArrayList<SortedPanel>();
		for (Stock stock: stocks) {
			
			add (new SortedPanel(stock, topFrame));
		}
		return panels;
	}
	
//	public ArrayList<SortedPanel> getPanels() {
//		return 
//	}
	
}
