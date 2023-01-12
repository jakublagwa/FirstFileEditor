package UserInterface;

import javax.swing.*;

//java awt window setVisible(boolean)

public class PopUpFrameOne {
	
	public PopUpFrameOne() {
		JFrame frameTwo = new JFrame("The second window.");
		initComponentsFrameTwo(frameTwo);
		frameTwo.setVisible(false);
	}
	private void initComponentsFrameTwo(JFrame frameTwo) {
		frameTwo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTwo.setSize(800, 800);
		frameTwo.setLayout(null);
		
		JLabel label = new JLabel("The second window.");
		frameTwo.getContentPane().add(label);
		
		JButton bSetFileName = new JButton("SET FILE NAME");
		JButton bChangeFileName = new JButton("CHANGE FILE NAME");
		JButton bCancel = new JButton("CANCEL");
		
		bSetFileName.setBounds(100, 200, 95, 30);
		bChangeFileName.setBounds(210, 200, 95, 30);
		bCancel.setBounds(320, 200, 95, 30);
		
		frameTwo.getContentPane().add(bCancel);
		frameTwo.getContentPane().add(bChangeFileName);
		frameTwo.getContentPane().add(bSetFileName);
		
		frameTwo.pack();
	}
}
