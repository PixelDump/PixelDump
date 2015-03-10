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

/**Uses JTattoo to set a customized GUI.
 * 
 * @author Jacob
 *
 */
public class PixDumpWindow extends JFrame {

	public static TextUtilities u = new TextUtilities();
	
	/**Uses JTattoo to set a customized GUI.
	 * 
	 */
	public PixDumpWindow(){
		
		try {
			Properties props = new Properties();
                        
            props.put("selectionBackgroundColor", "50 50 50"); 
            props.put("selectionForegroundColor", "100 100 100");
            
            props.put("menuSelectionBackgroundColor", "30 30 30"); 
            props.put("menuSelectionForegroundColor", "150 150 150");
            props.put("menuBackgroundColor", "10 10 10"); 
            
            props.put("windowInactiveTitleColorLight", "20 20 20"); 
            props.put("windowInactiveTitleColorDark", "0 0 0");
            props.put("windowInactiveBorderColor", "0 0 0");
            
            props.put("backgroundColor", "20 20 20");
            props.put("foregroundColor", "100 100 100");
            
            props.put("controlColor", "10 10 10");
            props.put("controlColorLight", "10 10 10");
            props.put("controlColorDark", "10 10 10"); 

            props.put("buttonColor", "10 10 10");
            props.put("buttonColorLight", "10 10 10");
            props.put("buttonColorDark", "10 10 10");
            
            props.put("toolbarBackgroundColor", "10 10 10");
            props.put("toolbarBackgroundColor", "150 150 150");

            props.put("rolloverColor", "50 50 50"); 
            props.put("rolloverColorLight", "50 50 50"); 
            props.put("rolloverColorDark", "10 10 10");
            
            props.put("focusColor", "40 40 40"); 
            
            props.put("frameColor", "100 100 100");
            
            props.put("menuColorLight", "30 30 30");
            props.put("menuColorDark", "10 10 10");
            
            props.put("inputForegroundColor", "150 150 150");
            props.put("inputBackgroundColor", "40 40 40");
            
            props.put("logoString", "");
            
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
