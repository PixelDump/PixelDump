package SystemScripts;

import org.lwjgl.input.Keyboard;

import Engine.GameObject;
import Engine.Main;
import Utils.PScript;
import Utils.ScriptBase;

/**Used to delete GameObjects when they're selected
 * 
 * @author Jacob
 *
 */
public class CheckDelete extends ScriptBase{
	
	public CheckDelete(){
		super("CheckDelete");
	}

	//only first keydown works, updating from here bugs out

	public void Update(){
		 
		if(Input.getKeyDown(Keyboard.KEY_DELETE)&&EditorUtilities.SelectedObject!=null){
			
			GameObject g = EditorUtilities.SelectedObject;
			GameObject.Destroy(g);
			
			Main.window.Hierarchy.setSelected(null);
			Main.window.Inspector.Update(null);
			
			
			Main.window.Hierarchy.Update();
			Main.window.Hierarchy.revalidate();
			Main.window.Hierarchy.repaint();
			
		}

		
	}
}
