/*
 * 
 */
package GUI;

import model.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

// TODO: Auto-generated Javadoc
/**
 * The Class MarketPanel.
 */
public class MarketPanel extends JPanel {

	/** The search field. */
	private JTextField searchField;
	
	/** The container. */
	private SortedPanelContainer container;
	
	/** The panels. */
	private ArrayList<SortedPanel> panels;
	
	/** The market panel. */
	JPanel marketPanel;
	
	/** The combo box. */
	JComboBox<String> comboBox;


	/** The top frame. */
	//Properties
	JFrame topFrame;
	
	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public MarketPanel(JFrame frame) {

		setPreferredSize (new Dimension(850, 700));
		setLayout(null);

		topFrame = frame;
		container = new SortedPanelContainer(frame);		

		JLabel lblNewLabel = new JLabel("Market");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(80, 63, 85, 31);
		add(lblNewLabel);

		JLabel lblSortBy = new JLabel("Sort by");
		lblSortBy.setBounds(50, 139, 50, 16);
		add(lblSortBy);

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setBounds(335, 139, 50, 16);
		add(lblSearch);

		searchField = new JTextField();
		searchField.setBounds(389, 132, 156, 30);
		add(searchField);
		searchField.setColumns(10);

		marketPanel = new JPanel();
		marketPanel.setBounds(50, 220, 850, 400);
		marketPanel.setLayout(new GridLayout (10, 1));
		add(marketPanel);


		JButton searchButton = new JButton("Search");
		searchButton.setBounds(546, 134, 98, 29);

		searchButton.addActionListener( new SearchListener() );

		add(searchButton);

		JLabel lblBuy = new JLabel("Buy ($)");
		lblBuy.setBounds(263, 185, 44, 16);
		add(lblBuy);

		JLabel lblSell = new JLabel("Sell ($)");
		lblSell.setBounds(471, 185, 50, 16);
		add(lblSell);

		JLabel lblName = new JLabel("Stock Name");
		lblName.setBounds(55, 185, 75, 16);
		add(lblName);

		JLabel lblChange = new JLabel("Change (%)");
		lblChange.setBounds(685, 185, 70, 16);
		add(lblChange);



		comboBox = new JComboBox<String>();
		comboBox.setBounds(101, 135, 144, 27);
		comboBox.addItem("Increasing");
		comboBox.addItem("Decreasing");
		comboBox.addItem("Change: Low to High");
		comboBox.addItem("Change: High to Low");

		panels = container.sortByIncreasingValue();
		//System.out.println( "panels: " + panels );

		for (SortedPanel panel : panels) {
			marketPanel.add(panel);
		}

		comboBox.addActionListener( new SearchListener() );

		add(comboBox);

		repaint();
	}


	/**
	 * The listener interface for receiving search events.
	 * The class that is interested in processing a search
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addSearchListener<code> method. When
	 * the search event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see SearchEvent
	 */
	class SearchListener implements ActionListener {

		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent e) {

			marketPanel.removeAll();

			String s = (String) comboBox.getSelectedItem();

			if ( s.equals("Increasing") && searchField.getText().length() == 0) {

				panels = container.sortByIncreasingValue();

				for (SortedPanel panel : panels) {
					marketPanel.add(panel);
				}
			}


			else if ( s.equals("Increasing") && searchField.getText().length() != 0) {

				String text = searchField.getText();
				Market searchedMarket = ((ExternalInvestors)topFrame).getMarket().getSearchingResults( text );
				panels = container.sortByIncreasingValue(searchedMarket);

				for (SortedPanel panel : panels) {
					marketPanel.add(panel);
				}
			}


			else if (s.equals("Decreasing") && searchField.getText().length() == 0) {

				panels = container.sortByDecreasingValue();

				for (SortedPanel panel : panels) {
					marketPanel.add(panel);
				}
			}


			else if ( s.equals("Decreasing") && searchField.getText().length() != 0) {

				String text = searchField.getText();
				Market searchedMarket = ((ExternalInvestors)topFrame).getMarket().getSearchingResults( text );
				panels = container.sortByDecreasingValue(searchedMarket);

				for (SortedPanel panel : panels) {
					marketPanel.add(panel);
				}
			}


			else if ( s.equals("Change: Low to High") && searchField.getText().length() == 0 ) {

				panels = container.sortByIncreasingChange();

				for (SortedPanel panel : panels) {
					marketPanel.add(panel);
				}
			}

			else if( s.equals("Change: Low to High") && searchField.getText().length() != 0 ) {

				String text = searchField.getText();
				Market searchedMarket = ((ExternalInvestors)topFrame).getMarket().getSearchingResults( text );
				panels = container.sortByIncreasingChange(searchedMarket);

				for (SortedPanel panel : panels) {
					marketPanel.add(panel);
				}
			}

			else if ( s.equals("Change: High to Low") && searchField.getText().length() == 0 ) {

				panels = container.sortByDecreasingChange();

				for (SortedPanel panel : panels) {
					marketPanel.add(panel);
				}
			}

			else if( s.equals("Change: High to Low") && searchField.getText().length() != 0 ) {

				String text = searchField.getText();
				Market searchedMarket = ((ExternalInvestors)topFrame).getMarket().getSearchingResults( text );
				panels = container.sortByDecreasingChange(searchedMarket);

				for (SortedPanel panel : panels) {
					marketPanel.add(panel);
				}
			}

			repaint();
		}
	}



	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawLine(30, 110, 800, 110);
		g.drawLine(30, 210, 800, 210);
	}


	//	public JPanel setSortedPanel(String stockName, int sell, int buy,int change)
	//	{
	//		JPanel panel = new JPanel();
	//		setPreferredSize (new Dimension(850, 700));
	//		return panel;
	//	}
}
