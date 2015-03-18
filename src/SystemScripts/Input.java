package SystemScripts;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import Utils.ScriptBase;
import Utils.Vector2;

/**Shortcuts for input codes (to be used in player scripts)
 * 
 * @author Barry
 *
 */
public class Input extends ScriptBase{

	public Input() {
		super("Input");
		// TODO Auto-generated constructor stub
	}

	public static boolean getMouseDown(int button){
		return(Mouse.next()&&Mouse.getEventButton() == button &&Mouse.getEventButtonState());		
		       
	}
	public static boolean getMouseUp(int button){
		return(Mouse.next()&&Mouse.getEventButton()==button&&!Mouse.getEventButtonState());		
		       
	}
	public static boolean getMouse(int button){
		return(Mouse.isButtonDown(button));		
		       
	}
	
	public static Vector2 getMousePosition(){
		
		return new Vector2(Mouse.getX(),Mouse.getY());
		
	}
	public static Vector2 getMouseDelta(){
		
		return new Vector2(Mouse.getDX(),Mouse.getDY());
		
	}
	public static boolean getKey(int key){
		return Keyboard.isKeyDown(key);
		
	}
	public static boolean getKeyDown(int key){
		return (Keyboard.next()&&Keyboard.getEventKey() == key&&Keyboard.getEventKeyState());	
	}
	public static boolean getKeyUp(int key){
		
		return (Keyboard.next()&&Keyboard.getEventKey() == key&&!Keyboard.getEventKeyState());	
	}
	public  void Update(){
	
	}
	
}
