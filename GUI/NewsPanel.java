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
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

// TODO: Auto-generated Javadoc
/**
 * The Class NewsPanel.
 */
public class NewsPanel extends JPanel implements Observer {


	/** The top frame. */
	//Properties
	JFrame topFrame;
	
	/** The panel. */
	JPanel panel;
	
	/** The scrollpane. */
	JScrollPane scrollpane;
	
	/** The all news panel. */
	JPanel allNewsPanel = new JPanel();

	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public NewsPanel(JFrame frame) {

		topFrame = frame;

		setPreferredSize (new Dimension(850, 700));
		setLayout(null);

		JLabel lblNewLabel = new JLabel("News");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setBounds(80, 63, 177, 31);
		add(lblNewLabel);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDate.setBounds(705, 162, 43, 16);
		add(lblDate);

		JLabel lblNewLabel_1 = new JLabel("Time");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(528, 162, 43, 16);
		add(lblNewLabel_1);


		//add empty scroll pane
		add( scrollpane = new JScrollPane(  ) );
		
		//update all news
		updateAllNewsPanel();

		repaint();
	}
	
	/**
	 * updates all news panel and shows it on the screen properly.
	 */
	
	private void updateAllNewsPanel() {
		
		//remove previous scroll pane
		this.remove(scrollpane);
		
		//set all news panel to new panel
		allNewsPanel = new JPanel();
		
		//set its layout
		allNewsPanel.setLayout( new GridLayout(  ( (ExternalInvestors)topFrame ).getNewsContainer().getSize(),1  )  );
		
		//add all news inside the all news panel
		for( int i = ((ExternalInvestors)topFrame).getNewsContainer().getSize() - 1; i >= 0; i--) {
			allNewsPanel.add(new NewsLine(topFrame, ((ExternalInvestors)topFrame).getNewsContainer().getNews().get(i)));
		}
		
		//add new allNewsPanel to scroll pane
		scrollpane = new JScrollPane( allNewsPanel );
		scrollpane.setBounds(20, 180, 780, 443);
		
		//add scroll pane
		add(scrollpane);
		
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	
	public void update( Observable obs, Object obj )
	{
		
		
		if ( obs == ((ExternalInvestors)topFrame).getNewsContainer() )
		{
			
			updateAllNewsPanel();
			
			allNewsPanel.revalidate();
			allNewsPanel.repaint();
			revalidate();
			repaint();
		}
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		//super.paintComponent(g);
		g.drawLine(30, 100, 550, 100);
		g.drawLine(527, 190, 575, 190);
		g.drawLine(718, 190, 765, 190);
	}
}
