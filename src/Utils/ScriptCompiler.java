package Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import Engine.GameObject;
import _Scripts.*;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ScriptCompiler {

	public static ArrayList<Class<?>> PlayerScripts = new ArrayList<Class<?>>();

	public static void loadScript(String name)  {
		System.setProperty("java.home",
				"C:\\Program Files\\Java\\jdk1.8.0_25\\jre");

		String source = null;
		try {
			source = readFile("C:\\Users\\barry\\Desktop\\"+name+".txt",
					StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Save source in .java file.
		File root = new File("/java"); // On Windows running on C:\, this is
										// C:\java.
		File sourceFile = new File(root, "_Scripts/"+name+".java");
		sourceFile.getParentFile().mkdirs();
		try {
			new FileWriter(sourceFile).append(source).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Compile source file.
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		compiler.run(null, null, null, sourceFile.getPath());
		

		// Load and save compiled class.
		URLClassLoader classLoader = null;
		try {
			classLoader = URLClassLoader
					.newInstance(new URL[] { root.toURI().toURL() });
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			for(Class<?> S : PlayerScripts){
				if(S.getTypeName().equals("_Scripts."+name))
					PlayerScripts.remove(S);
			}
			PlayerScripts.add(Class.forName("_Scripts."+name, true, classLoader));
			
			
			
			for(GameObject g: GameObject.getAllGameObjects()){
				for(Component c: g.Components){
					
					if(c.name.equals(name)){
					
						g.removeScript(name);
						((ScriptBase)c).UnLink();
						g.AddScript(getPlayerScript(name));
					}
				}
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ScriptBase getPlayerScript( String name){
		
		for(Class<?> S : PlayerScripts){
		if(S.getTypeName().equals("_Scripts."+name))
			try {
				return ((ScriptBase)S.newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//System.out.println(S.getTypeName());
		}
		
		return null;
		
	}
	
	public static String readFile(String path, Charset encoding)
			throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

}
