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

	public static void Start() {
		//ScriptCompiler.loadScript("test");
		
		GameObject go2 = new GameObject("Flaming_skull");
		go2.AddScript(new Renderer("Flaming_skull"));
		//go2.AddScript(ScriptCompiler.getPlayerScript("test"));
		go2.transform.position.x = 50;
		go2.transform.depth = 1;
		GameObject go = new GameObject("jacob");
		go.AddScript(new Renderer("jacob"));
		go.AddScript(new testScript());
		go.transform.depth = -1;
		System.out.println(GameObjectCreator.getFieldType("Engine",
				"testScript",0));
		
	}
	public static void recompile(GameObject go2){

	ScriptCompiler.loadScript("test");

	}
	public static class GeneralGameObjectUtils {

	}

	public static class GameObjectCreator {

		public static void loadScene(File scene) {

		}

		public static ScriptBase newScriptByName(String name) {
			try {
				return (ScriptBase) (Class.forName(name).getConstructor()
						.newInstance());
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static ScriptBase newScriptByName(String pack, String name) {
			try {
				return (ScriptBase) (Class.forName(pack + "." + name)
						.getConstructor().newInstance());
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static Object getObjectByName(String pack, String name) {
			try {
				return (Class.forName(pack + "." + name).getConstructor()
						.newInstance());
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		public static String getFieldType(String pack, String name, int index) {
			try {
				return Class.forName(pack + "." + name).getFields()[index]
						.getType().getName();

			} catch (IllegalArgumentException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		ObjectOutputStream oos = null;
		FileOutputStream fout = null;

		public void serializeGameObject(GameObject go) {

			try {
				FileOutputStream fout = new FileOutputStream("src/res/test.GO",
						true);
				ObjectOutputStream oos = new ObjectOutputStream(fout);
				oos.writeObject(go);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (oos != null) {
					try {
						oos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
