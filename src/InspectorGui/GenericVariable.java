package InspectorGui;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

	

public class GenericVariable extends JPanel{
	
	public String name;
	public JTextArea text = new JTextArea();
	public JTextArea text2 = new JTextArea();
	public JRadioButton radioButton = new JRadioButton();
	public static GridBagConstraints cons = new GridBagConstraints();
	GenericVariable(){
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1;
		cons.gridx = 0;
		this.removeAll();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	public String getName(){
		return name;
	}
	
}
