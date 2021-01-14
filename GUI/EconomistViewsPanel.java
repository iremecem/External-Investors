/*
 * 
 */
package GUI;

import model.*;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

// TODO: Auto-generated Javadoc
/**
 * The Class EconomistViewsPanel.
 */
public class EconomistViewsPanel extends JPanel {

	/** The top frame. */
	//Properties
		JFrame topFrame;
	
	/**
	 * Create the panel.
	 *
	 * @param frame the frame
	 */
	public EconomistViewsPanel(JFrame frame) {
		
		topFrame = frame;
		
		setPreferredSize (new Dimension(850, 700));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Economists' Views");
		lblNewLabel.setForeground(UIManager.getColor("Button.light"));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(80, 63, 229, 31);
		add(lblNewLabel);
		
	}

}
