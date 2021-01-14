/*
 * 
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Account;
import model.AllNews;
import model.Consultant;

// TODO: Auto-generated Javadoc
/**
 * The Class ConsultantPanelOne.
 */
public class ConsultantPanelOne extends JPanel {
	
	/** The top frame. */
	JFrame topFrame;
	
	/** The active user. */
	Account activeUser;
	
	/** The game model. */
	ExternalInvestors gameModel;
	
	/** The consultant. */
	Consultant consultant;
	
	/** The img. */
	BufferedImage img;
	
	/**
	 * Instantiates a new consultant panel one.
	 *
	 * @param frame the frame
	 * @param consultant the consultant
	 */
	public ConsultantPanelOne(JFrame frame, Consultant consultant) {
		
		this.consultant = consultant;
		topFrame = frame;
		activeUser = ( ( ExternalInvestors ) topFrame ).getAccountContainer().getActiveUser();
		gameModel = ( ExternalInvestors ) topFrame;
		
		//System.out.println(activeUser.getID());
		//set panel's properties
		setPreferredSize (new Dimension(850, 700));
		setLayout(null);

		//Create labels
		JLabel headerLabel = new JLabel("Consultant");
		headerLabel.setBounds(84, 63, 476, 31);
		headerLabel.setForeground(Color.BLUE);
		headerLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		add(headerLabel);
		
		JLabel consultantName = new JLabel(consultant.getName());
		consultantName.setBounds(200, 150, 476, 31);
		consultantName.setForeground(Color.BLACK);
		consultantName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(consultantName);
		
		//int a = gameModel.allNews.getIndex();
		//System.out.println(a);
		//System.out.println(activeUser.getStocks().getStock(a).getCompanyName());
		//double b = gameModel.allNews.getNews()[a].effectRate;
		JLabel adviceInfo = new JLabel();
		String myString2 = "<html> I'm expecting a rise from Microsoft Company in short term. I think we can buy some stocks from Microsoft."
				+ " </html>";
		adviceInfo.setText(myString2);
		adviceInfo.setBounds(200, 160, 476, 116);
		adviceInfo.setForeground(Color.BLACK);
		adviceInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		add(adviceInfo);
		
		
		JButton marketLabel = new JButton("Go To Market");
		marketLabel.setBounds(160, 565, 200, 31);
		marketLabel.setForeground(Color.RED);
		marketLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		//Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		//consultLabel.setBorder(border);
		marketLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				((ExternalInvestors)topFrame).changeMainPanel(7);
				
			}
		});
		add(marketLabel);
		
		JButton returnLabel = new JButton("Return");
		returnLabel.setBounds(460, 565, 200, 31);
		returnLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		//Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
		//consultLabel.setBorder(border);
		returnLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				((ExternalInvestors)topFrame).changeMainPanel(16);
				
			}
		});
		add(returnLabel);
		
		try {
			img = ImageIO.read( new File( consultant.getPhoto() ) );
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {

		//super.paintComponent(g);
		g.drawLine(30, 110, 800, 110);
		g.drawImage(img, 60, 150, null);
		g.drawRect(60, 150, 120, 150);
	}
}
