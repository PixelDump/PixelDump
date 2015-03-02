package InspectorGui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import Utils.TextDefaults;

	

public class GenericVariable extends JPanel{
	
	public String name;
	public TextDefaults stringText = new TextDefaults("String");
	public TextDefaults integerText = new TextDefaults("Integer");
	public TextDefaults doubleText = new TextDefaults("Double");
	public TextDefaults x = new TextDefaults("Double");
	public TextDefaults y = new TextDefaults("Double");
	public JRadioButton radioButton = new JRadioButton();
	
	GenericVariable(){
		
		this.removeAll();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		
	
		stringText.setPreferredSize(new Dimension(50,17));
		stringText.setMaximumSize(new Dimension(100,17));
		integerText.setPreferredSize(new Dimension(50,17));
		integerText.setMaximumSize(new Dimension(100,17));
		doubleText.setPreferredSize(new Dimension(50,17));
		doubleText.setMaximumSize(new Dimension(100,17));
		x.setPreferredSize(new Dimension(30,17));
		x.setMaximumSize(new Dimension(50,17));
		y.setPreferredSize(new Dimension(30,17));
		y.setMaximumSize(new Dimension(50,17));
	}
	
	public String getName(){
		return name;
	}
	
}
