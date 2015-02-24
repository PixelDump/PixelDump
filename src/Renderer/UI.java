package Renderer;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class UI   {
	public Window window;
	public UI(){
		
				
		PixDumpWindow p = new PixDumpWindow();
		window  = new Window();
		
	
	}
	
	public void init(){
		
		
	}
	
	public static JLabel MakeText(String text) {

		JLabel p = new JLabel();

		p.setText(text);
		p.setMinimumSize(new Dimension(10, 10));
		p.setPreferredSize(new Dimension(10, 10));
		p.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));
		p.setForeground(new Color(150, 150, 150));

		return p;
	}
	
}
