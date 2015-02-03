package SystemScripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Engine.GameObject;
import Utils.*;

public class EditorUtilities extends ScriptBase {

	protected EditorUtilities() {
		super("EditorUtilities");
		// TODO Auto-generated constructor stub
	}

	public static List<GameObject> mouseHover = new ArrayList<GameObject>();

	public void Start() {

	}

	public void Update() {
		Collections.sort(mouseHover,new DepthComparator());
		
	grab();
		
	}

	public void grab(){
	
	}
}










