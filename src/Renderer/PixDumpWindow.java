package Renderer;

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.UIManager;

import Utils.TextUtilities;

import com.jtattoo.plaf.smart.SmartLookAndFeel;


public class PixDumpWindow extends JFrame {

	public static TextUtilities u = new TextUtilities();
	
	PixDumpWindow(){
		
		try {
			Properties props = new Properties();
                        
            props.put("selectionBackgroundColor", "50 50 50"); 
            props.put("menuSelectionBackgroundColor", "10 10 10"); 
            
            
            props.put("windowInactiveTitleColorLight", "20 20 20"); 
            props.put("windowInactiveTitleColorDark", "0 0 0");
            props.put("windowInactiveBorderColor", "0 0 0");
            
            props.put("backgroundColor", "20 20 20");
            
            props.put("controlColor", "10 10 10");
            props.put("controlColorLight", "10 10 10");
            props.put("controlColorDark", "10 10 10"); 

            props.put("buttonColor", "10 10 10");
            props.put("buttonColorLight", "10 10 10");
            props.put("buttonColorDark", "10 10 10");

            props.put("rolloverColor", "50 50 50"); 
            props.put("rolloverColorLight", "50 50 50"); 
            props.put("rolloverColorDark", "10 10 10"); 
            
            props.put("frameColor", "100 100 100");
            
            props.put("windowInactiveTitleForegroundColor", "100 100 100");
            props.put("windowTitleForegroundColor", "200 200 200");
            props.put("windowTitleBackgroundColor", "200 200 200"); 
            props.put("windowTitleColorLight", "30 30 30"); 
            props.put("windowTitleColorDark", "0 0 0"); 
            props.put("windowBorderColor", "30 30 30");
            SmartLookAndFeel.setCurrentTheme(props);
			
            // select Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

    		
    		
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
