package Utils;

import Engine.GameObject;
import Engine.testScript;
import Renderer.Renderer;

public class GameObjectUtil  {

	//make Test GameObjects Inside of here for now

	public static void Start(){
		GameObject go2 = new GameObject("Test Object2");
		go2.AddScript(new Renderer("Flaming_skull"));
		go2.AddScript(new testScript());
		go2.transform.position.x=50;
		go2.transform.depth=1;
		GameObject go = new GameObject("Test Object");
		go.AddScript(new Renderer("art"));
		go.AddScript(new testScript());
		go.transform.depth=-1;
		
	}
	
}
