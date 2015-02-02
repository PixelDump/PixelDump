package Renderer;

import java.awt.Canvas;
import java.util.ArrayList;

import Engine.GameObject;

public class UI   {
	public Window window;
	public UI(){
	
		GameObject x = new GameObject();
		x.setName("Object1");
			GameObject y = new GameObject();
			y.setName("Object2");
		
		x.addChild(y);
		
		ArrayList<GameObject> sub = new ArrayList<GameObject>(){{add(x);}};
		
		PixDumpWindow p = new PixDumpWindow();
		window  = new Window(sub);
		
	}
	
	
	
}
