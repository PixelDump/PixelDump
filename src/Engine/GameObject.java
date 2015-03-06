package Engine;

import java.util.ArrayList;
import java.util.List;

import Utils.Component;
import Utils.GenericObject;
import Utils.PScript;
import Utils.ScriptBase;
import Utils.Transform;
import Utils.Vector2;

public class GameObject extends GenericObject{

	public Transform transform = new Transform(new Vector2());
	private String name = "";

	private ArrayList<GameObject> Children = new ArrayList<GameObject>();
	private GameObject Parent;
	
	
	private static ArrayList<GameObject> SceneObjects = new ArrayList<GameObject>();

	//BARRY I ADDED THIS IN
	public ArrayList<Component> GetAllComponents(){
		return Components;
	}
	
	public void SetChildren(ArrayList<GameObject> children){
		this.Children=children;
		Main.window.UpdateHierarchy();
	}
	public void AddChild(GameObject child){
		this.Children.add(child);
		child.SetParent(this);
		try{
			Main.window.UpdateHierarchy();
			}
			catch(Exception e){}
	}
	public void SetParent(GameObject Parent){
		this.Parent=Parent;
	}
	public GameObject getParent(){
		return this.Parent;
	}
	
	public Component GetComponent(String name) {

		Component result = null;
		int i = 0;
		while (true) {

			if (name.equals(Components.get(i).name)) {
				result = Components.get(i);
				break;
			} else if (i <= Components.size()) {
				return null;
			}
			i++;
		}
		return result;

	}
public  void removeScript(String name){
	int i = 0;
	
	for (Component c : Components) {
		
		if (name.equals(c.name)) {
			 Components.remove(c);
		if(c.getClass().getTypeName().startsWith("_Scripts"))
			 ((PScript)c).UnLink();
		else
			((ScriptBase)c).UnLink();
			 System.out.println("removed");
			break;
		} 
	//	System.out.println(	c.name);
		 
		i++;
	}
}

public  void removeScript(PScript x){
	int i = 0;
	
	if(Components.contains(x)){
		 Components.remove(x);
		 ((PScript)x).UnLink();
		 System.out.println("removed");
	} 
	
	
}
public  void removeScript(ScriptBase x){
	int i = 0;
	
	if(Components.contains(x)){
		 Components.remove(x);
		 ((ScriptBase)x).UnLink();
		 System.out.println("removed");
	} 
	
	
}
	@Override
	public void AddScript(ScriptBase script) {
		
		script.setParent(this);
		Components.add(script);
	}

	public void AddScript(PScript script) {
		
		script.setParent(this);
		Components.add(script);
	}
	public GameObject GetChild(String name) {
		GameObject result;
		int i = 0;
		while (true) {

			if (name.equals(Children.get(i).name)) {
				result = Children.get(i);
				break;
			} else if (i <= Children.size()) {
				return null;
			}
			i++;
		}

		return result;
	}
	
	public List<GameObject> GetChildren() {
		
		return Children;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String name() {
		return name;
	}

	public static void Destroy(GameObject go) {

		SceneObjects.remove(go);

	}

	public static GameObject Find(String search) {
		GameObject result;
		while (true) {
			int i = 0;
			if (search.equals(SceneObjects.get(i).name)) {
				result = SceneObjects.get(i);
				break;
			} else if (i <= SceneObjects.size()) {
				return null;
			}
			i++;
		}

		return result;
	}

	public static GameObject AddGameObject(GameObject go) {

		SceneObjects.add(go);
		
		return go;
	}

	public static ArrayList<GameObject> getAllGameObjects(){
		return SceneObjects;
		
	}
	
	public GameObject() {

		Components.add(transform);
		name = "GameObject";
		SceneObjects.add(this);
		Main.window.UpdateHierarchy();
	}

	public GameObject(String name) {
		Components.add(transform);
		this.name = name;
		SceneObjects.add(this);
		
		try{
		Main.window.UpdateHierarchy();
		}
		catch(Exception e){}
	}

	GameObject(String name, ArrayList<ScriptBase> scripts,
			ArrayList<Component> components) {
		Components.add(transform);
		for (int i = 0; i < scripts.size(); i++) {
			AddScript(scripts.get(i));
		}

		for (int i = 0; i < components.size(); i++) {
			AddComponent(components.get(i));
		}

		this.name = name;
		SceneObjects.add(this);

	}

	GameObject(String name,
			ArrayList<Component> components) {
		Components.add(transform);
		

		for (int i = 0; i < components.size(); i++) {
			AddComponent(components.get(i));
		}

		this.name = name;
		SceneObjects.add(this);

	}
	
	
}
