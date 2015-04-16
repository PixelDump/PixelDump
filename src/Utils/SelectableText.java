package Utils;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import Engine.GameObject;
import Engine.Main;

/**
 * Creates a JLabel with specific attributes
 * 
 * @author Jacob
 *
 */
public class SelectableText extends JLabel {

	Component c;
	String internalName;

	/**
	 * Creates a JLabel with specific attributes (uniquely created for
	 * displaying GameObjects)
	 * 
	 * @param name
	 *            - Name of JLabel (Same as GameObject)
	 * @param text
	 *            - Text of JLabel (Name of GameObject with indentation)
	 */
	SelectableText(String name, String text) {

		internalName = name;

		this.setText(text);
		this.setName(name);
		this.setMinimumSize(new Dimension(10, 10));
		this.setPreferredSize(new Dimension(10, 10));
		this.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));
		this.setForeground(new Color(150, 150, 150));

		this.addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent e) {
				Main.window.Hierarchy.setSelected(GameObject.Find(name));
				Main.window.UpdateInspector(GameObject.Find(name));

				Main.window.Hierarchy.setCursor("Move");
			}

			public void mouseReleased(MouseEvent e) {

				c = Main.window.store;
				Main.window.Hierarchy.setCursor("Default");

				
				//if they drag on another thing
				if (GameObject.Find(c.getName()) != null) {

					if (GameObject.Find(internalName) != GameObject.Find(c.getName())) {

						if (GameObject.Find(internalName).getParent() != null)
							GameObject.Find(internalName).getParent()
									.RemoveChild(GameObject.Find(internalName));
						
						GameObject.Find(internalName).SetParent(
								GameObject.Find(c.getName()));
						GameObject.Find(c.getName()).AddChild(
								GameObject.Find(internalName));

						Main.window.Hierarchy.Update();

					}

				}
				
				//if they drag offscreen
				else if(GameObject.Find(internalName).getParent()!=null){
					
					GameObject.Find(internalName).getParent()
						.RemoveChild(GameObject.Find(internalName));
					GameObject.Find(internalName).SetParent(null);
				}

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Main.window.store = e.getComponent();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * Changes color based on selection status.
	 * 
	 * @param b
	 *            - Whether or not the TextArea is selected
	 */
	public void setSelected(Boolean b) {
		if (b) {
			this.setBackground(new Color(60, 60, 60));
			this.setOpaque(true);
		} else {
			this.setBackground(new Color(150, 150, 150));
			this.setOpaque(false);
		}
	}

}
