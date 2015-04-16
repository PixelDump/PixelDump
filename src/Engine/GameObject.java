package Engine;

import java.util.ArrayList;
import java.util.List;

import SystemScripts.EditorUtilities;
import Utils.Component;
import Utils.GenericObject;
import Utils.PScript;
import Utils.ScriptBase;
import Utils.Transform;
import Utils.Vector2;

/**
 * 
 * @author Jacob and Barry
 * 
 *
 */
public class GameObject extends GenericObject {

	public Transform transform = new Transform(new Vector2());
	private String name = "";

	private ArrayList<GameObject> Children = new ArrayList<GameObject>();
	private GameObject Parent;
	private static ArrayList<GameObject> SceneObjects = new ArrayList<GameObject>();

	/**
	 * Returns the GameObject's Components
	 */
	public ArrayList<Component> GetAllComponents() {
		return Components;
	}

	/**
	 * Removes a passed in child from the GameObject's Children ArrayList. 
	 * @param child - The child to remove
	 */
	public void RemoveChild(GameObject child){
		if(Children.contains(child))
			Children.remove(child);
		
	}
	
	
	/**
	 * Sets a GameObject's children to an array of GameObjects.
	 * 
	 * @param children
	 *            - The ArrayList of child GameObjects
	 */
	public void SetChildren(ArrayList<GameObject> children) {
		this.Children = children;
		Main.window.Hierarchy.Update();
	}

	/**
	 * Adds a GameObject to the GameObject's "Children" ArrayList, then updates
	 * the Hierarchy
	 * 
	 * @param child
	 *            - The GameObject to add
	 */
	public void AddChild(GameObject child) {
		this.Children.add(child);
		child.SetParent(this);
		try {
			Main.window.Hierarchy.Update();
		} catch (Exception e) {
		}
	}

	/**
	 * Sets the GameObject's Parent GameObject
	 * 
	 * @param Parent
	 *            - The Parent GameObject
	 */
	public void SetParent(GameObject Parent) {
		this.Parent = Parent;
	}

	/**
	 * Returns a GameObject's parent GameObject
	 * 
	 * @return The Parent GameObject
	 */
	public GameObject getParent() {
		return this.Parent;
	}

	/**
	 * Returns an instance of a component in the GameObject's Component
	 * ArrayList whose name matches a passed in value.
	 * 
	 * @param name
	 *            - Name to check for
	 * @return The Component whose name matches variable name
	 */
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

	/**
	 * Both removes a component from the GameObject and unLinks it.
	 * 
	 * @param name
	 *            - Name of the component to remove
	 */
	public void removeScript(String name) {
		int i = 0;

		for (Component c : Components) {

			if (name.equals(c.name)) {
				Components.remove(c);
				((ScriptBase) c).UnLink();
				// System.out.println("removed");
				break;
			}

			i++;
		}
	}

	/**
	 * Both removes a component from the GameObject and unLinks it.
	 * 
	 * @param x
	 *            - PScript to remove
	 */
	public void removeScript(PScript x) {
		int i = 0;

		if (Components.contains(x)) {
			Components.remove(x);
			((PScript) x).UnLink();
			// System.out.println("removed");
		}

	}

	/**
	 * Both removes a component from the GameObject and unLinks it.
	 * 
	 * @param x
	 *            - ScriptBase to remove
	 */
	public void removeScript(ScriptBase x) {
		int i = 0;

		if (Components.contains(x)) {
			Components.remove(x);
			((ScriptBase) x).UnLink();
			// System.out.println("removed");
		}

	}
	
	/**Sets Components to null.
	 * 
	 */
	public void removeAllScripts(){
		Components = null;
	}

	/**
	 * Adds a script to the GameObject's Components ArrayList and sets the script's parent to the GameObject (see PScript).
	 * 
	 */
	@Override
	public void AddScript(ScriptBase script) {

		script.setParent(this);
		Components.add(script);
	}

	/**
	 * Adds a script to the GameObject's Components ArrayList and sets the script's parent to the GameObject (see PScript).
	 * 
	 * 
	 */
	public void AddScript(PScript script) {

		script.setParent(this);
		Components.add(script);
	}

