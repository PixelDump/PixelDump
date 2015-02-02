package Engine;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glOrtho;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import Renderer.UI;

import com.mrjaffesclass.apcs.messenger.Messenger;

public class Main {

	static Messenger m = new Messenger();
	//static Window window = new  Window();

	static UI ui = new UI();
	public static void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, ui.window.c.getWidth(), 0,  ui.window.c.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		glDisable(GL_DEPTH_TEST);
		glClearColor(.5f,.7f, .4f, 0);
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

		initDisplay();
		initGL();
		
		
		GameObject go = new GameObject("Test Object");
		//go.AddScript(new Renderer("jacob"));
		go.AddScript(new testScript());
		m.notify("Start");

	}


	
	public static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(300, 300));
			Display.create();

			Display.setParent(ui.window.c);
			Display.setVSyncEnabled(true);
			Keyboard.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Update() {
		m.notify("Update");

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
