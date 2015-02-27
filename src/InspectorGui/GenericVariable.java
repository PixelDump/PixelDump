package InspectorGui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

	

public class GenericVariable extends JPanel{
	
	public String name;
	public JTextArea text = new JTextArea();
	public JTextArea x = new JTextArea();
	public JTextArea y = new JTextArea();
	public JRadioButton radioButton = new JRadioButton();
	
	GenericVariable(){
		
		this.removeAll();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
	
		text.setPreferredSize(new Dimension(50,17));
		text.setMaximumSize(new Dimension(100,17));
		x.setPreferredSize(new Dimension(30,17));
		x.setMaximumSize(new Dimension(50,17));
		y.setPreferredSize(new Dimension(30,17));
		y.setMaximumSize(new Dimension(50,17));
	}
	
	public String getName(){
		return name;
	}
	
}
