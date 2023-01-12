package UserInterface;

import java.awt.Scrollbar;

//BY DEFAULT COMPONENTS HAS SIZE (0, 0)

/*
 * FIRST WINDOW: ALL FILE VIEW, CRUD FILE
 * WHILE CLICKING CRUD BUTTON DISPLAYING ANOTHER WINDOW
 * POSSIBILITY TO ADD A FILE OR A FOLDER
 * 
 * CRUD
 * CREATE
 * POSSIBILITY TO WRITE IN A FILE AS SOON AS IT IS CREATED
 * READ
 * THEN DISPLAYING IT ON JTEXTPANE WITH NO GETTING OUT OF BOUNDARIES IF THE TEXT IS TOO LONG
 * UPDATE/WRITE
 * IF POSSIBLE: WRITING IN A TEXTFIELD THEN COPYING THAT TO A FILE (USING SCANNER?)
 * DELETE
 * OPERATION ON VIRTUAL MACHINE - IMPLEMENT IT AS THE LAST
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import FileCollectionKuba.*;

public class ProgramFrame {
	
	private static void initComponents() {
		JFrame frame = new JFrame("File Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setLayout(null);
		
		
		//ERROR WHILE ADDING THE SECOND FRAME TO A FRAME
		/*
		JFrame frameChildOne = new JFrame("Smaller window.");
		frameChildOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameChildOne.setSize(600, 600);
		frameChildOne.setLayout(null);
		frame.getContentPane().add(frameChildOne);
		frameChildOne.setVisible(true);
		*/
		
		
		//IDEA OF A PANEL AS A POP-UP WINDOW
		/*
		JPanel panel = new JPanel();
		panel.setSize(400, 400);
		panel.setLayout(null);
		panel.setVisible(true);
		frame.getContentPane().add(panel);
		
		JButton buttonTest = new JButton("TEST BUTTON");
		panel.add(buttonTest);
		buttonTest.setSize(50, 50);
		*/
		
		JLabel label = new JLabel("File Editor");
		frame.getContentPane().add(label);
		
		//jtextcomponent getSelectedText() also getText()
		JTextField textField = new JTextField();
		textField.setBounds(100, 100, 400, 30);
		
frame.getContentPane().add(textField);
		
		JButton bWrite = new JButton("WRITE");
		JButton bRead = new JButton("READ");
		JButton bDelete = new JButton("DELETE");
		JButton bNewFile = new JButton("NEW FILE");
		
		bWrite.setBounds(100, 200, 95, 30);
		bRead.setBounds(210, 200, 95, 30);
		bDelete.setBounds(320, 200, 95, 30);
		bNewFile.setBounds(430, 200, 95, 30);
		
		frame.getContentPane().add(bDelete);
		frame.getContentPane().add(bRead);
		frame.getContentPane().add(bWrite);
		frame.getContentPane().add(bNewFile);
		
		//ADDING JTEXTFIELD WITH A SCROLLBAR TO SHOW FILES
		final JTextField textFieldFiles = new JTextField();
		JScrollBar scrollBar = new JScrollBar(Scrollbar.VERTICAL);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		BoundedRangeModel brm = textFieldFiles.getHorizontalVisibility();
		scrollBar.setModel(brm);
		panel.add(textFieldFiles);
		panel.add(scrollBar);
		//final TextSlider ts = new TextSlider(); IDK WHAT IS IT - FROM INTERNET
		textFieldFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("YOUR FILES: " + textFieldFiles.getText());
			}
		});
		
		frame.pack();
		frame.setVisible(true);
		
		//GOOD IDEA TO OVERWRITE METHODS AFTER VARIABLES DECLARATIONS 
		//BEACUSE THEY CANT BE REACHED
		
		textField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}
			public void changed() {
				if(textField.getText().equals("")) {
					bNewFile.setEnabled(false);
				}else {
					bNewFile.setEnabled(true);
				}
			}	
		});
		
		
		//TODO: implement actionlisteners to buttons
		bNewFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * IN ORDER TO CHECK A CHAMGE IN A JTEXTFIELD
				 * I HAVE TO ADD A DOCUMENTLISTENER WHICH REACTS
				 * FOR CHANGE IN THE TEXT
				 */
				//BUTTON ORIGINALLY DISABLED IF TEXTFIELD IS BLANK (SEE CHANGED() METHOD)
				
				String fileName = textField.getText();
				StringBuilder sbFileName = new StringBuilder(fileName);
				sbFileName.append(".java");
				File newFile = new File(sbFileName.toString());
				FilesEditor.putFileToList(newFile);
			}
		});
		
		//READ, WRITE, DELETE THERE SHOULD OPTION TO CHOOSE WHICH FROM THE MAP
		//FIRST CHOOSE A FILE THEN DO THESE ACTIONS, BUTTON BENEATH 
		//SHOULD BE DISABLED
		bRead.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bWrite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		bDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run() {
				initComponents();
			}
		});
	}
}
