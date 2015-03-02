package Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.NumberFormatter;
import javax.swing.text.PlainDocument;

public class TextDefaults extends JFormattedTextField{

	
	
	public TextDefaults(String type){
		
		PlainDocument doc = new PlainDocument();
	    
	    switch(type){
	    	case "Integer":
	    		doc.setDocumentFilter(new IntFilter());
	    		 this.setDocument(doc);
	    		break;
	    		
	    	case "String":
	    		break;
	    		
	    	case "Double":
	    		doc.setDocumentFilter(new DoubleFilter());
	    	    this.setDocument(doc);
	    		break;
	    		
	    	default:
	    		System.out.println("Invalid TextDefault type");
	    }
	    
	    
	    
	    
	   
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
