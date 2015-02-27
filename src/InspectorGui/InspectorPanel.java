package InspectorGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Engine.GameObject;
import Renderer.UI;
import Utils.Component;

public class InspectorPanel extends JPanel{

	JTextField t = new JTextField();
	JRadioButton r = new JRadioButton();
	JPanel p = new JPanel();

	
	public InspectorPanel(GameObject go){	
		this.removeAll();
	
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(UI.MakeText(go.name()), LEFT_ALIGNMENT);
		
		ArrayList<Component> components = go.GetAllComponents();
		for(int x = 0; x<components.size(); x++){
			
			this.add(new ComponentGui(components.get(x)));
			
		}
	}

}