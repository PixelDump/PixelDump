package Engine;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import Renderer.PixDumpWindow;
import Renderer.Window;
import SystemScripts.SystemScripts;
import Utils.GameObjectUtil;
import Utils.GameObjectUtilJcub;
import Utils.ScriptCompiler;

import com.mrjaffesclass.apcs.messenger.Messenger;

/**Main
 * 
 * @author Barry
 *
 */
public class Main {

	static Messenger m = new Messenger();

	public static boolean PlayMode = false;
	
	public static PixDumpWindow p;
	public static Window window;
	
	/**Initializes the GL aspects of the project (in canvas)
	 * 
	 */
	public static void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, window.c.getWidth(), 0,  window.c.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		//GL11.glEnable(GL_DEPTH_TEST);
		//glEnable(GL_DEPTH_TEST);
		glClearColor(.082f,.3f, .7f, 0);
	}

	public static void main(String[] args) {
		Start();
		gameLoop();
		cleanUp();
	}

	/**Creates update loop, renders GL
	 * 
	 */
	public static void gameLoop() {
		
		while (!Display.isCloseRequested()) {
			// getInput();
			Update();
			Render();
			
		}
		
	}

	/**Initializes the entire program
	 * 
	 */
	public static void Start() {
		ScriptCompiler.pickProject();
		
		GameObjectUtil.Start();
		GameObjectUtilJcub.Start();
		p = new PixDumpWindow();
		window = new Window();
		
		initDisplay();
		initGL();
		
		SystemScripts.Start();
		
		m.notify("Start");

	
	}


	/**Initializes display settings
	 * 
	 */
	public static void initDisplay() {
		try {
			
			Display.setDisplayMode(new DisplayMode(window.c.getWidth(), window.c.getHeight()));
			Display.create();

			Display.setParent(window.c);
			Display.setVSyncEnabled(true);
			Keyboard.create();
			Mouse.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**Notifies "Update" using Messenger
	 * 
	 */
	public static void Update() {
	 
		try{
		m.notify("Update");
		}catch(Exception e){e.printStackTrace();}
	}

	/**Updates Display, notifies "Render" and clears GL
	 * 
	 */
	public static void Render() {

		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();

		// Draw
		m.notify("Render");
		
		Display.update();
		Display.sync(60);

	}

	/**Removes Display and Keyboard links
	 * 
	 */
	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
	}

	/**
	 * 
	 * @return Main's Messenger
	 */
	public static Messenger getMessenger() {
		return m;
	}

}
