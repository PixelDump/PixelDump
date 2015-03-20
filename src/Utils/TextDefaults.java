package Utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.PlainDocument;

import Engine.Main;

/**Creates a JFormattedTextField to facilitate types of data entry
 * 
 * @author Jacob
 *
 */
public class TextDefaults extends JFormattedTextField{

	
	public Boolean isFocused= false;
	public Boolean enter = false;
	
	/**Creates a JFormattedTextField to facilitate types of data entry
	 * 
	 * @param type - Type of object
	 */
	public TextDefaults(String type){
		
		PlainDocument doc = new PlainDocument();
	    
	    switch(type){
	    	case "int":
	    		doc.setDocumentFilter(new IntFilter());
	    		 this.setDocument(doc);
	    		break;
	    		
	    	case "class java.lang.String":
	    		break;
	    		
	    	case "double":
	    		doc.setDocumentFilter(new DoubleFilter());
	    	    this.setDocument(doc);
	    		break;
	    		
	    	case "Double":
	    		doc.setDocumentFilter(new DoubleFilter());
	    	    this.setDocument(doc);
	    		break;
	    		
	    	case "float":
	    		doc.setDocumentFilter(new DoubleFilter());
	    		this.setDocument(doc);
	    		break;
	    		
	    	default:
	    		System.out.println("Invalid TextDefault type: "+ type);
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
	    
	    this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.window.InspeIarchy.requestFocusInWindow();
				enter = true;
			}});
	    
	    
	   
	}
	
	/**Returns whether or not the text is focused
	 */
	public Boolean isFocused(){
		return isFocused;
	}
	
	/**Returns a JLabel containing string text
	 */
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
