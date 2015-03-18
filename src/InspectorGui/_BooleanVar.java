package InspectorGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JRadioButton;

import Utils.Component;
import Utils.TextDefaults;

/**Inspector Variable gui for type Boolean
 * 
 * @author Jacob
 *
 */
public class _BooleanVar extends GenericVariable{

	public JRadioButton radioButton = new JRadioButton();
	
	/**Creates a new GenericVariable displaying a JRadioButton tied to the passed in Boolean 
	 * 
	 * @param field - Boolean to monitor
	 * @param c - Component that the field belongs to
	 */
	public _BooleanVar(Field field, Component c){
		f= field;
		name = f.getName();
		compDupe = c;

		this.add(TextDefaults.MakeText(name+": "));
		radioButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					f.set(compDupe, radioButton.isSelected());
				} catch (IllegalArgumentException | IllegalAccessException
						| SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		
		this.add(radioButton);
	}
	
		
	
	
}
