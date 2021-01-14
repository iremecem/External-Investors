/*
 * 
 */
package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import GUI.ExternalInvestors;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.*;

// TODO: Auto-generated Javadoc
/**
 * The Class NewsLine.
 */
public class NewsLine extends JPanel {

	/** The top frame. */
	//Properties
	JFrame topFrame;
	
	/** The news. */
	News news;

	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 * @param news the news
	 */
	public NewsLine( JFrame frame, News news ) {
		
		topFrame = frame;
		this.news = news;
		
		setPreferredSize (new Dimension(750, 57));
		setLayout(null);

		JLabel lblTitle = new JLabel(news.getTitle());
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(86, 13, 340, 33);
		add(lblTitle);

		JLabel lblTime = new JLabel( "" + news.getDate().getHour() + " : " + news.getDate().getMin());
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(498, 22, 91, 16);
		add(lblTime);

		JLabel lblDate = new JLabel("" + news.getDate().getDay() + "." + news.getDate().getMonth() + "." + news.getDate().getYear());
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(601, 22, 137, 16);
		add(lblDate);

		JButton readButton = new JButton("READ");
		readButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		readButton.setHorizontalAlignment(SwingConstants.LEFT);
		readButton.setBounds(7, 13, 70, 34);
		readButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((ExternalInvestors)topFrame).changeMainPanel(news);
			}
		});
		add(readButton);

	}
}
