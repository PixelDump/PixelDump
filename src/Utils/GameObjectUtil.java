package Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

import Engine.GameObject;
import Engine.testScript;
import Renderer.Renderer;

public class GameObjectUtil {
	// make Test GameObjects Inside of here for now
/**
 * Will be used to create serialized gameobjects
 */
	public static void Start() {
		
		
		GameObject go2 = new GameObject("Flaming_skull");
		go2.AddScript(new Renderer("Flaming_skull"));
		//go2.AddScript(ScriptCompiler.getPlayerScript("test"));
		go2.transform.position.x = 50;
		go2.transform.depth = 1;
		GameObject go = new GameObject("jacob");
		go.AddScript(new Renderer("jacob"));
		go.transform.depth = -1;
	
	}


}
