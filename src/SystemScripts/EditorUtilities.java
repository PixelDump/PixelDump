package SystemScripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.lwjgl.input.Mouse;

import Engine.GameObject;
import Utils.*;

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
		if (SelectedObject != null)
			System.out.println(SelectedObject.name);
		else
			System.out.println("null");
		selection();

	}

	public boolean isGrabbing = false;

	public Vector2 offset;

	public void grab() {
		if (mouseHover.size() != 0) {
			if (Input.getMouse(0)) {
				if (!isGrabbing) {
					isGrabbing = true;
					SelectedObject = mouseHover.get(0);
					offset = new Vector2(SelectedObject.transform.position.x
							- Input.getMousePosition().x,
							SelectedObject.transform.position.y
									- Input.getMousePosition().y);
				}
				if(SelectedObject!=null){
				SelectedObject.transform.position.x = Input.getMousePosition().x
						+ offset.x;
				SelectedObject.transform.position.y = Input.getMousePosition().y
						+ offset.y;
				}

			}
		}
		if (Input.getMouseUp(0)) {
			isGrabbing = false;

		}

	}

	void selection() {
		if (Input.getMouseDown(0)) {
			if (mouseHover.size() == 0) {
				SelectedObject = null;
			} else {
				SelectedObject = mouseHover.get(0);
			}

		}
		grab();
	}
}
