package Renderer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JLabel;

import Engine.GameObject;

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

		// keep this as -1 otherwise textCount++ ain't gonna go through
		return p;
	}
}
