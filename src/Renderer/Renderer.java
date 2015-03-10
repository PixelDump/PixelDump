package Renderer;

import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_REPEAT;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_S;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_WRAP_T;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glRotated;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTexParameterf;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL11.*;

import java.io.IOException;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import Engine.Main;
import SystemScripts.EditorUtilities;
import Utils.Vector2I;

import com.mrjaffesclass.apcs.messenger.MessageHandler;
import com.mrjaffesclass.apcs.messenger.Messenger;

/**
 * 
 * @author Barry
 *
 */
public class Renderer extends Utils.ScriptBase implements MessageHandler {

	private Texture texture;
	String texturePath = "art";
	Messenger m;

	Utils.Vector2 scale;
	public float pixelScale = 3f;

	/**Initializes a Renderer
	 * 
	 */
	public Renderer() {
		super("Renderer");
		PlayInEditMode= true;
		m = Main.getMessenger();
		m.subscribe("Render", this);

	}

	/**Initializes a Renderer with a corresponding filepath
	 * 
	 * @param Path - String of filepath to follow
	 */
	public Renderer(String Path) {
		super("Renderer");
		PlayInEditMode= true;
		 setTexturePath(Path);

		m = Main.getMessenger();
		m.subscribe("Render", this);

	}

	/**Loads and binds a .png file as a texture.
	 * 
	 */
	public void GLTextureSetup() {
		try {
			texture = TextureLoader.getTexture(
					"PNG",
					ResourceLoader.getResourceAsStream("src/res/" + texturePath
							+ ".png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		glEnable(GL_TEXTURE_2D);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
		glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
		glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);

		texture.bind();
		scale = new Utils.Vector2(texture.getTextureWidth() * pixelScale,
				texture.getTextureHeight() * pixelScale);
	
	}

	/**Assigns a texture to an object.
	 * 
	 */
	public void GLTextureDraw() {
		 glPushMatrix();
		//glRotatef(270,0,0,1);
		
		glBegin(GL_QUADS);
		{

			glTexCoord2f(1, 0);
			glVertex3f(gameObject.transform.position.x,
					gameObject.transform.position.y + scale.y,gameObject.transform.depth);

			glTexCoord2f(0, 0);
			glVertex3f(gameObject.transform.position.x + scale.x,
					gameObject.transform.position.y + scale.y,gameObject.transform.depth);

			glTexCoord2f(0, 1);
			glVertex3f(gameObject.transform.position.x + scale.x,
					gameObject.transform.position.y,gameObject.transform.depth);

			glTexCoord2f(1, 1);
			glVertex3f(gameObject.transform.position.x,
					gameObject.transform.position.y,gameObject.transform.depth);
			

		}
		glEnd();
		 glPopMatrix();
		
	}

	/**Calls several functions to draw sprites to a canvas.
	 * 
	 */
	public void Render() {

		
		GLTextureSetup();

		GLTextureDraw();
		texture.release();
		scale = new Utils.Vector2(texture.getTextureWidth() * pixelScale,
				texture.getTextureHeight() * pixelScale);
		if (inBounds()&&!EditorUtilities.mouseHover.contains(gameObject)) {
			EditorUtilities.mouseHover.add(gameObject);
		} else if(EditorUtilities.mouseHover.contains(gameObject)){
			EditorUtilities.mouseHover.remove(gameObject);
		}

	}

	public void Start() {

	}

	public void Update() {

	}

	/**Runs Render whenever message "Render" is sent.
	 * 
	 */
	@Override
	public void messageHandler(String messageName, Object messagePayload) {
		switch (messageName) {
		case "Render":
			Render();
		}
	}
	
	/**Sets texturePath to passed filepath (String).
	 * 
	 * @param Path
	 */
	public void setTexturePath(String Path) {
		texturePath = Path;
	}

	/**Returns whether or not the player's mouse is within an object's bounds.
	 * 
	 * 
	 */
	public boolean inBounds() {
	
		Vector2I mousePosition = new Vector2I(Mouse.getX(),Mouse.getY());
				
				
		if (scale != null) {

		/*	System.out.println(mousePosition.x + " , " + (mousePosition.y)
					+ " , "
					+ (transform.position.x + texture.getTextureWidth() * 5)
					+ " , " + (transform.position.y + scale.y));*/
			return mousePosition.x > transform.position.x
					&& mousePosition.x < transform.position.x + scale.x
					&& mousePosition.y > transform.position.y
					&& mousePosition.y < transform.position.y + scale.y;
		}
		return false;
	}

}
