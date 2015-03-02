package Utils;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class TextDefaults {

	public static JLabel IntText(String text){
		return null;
	}
	
	public static JLabel DoubleText(String text){
		return null;
	}
	
	public static JLabel MakeText(String text) {

		JLabel p = new JLabel();
		p.setText(text);
		p.setMinimumSize(new Dimension(10, 10));
		p.setPreferredSize(new Dimension(10, 10));
		p.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));
		p.setForeground(new Color(150, 150, 150));
		p.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
		return p;
	}
	
}
