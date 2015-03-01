package Utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Engine.Main;
import SystemScripts.EditorUtilities;

public class removeButton extends JButton{

	public removeButton(String name){
		this.setText("remove");
		this.setName(name);
		this.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		this.setForeground(new Color(100,100,100));
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				EditorUtilities.SelectedObject.removeScript(name);
				Main.ui.window.UpdateInspector(EditorUtilities.SelectedObject);
			}});
		
	}
	
}
