package Utils;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class windowMenu extends JMenuBar{

	JMenu File = new JMenu();
	JMenu GameObjectMenu = new JMenu();
	JMenuItem menuItem = new JMenuItem("Save",
            KeyEvent.VK_T);
	
	public windowMenu(){
		
		this.add(Box.createRigidArea(new Dimension(0,10)));
		
		File.setText("File");
		File.add(menuItem);
		File.addSeparator();
		
		GameObjectMenu.setText("Game Object");

		this.add(File);
		this.add(GameObjectMenu);
	}
	
}
