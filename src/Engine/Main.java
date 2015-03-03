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
import SystemScripts.*;
import Utils.GameObjectUtil;
import Utils.GameObjectUtilJcub;
import Utils.NewGameObjectDialog;
import Utils.ScriptCompiler;

import com.mrjaffesclass.apcs.messenger.Messenger;

public class Main {

	static Messenger m = new Messenger();

	public static boolean PlayMode = false;
	
	public static PixDumpWindow p;
	public static Window window;
	
	public static NewGameObjectDialog  newGameObjectDialog;
	
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

	public static void gameLoop() {
		
		while (!Display.isCloseRequested()) {
			// getInput();
			Update();
			Render();
			
		}
		
	}

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

		newGameObjectDialog= new NewGameObjectDialog();
	
	}


	
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

	public static void Update() {
	 if(Input.getKey(Keyboard.KEY_C)){
		 
		 ScriptCompiler.recompile();
	 }
		try{
		m.notify("Update");
		}catch(Exception e){e.printStackTrace();}
		
	}

	public static void Render() {

		glClear(GL_COLOR_BUFFER_BIT);
		glLoadIdentity();

		// Draw
		m.notify("Render");
		
		Display.update();
		Display.sync(60);

	}

	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
	}

	public static Messenger getMessenger() {
		return m;
	}

}
