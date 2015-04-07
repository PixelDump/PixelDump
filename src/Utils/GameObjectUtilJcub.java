package Utils;

import _Scripts.ExampleCode;
import Engine.GameObject;
import Engine.testScript;
import Renderer.Renderer;

/**Temporary GameObject creation area for testing
 * 
 * @author Jacob
 *
 */
public class GameObjectUtilJcub  {



	public static GameObject a1;
	
	public static  void Start(){
		
		a1 = new GameObject("Parent 1");
		
		GameObject b1 = new GameObject("Child 1");
		GameObject c1 = new GameObject("SubChild 1");
		GameObject b2 = new GameObject("Child 2");
		
		GameObject x1 = new GameObject("Parent A");
		GameObject y1 = new GameObject("Child A");
		GameObject y2 = new GameObject("Child B");
		GameObject z1 = new GameObject("SubChild A");
		
		
		
		a1.AddChild(b1);
		a1.AddChild(b2);
		b1.AddChild(c1);
		
		x1.AddChild(y1);
		x1.AddChild(y2);
		y2.AddChild(z1);
		
		
	}
	
	public static void Update(){
	}
	
}
