package InspectorGui;

import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Engine.GameObject;
import Renderer.UI;
import Utils.Component;
import Utils.ScriptCompiler;

public class InspectorPanel extends JPanel{

	JTextField t = new JTextField();
	JRadioButton r = new JRadioButton();
	JPanel p = new JPanel();
	JComboBox b;

	
	public InspectorPanel(GameObject go){	
		this.removeAll();
	
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(UI.MakeText("Inspector:"));
		this.add(UI.MakeText(go.name()), LEFT_ALIGNMENT);
		
		ArrayList<Component> components = go.GetAllComponents();
		for(int x = 0; x<components.size(); x++){
			
			this.add(new ComponentGui(components.get(x)));
			
		}
		
		//for(int x = 0; )
		
		//b = new JComboBox(ScriptCompiler.PlayerScripts);
		this.add(b);
	}

}