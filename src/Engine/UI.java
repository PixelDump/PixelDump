package Engine;

import java.awt.Canvas;
import java.util.ArrayList;

public class UI   {
	public Window window;
	UI(){
	
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
