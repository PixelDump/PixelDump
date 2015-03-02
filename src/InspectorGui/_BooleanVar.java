package InspectorGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

import Utils.Component;
import Utils.TextDefaults;

public class _BooleanVar extends GenericVariable{

	public JRadioButton radioButton = new JRadioButton();
	
	public _BooleanVar(String n, Component c){
		name = n;
		
		compDupe = c;

		this.add(TextDefaults.MakeText(name+": "));
		radioButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					(compDupe.getClass().getField(name)).set(compDupe, 
							radioButton.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException
						| NoSuchFieldException | SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		
		this.add(radioButton);
	}
	
		
	
	
}
