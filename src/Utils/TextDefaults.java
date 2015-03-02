package Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.PlainDocument;

public class TextDefaults extends JFormattedTextField{

	
	public Boolean isFocused= false;
	
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
	    
	    this.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				isFocused = true;
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				isFocused = false;
				
			}});
	    
	    
	   
	}
	
	
	public Boolean isFocused(){
		return isFocused;
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
