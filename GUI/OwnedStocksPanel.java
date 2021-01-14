/*
 * 
 */
package GUI;

import model.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

// TODO: Auto-generated Javadoc
/**
 * The Class OwnedStocksPanel.
 */
public class OwnedStocksPanel extends JPanel {

 /** The text field. */
 private JTextField textField;

 /** The top frame. */
 //Properties
 JFrame topFrame;

 /**
  * Create the panel.
  *
  * @param frame the frame
  */
 public OwnedStocksPanel(JFrame frame) {

  topFrame = frame;

  //setBackground(new Color(240, 248, 255));

  setPreferredSize (new Dimension(850,700));
  setLayout(null);

  JLabel profileLabel = new JLabel("Profile");
  profileLabel.setForeground(UIManager.getColor("Button.light"));
  profileLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
  profileLabel.setBounds(45, 45, 85, 31);
  add(profileLabel);

  JLabel generalInformationLabel = new JLabel("> Owned Stocks");
  generalInformationLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
  generalInformationLabel.setBounds(131, 45, 275, 31);
  add(generalInformationLabel);
  
  JLabel lblStockName = new JLabel("Stock Name");
  lblStockName.setBounds(45, 162, 85, 16);
  add(lblStockName);
  
  JLabel lblAmount = new JLabel("Amount");
  lblAmount.setBounds(230, 162, 59, 16);
  add(lblAmount);
  
  JLabel lblCurrentValuePer = new JLabel("Current Value");
  lblCurrentValuePer.setBounds(353, 141, 93, 23);
  add(lblCurrentValuePer);
  
  JLabel lblPerStock = new JLabel("Per Stock ($)");
  lblPerStock.setBounds(353, 162, 83, 16);
  add(lblPerStock);
  
  JLabel lblTotalValue = new JLabel("Total Value ($)");
  lblTotalValue.setBounds(504, 162, 93, 16);
  add(lblTotalValue);
  
  
  JLabel lblProfit = new JLabel("Profit");
  lblProfit.setBounds(685, 162, 44, 16);
  add(lblProfit);
  
  JPanel stockPanel = new OwnedStockPanel(topFrame);
  stockPanel.setBounds(45, 200, 800, 400);
  add(stockPanel);

  repaint();

  
 }

 /* (non-Javadoc)
  * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
  */
 public void paintComponent(Graphics g) {

  //super.paintComponent(g);
  g.drawLine(30, 100, 800, 100);
  g.drawLine(30 , 195, 800, 195);
  
 }
}
