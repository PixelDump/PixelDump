package Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class windowMenu extends JMenuBar{

	JMenu File = new JMenu();
	JMenu GameObjectMenu = new JMenu();
	
	
	JMenuItem Save = new JMenuItem("Save Scene",
            KeyEvent.VK_T);
	JMenuItem NewScene = new JMenuItem("New Scene",
            KeyEvent.VK_T);
	JMenuItem NewProject = new JMenuItem("New Project",
            KeyEvent.VK_T);
	JMenuItem Build = new JMenuItem("Build",
            KeyEvent.VK_T);
	
	JMenuItem NewGameObject = new JMenuItem("New Game Object",
            KeyEvent.VK_T);
	
	public windowMenu(){
		
		this.add(Box.createRigidArea(new Dimension(0,10)));
		
		File.setForeground(new Color(150,150,150));
		GameObjectMenu.setForeground(new Color(150,150,150));
		
		Save.setForeground(new Color(150,150,150));
		NewScene.setForeground(new Color(150,150,150));
		NewProject.setForeground(new Color(150,150,150));
		Build.setForeground(new Color(150,150,150));
		NewGameObject.setForeground(new Color(150,150,150));
		
		
		File.setText("File");
			Save.addActionListener(listener);
			File.add(Save);
			File.addSeparator();
			
			NewScene.addActionListener(listener);
			File.add(NewScene);
			File.addSeparator();
			
			NewProject.addActionListener(listener);
			File.add(NewProject);
			File.addSeparator();
			
			Build.addActionListener(listener);
			File.add(Build);
			File.addSeparator();
		
		GameObjectMenu.setText("Game Object");
			NewGameObject.addActionListener(listener);
			GameObjectMenu.add(NewGameObject);
			GameObjectMenu.addSeparator();

		this.add(File);
		this.add(GameObjectMenu);
	}
	
	ActionListener listener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(((JMenuItem)e.getSource()).getText()){
			case "Save Scene":
				break;
			case "New Scene":
				break;
			case "New Project":
				break;
			case "Build":
				break;
			case "New Game Object":
				break;
			}
		}};
	
}
