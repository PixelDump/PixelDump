package Renderer;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ViewPortWindow extends JFrame {
	public Canvas game = new Canvas();
	
	public ViewPortWindow(){
		super("Pixel Dump **PRODUCTION BUILD**");
		this.setPreferredSize(new Dimension(300,300));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		this.add(game);
		this.setVisible(true);
		this.pack();
	}
	
	
}
