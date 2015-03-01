package InspectorGui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Engine.GameObject;
import Engine.Main;
import Renderer.UI;
import SystemScripts.EditorUtilities;
import Utils.Component;
import Utils.ComponentCombo;
import Utils.ScriptCompiler;

public class InspectorPanel extends JPanel{

	JTextField t = new JTextField();
	JRadioButton r = new JRadioButton();
	JPanel p = new JPanel();
	JButton b = new JButton();
	ComponentCombo c = new ComponentCombo();
	
	public InspectorPanel(GameObject go){	
		this.removeAll();
	
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(UI.MakeText("Inspector:"), LEFT_ALIGNMENT);
		this.add(UI.MakeText(go.name()), LEFT_ALIGNMENT);
		
		ArrayList<Component> components = go.GetAllComponents();
		for(int x = 0; x<components.size(); x++){
			
			this.add(new ComponentGui(components.get(x)));
			
		}
		
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				go.AddScript(ScriptCompiler.getPlayerScript(String.valueOf(c.getSelectedItem())));
				Main.ui.window.UpdateInspector(EditorUtilities.SelectedObject);
			}});
		b.setForeground(new Color(100,100,100));
		b.setText("Add Component");
		c.setMaximumSize(new Dimension(100,20));
		this.add(c);
		this.add(b);
		
	}

}