package Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import Engine.GameObject;
import Engine.Main;
import SystemScripts.EditorUtilities;

public class SelectableText extends JLabel{
	

	SelectableText(String name, String text) {

		this.setText(text);
		this.setName(name);
		this.setMinimumSize(new Dimension(10, 10));
		this.setPreferredSize(new Dimension(10, 10));
		this.setMaximumSize(
				new Dimension(Short.MAX_VALUE, 20));
		this.setForeground(new Color(150, 150, 150));

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Main.window.Hierarchy.setSelected(GameObject.Find(name));
				Main.window.UpdateInspector(GameObject.Find(name));
				
			}

		});
		
	}
	
	
	/**Changes color based on selection status.
	 * 
	 * @param b - Whether or not the TextArea is selected
	 */
	public void setSelected(Boolean b){
		if(b){
			this.setBackground(new Color(60, 60, 60));
			this.setOpaque(true);
		}
		else{
			this.setBackground(new Color(150, 150, 150));
			this.setOpaque(false);
		}
	}
	
	
}
