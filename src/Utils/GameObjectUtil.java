package Utils;

import Engine.GameObject;
import Engine.testScript;
import Renderer.Renderer;

public class GameObjectUtil  {

	//make TestGameObjectsInside of here for now

	public static void Start(){

		GameObject go = new GameObject("Test Object");
		go.AddScript(new Renderer("art"));
		go.AddScript(new testScript());
	}
	
}
