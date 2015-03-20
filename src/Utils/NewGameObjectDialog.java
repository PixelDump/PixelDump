package Utils;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Engine.GameObject;
import Engine.Main;
 
/**
 * Creates a dialog that is used to construct a new GameObject.
 * @author barry
 *
 */
public class NewGameObjectDialog extends JFrame{

	JTextField goName = new JTextField(){{this.setMaximumSize(new Dimension(300, 20));this.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);}};
	JButton submit= new JButton("Create"){{this.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);this.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
		
			GameObject g = new GameObject(goName.getText());
			
			Main.window.UpdateHierarchy();
		}});}};
	public NewGameObjectDialog(){
		this.setVisible(true);
		this.setPreferredSize(new Dimension(400,200));
		this.pack();
		this.setResizable(false);
		this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		this.add(new JLabel("Create a New GameObject"){{this.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);}});
		this.add(new JLabel(" "));

	
		this.add(goName);
		this.add(new JLabel(" "));
		this.add(new JLabel(" "));
		
		this.add(submit);
	}
	
}
