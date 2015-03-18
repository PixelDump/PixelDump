package SystemScripts;

import java.util.Arrays;
import java.util.List;

import Utils.GameObjectUtil;
import Utils.GenericObject;
import Utils.ScriptBase;

/**Foundation of player script implementation.
 * 
 * @author Barry
 *
 */
public class SystemScripts {
	private String name = "";

	static GenericObject SystemScriptObject = new GenericObject(
			"SystemScriptObject");
	static List<ScriptBase> scripts;

	public static void Start() {

		// Now you can create classes that extend script base and put them in this array.
		// They will run just like a regular script but we will use them for building the engine.
		scripts = Arrays.asList(new ScriptBase[] { new EditorUtilities(), new Input(), new CheckDelete() });
	}

}
