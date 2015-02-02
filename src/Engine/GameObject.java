package Engine;

import java.util.ArrayList;
import java.util.List;

public class GameObject {

	public Transform transform = new Transform(new Vector2());
	private String name = "";
	private List<Component> Components = new ArrayList<Component>();
	private List<GameObject> Children = new ArrayList<GameObject>();
	private GameObject Parent;
	
	
	private static ArrayList<GameObject> SceneObjects = new ArrayList<GameObject>();

	//BARRY I ADDED THIS IN
	public void setChildren(List<GameObject> children){
		this.Children=children;
	}
	public void addChild(GameObject child){
		this.Children.add(child);
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

	public void AddComponent(Component c) {
		Components.add(c);
	}

	public void AddScript(ScriptBase script) {
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
			if (search.equals(SceneObjects.get(i))) {
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
	
	GameObject() {

		Components.add(transform);
		name = "GameObject";
		SceneObjects.add(this);
		
	}

	GameObject(String name) {
		Components.add(transform);
		this.name = name;
		SceneObjects.add(this);

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