	/**Returns the GameObject (from this GameObject's Children ArrayList) whose name matches.
	 * 
	 * @param name - Name to search for
	 * 
	 */
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

	/**
	 * 
	 * @return The GameObject's Children ArrayList
	 */
	public List<GameObject> GetChildren() {

		return Children;
	}

	/**Sets the GameObject's name to a passed in string.
	 * 
	 * @param name - The name to set to
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The GameObject's name
	 */
	public String name() {
		return name;
	}

	/**Removes the passed in GameObject.
	 * 
	 * @param go - GameObject to destroy
	 */
	public static void Destroy(GameObject go) {
		//DOUBLE CHECK IF ALL REFERENCES ARE REMOVED
		//REMOVE FROM VIEW
		
		//System.out.println(go.name());
		
		if(go.Parent!=null)
			go.getParent().Children.remove(go);
		
		go.setName(null);
		go.SetParent(null);
		go.removeAllScripts();
		
		SceneObjects.remove(go);
		Main.window.base.remove(go);
		
		if(go.Children!=null){
			ArrayList<GameObject> toRemove = new ArrayList<GameObject>();
			
			for(GameObject x : go.Children){
				//System.out.println("  "+x.name+" of "+go.Children.size());
				toRemove.add(x);
			}
			
			//go.SetChildren(null);
			destroyThese(toRemove);
		}
		

	}
	
	public static void destroyThese(ArrayList<GameObject> g){
		for(GameObject x: g){
			Destroy(x);
		}
	}

	/**Returns the GameObject matching the passed in name.
	 * 
	 * @param search - Name of the GameObject to find.
	 */
	public static GameObject Find(String search) {
		
		for(GameObject x : SceneObjects)
		if(x.name().equals(search))
		{
			return x;
		}
		

		return null;
	}

	/**Adds a GameObject to the SceneObjects ArrayList (thus "creating" it in the scene)
	 * 
	 * @param go - GameObject to add
	 * @return The GameObject passed in (for convenience)
	 */
	public static GameObject AddGameObject(GameObject go) {

		SceneObjects.add(go);

		return go;
	}

	/**Returns the ArrayList containing all GameObjects
	 * 
	 * @return
	 */
	public static ArrayList<GameObject> getAllGameObjects() {
		return SceneObjects;

	}

	/**Constructs a new GameObject 
	 * (adds a transform by default, adds the GameObject to the SceneObjects ArrayList, updates Hierarchy)
	 * 
	 */
	public GameObject() {

		
		Components.add(transform);
		name = "GameObject";
		SceneObjects.add(this);
		Main.window.Hierarchy.Update();
	}
	
	/**Constructs a new GameObject with the passed in name
	 * (adds a transform by default, adds the GameObject to the SceneObjects ArrayList, updates Hierarchy)
	 * 
	 * @param name - Name of new GameObject
	 */
	public GameObject(String name) {
		Components.add(transform);
		this.name = name;
		SceneObjects.add(this);
		try{
			Main.window.Hierarchy.Update();
		}
		catch(Exception e){}
	}

	/**Constructs a new GameObject with the respective name, scripts and components
	 * (adds a transform by default, adds the GameObject to the SceneObjects ArrayList, updates Hierarchy)
	 * 
	 * @param name - Name of new GameObject
	 * @param scripts - GameObject's scripts
	 * @param components - GameObject's components
	 */
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
		Main.window.Hierarchy.Update();

	}

	/**Constructs a new GameObject with passed in name and components
	 * (adds a transform by default, adds the GameObject to the SceneObjects ArrayList, updates Hierarchy)
	 * 
	 * @param name
	 * @param components
	 */
	GameObject(String name, ArrayList<Component> components) {
		Components.add(transform);

		for (int i = 0; i < components.size(); i++) {
			AddComponent(components.get(i));
		}

		this.name = name;
		SceneObjects.add(this);

		Main.window.Hierarchy.Update();
	}

}
