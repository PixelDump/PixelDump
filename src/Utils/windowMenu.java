package Utils;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class windowMenu extends JMenuBar{

	JMenu File = new JMenu();
	JMenu GameObject = new JMenu();
	
	public windowMenu(){
		
		//File.add
		
		//File.addSeparator();

		this.add(File);
		this.add(GameObject);
	}
	
}
