package InspectorGui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

	
/*Questions:
 * How do I make resources (in the _Scripts place)?
 * 
 * Things to do:
 * Make selection of object in hierarchy update inspectorPanel.
 * 
 * 
 * */
	
	public static GridBagConstraints cons = new GridBagConstraints();
	public InspectorPanel(GameObject go){	
		this.removeAll();
	
		this.setLayout(new GridBagLayout());
		
		cons.fill = GridBagConstraints.HORIZONTAL;
		cons.weightx = 1;
		cons.gridx = 0;
		
		this.add(UI.MakeText(go.name()), cons);
		
		ArrayList<Component> components = go.GetAllComponents();
		for(int x = 0; x<components.size(); x++){
			
			this.add(new ComponentGui(components.get(x)), cons);
			
		}
	}
	
	
	public JPanel Component(String type, String name, Object o){
		
		p = new JPanel();
		
		p.add(UI.MakeText(name+": "));
		t.setText("Variable Value");
		t.setPreferredSize(new Dimension (100, 20));
		t.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Do Shit
				System.out.println("text area activated");
	        }
		});
		r.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Do Shit
				System.out.println("radio button activated");
			}
		});	
		
		
		
	
	return p;	
	
	}
}