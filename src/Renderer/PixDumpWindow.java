package Renderer;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Engine.TextUtilities;

import com.jtattoo.plaf.smart.SmartLookAndFeel;


public class PixDumpWindow extends JFrame {

	
	public static TextUtilities u = new TextUtilities();
	
	

	PixDumpWindow(){
		try {
			
			Properties props = new Properties();
                        
            props.put("selectionBackgroundColor", "0 0 0"); 
            props.put("menuSelectionBackgroundColor", "10 10 10"); 
            
            props.put("backgroundColor", "50 50 50");
            
            props.put("controlColor", "10 10 10");
            props.put("controlColorLight", "10 10 10");
            props.put("controlColorDark", "10 10 10"); 

            props.put("buttonColor", "10 10 10");
            props.put("buttonColorLight", "10 10 10");
            props.put("buttonColorDark", "10 10 10");

            props.put("rolloverColor", "10 10 10"); 
            props.put("rolloverColorLight", "10 10 10"); 
            props.put("rolloverColorDark", "10 10 10"); 

            props.put("windowTitleForegroundColor", "10 10 10");
            props.put("windowTitleBackgroundColor", "10 10 10"); 
            props.put("windowTitleColorLight", "70 70 70"); 
            props.put("windowTitleColorDark", "0 0 0"); 
            props.put("windowBorderColor", "127 127 127");
            SmartLookAndFeel.setCurrentTheme(props);
			
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

    		
    		
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
