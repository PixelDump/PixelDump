package Utils;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Engine.Main;
import SystemScripts.EditorUtilities;

/**Creates a specially tailored button for removing Components
 * 
 * @author Jacob
 *
 */
public class removeButton extends JButton{

	/**Creates a specially tailored button for removing Components
	 */
	public removeButton(Component c){
		
		if(c.name.equals("Transform")){
			this.setVisible(false);
		}
		
		this.setText("remove");
		this.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
		this.setForeground(new Color(100,100,100));
		this.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					EditorUtilities.SelectedObject.removeScript((PScript)c);
					Main.window.UpdateInspector(EditorUtilities.SelectedObject);
				
			}});
		
		
	}
	
}
