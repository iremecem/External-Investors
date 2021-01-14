/*
 * 
 */
package GUI;


import model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JScrollBar;

// TODO: Auto-generated Javadoc
/**
 * The Class InAndOutPanel.
 */
public class InAndOutPanel extends JPanel {

	/** The top frame. */
	//Properties
	JFrame topFrame;
	
	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public InAndOutPanel(JFrame frame) {
		topFrame = frame;
		
		((ExternalInvestors)topFrame).resetNews();	

		setPreferredSize (new Dimension(850, 700));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("In and Out Report");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(80, 63, 235, 31);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Stock Name");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(60, 148, 92, 20);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Change In Value");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(196, 149, 129, 20);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Old Price ($)");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(371, 149, 94, 20);
		add(lblNewLabel_3);

		JLabel lblNewPrice = new JLabel("New Price ($)");
		lblNewPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewPrice.setBounds(510, 149, 94, 20);
		add(lblNewPrice);

		int xMargin1 = 60;
		int xMargin2 = 196;
		int xMargin3 = 371;
		int xMargin4 = 510;

		int yMargin = 150;
		int rowMargin = 40;

		JLabel stockName;
		JLabel changeLabel;
		JLabel oldPriceLabel;
		JLabel newPriceLabel;
		MarketTime lastAccess = ( (ExternalInvestors)topFrame ).getAccountContainer().getActiveUser().getLastAccess(); 
		
		for( int  i = 1 ; i <= StockContainer.TOTAL_NUM_OF_STOCKS ; i++ ) {
			
			System.out.println(i);

			//create labels
			stockName = new JLabel();
			changeLabel = new JLabel( );
			oldPriceLabel = new JLabel( );
			newPriceLabel = new JLabel( );
			

			stockName.setText( "" + ( (ExternalInvestors)topFrame).getMarket().getStocks()[i-1].getCompanyName()  );  
			stockName.setBounds( xMargin1, yMargin + rowMargin*i , 150, 20);
			add(stockName);

			String difference = String.format( "%.3f", ( (ExternalInvestors)topFrame).getMarket().getStocks()[i-1].getDifference( lastAccess, new MarketTime() ) );
			changeLabel.setText( "" + difference  );
			changeLabel.setBounds( xMargin2, yMargin + rowMargin*i , 150, 20);
			add(changeLabel);
			
			String oldPrice = String.format( "%.3f", ( (ExternalInvestors)topFrame).getMarket().getStocks()[i-1].getStockHistory().getHistoryDataAt( lastAccess ).getBuyValue() );
			oldPriceLabel.setText( "" + oldPrice  );
			oldPriceLabel.setBounds( xMargin3, yMargin + rowMargin*i , 150, 20);
			add(oldPriceLabel);
			
			String newPrice = String.format( "%.3f", ( (ExternalInvestors)topFrame).getMarket().getStocks()[i-1].getBuyValue() );
			newPriceLabel.setText( "" + newPrice  );
			newPriceLabel.setBounds( xMargin4, yMargin + rowMargin*i , 150, 20);
			add(newPriceLabel);

		}



		//JScrollBar scrollBar = new JScrollBar();
		//scrollBar.setBounds(773, 178, 15, 414);
		//add(scrollBar);

		repaint();
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		//super.paintComponent(g);
		g.drawLine(30, 110, 550, 110);
	}
}
