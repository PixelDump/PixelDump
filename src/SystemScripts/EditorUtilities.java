package SystemScripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.input.Keyboard;

import Engine.GameObject;
import Engine.Main;
import Renderer.Renderer;
import Utils.DepthComparator;
import Utils.ScriptBase;
import Utils.Vector2;

public class EditorUtilities extends ScriptBase {

	protected EditorUtilities() {
		super("EditorUtilities");
		// TODO Auto-generated constructor stub
	}

	public static GameObject SelectedObject;

	public static List<GameObject> mouseHover = new ArrayList<GameObject>();

	public void Start() {

	}

	public void Update() {
	
		Collections.sort(mouseHover, new DepthComparator());
		// for(GameObject go:mouseHover)
		if (SelectedObject != null){
		
			//if(Input.getMouseDown(1)){
				//System.out.println(SelectedObject.name());
				//((Renderer)SelectedObject.GetComponent("Renderer")).pixelScale--;
			//}
			}
		/*else
			System.out.println("null");*/
		
		
		selection();

	}

	public boolean isGrabbing = false;

	public Vector2 offset;

	

	void selection() {
		if (Input.getMouseDown(0)) {
			if (mouseHover.size() == 0) {
				setSelected( null);
			} else {
				setSelected( mouseHover.get(0));
				
			}

		}
		grab();
	}
	
	public void grab() {
		if (Input.getMouseUp(0)) {
			isGrabbing = false;
			offset= new Vector2();
		}
		if (mouseHover.size() >0) {
			if (Input.getMouse(0)) {
				if (!isGrabbing) {
					isGrabbing = true;
					setSelected( mouseHover.get(0));
					offset = new Vector2(Math.abs(SelectedObject.transform.position.x
							- Input.getMousePosition().x),
							Math.abs(SelectedObject.transform.position.y
									- Input.getMousePosition().y));
				}
				if(SelectedObject!=null){
				SelectedObject.transform.position.x = Input.getMousePosition().x
						- offset.x;
				SelectedObject.transform.position.y = Input.getMousePosition().y
						- offset.y;
				}

			}
		}
		

	}
	
	public static void setSelected(GameObject go){
		SelectedObject = go;
		if(SelectedObject!=null){
		Main.window.setSelected(go.name());
		}
		Main.window.UpdateInspector(go);

	}
}
