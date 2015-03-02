package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import Engine.GameObject;
import Engine.Main;
import SystemScripts.EditorUtilities;

public class ScriptCompiler {

	public static ArrayList<Class<?>> PlayerScripts = new ArrayList<Class<?>>();
	public static String projectPath;

	public static void loadScript(String name) {
		System.setProperty("java.home",
				getJDKPath());

		String source = null;
		try {
			source = readFile(projectPath + "\\" + name + ".pscript",
					StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Save source in .java file.
		File root = new File("/java"); // On Windows running on C:\, this is
										// C:\java.
		File sourceFile = new File(root, "_Scripts/" + name + ".java");
		
		sourceFile.getParentFile().mkdirs();
		try {
			new FileWriter(sourceFile).append(source).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Compile source file.
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		System.out.println(sourceFile.getPath());
		compiler.run(null, null, null, sourceFile.getPath());
		

		// Load and save compiled class.
		URLClassLoader classLoader = null;
		try {
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI()
					.toURL() });
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			for (Class<?> S : PlayerScripts) {
				if (S.getTypeName().equals("_Scripts." + name))
					PlayerScripts.remove(S);
			}
			PlayerScripts.add(Class.forName("_Scripts." + name, true,
					classLoader));

			for (GameObject g : GameObject.getAllGameObjects()) {
				for (Component c : g.Components) {

					if (c.name.equals(name)) {

						g.removeScript(name);
						((ScriptBase) c).UnLink();
						g.AddScript(getPlayerScript(name));
						
					}
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static PScript getPlayerScript(String name) {

		for (Class<?> S : PlayerScripts) {
			if (S.getTypeName().equals("_Scripts." + name))
				try {
					return ((PScript) S.newInstance());
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
			// System.out.println(S.getTypeName());
		}

		return null;

	}

	public static Class<?> getPlayerClass(String name) {

		for (Class<?> S : PlayerScripts) {
			if (S.getTypeName().equals("_Scripts." + name)) {
				try {
					return S;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// System.out.println(S.getTypeName());
			}
		}
		return null;

	}

	public static void pickProject() {
		try {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception e) {e.printStackTrace();     }
		JFileChooser fileChooser = new JFileChooser() {
			{
				this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			}
		};
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			projectPath = selectedFile.getAbsolutePath();
			System.out.println(projectPath);

			File[] scripts = getScriptsInProject(selectedFile);
			for (File f : scripts) {
				System.out.println(f.getName().substring(0,
						f.getName().indexOf('.')));
				loadScript(f.getName().substring(0, f.getName().indexOf('.')));
			}

		}

	}

	public static void recompile(){
		for(Class<?> c : PlayerScripts){
			loadScript(c.getName().substring( c.getName().indexOf('.')+1));
			Main.window.UpdateInspector(EditorUtilities.SelectedObject);
		}
		System.out.println("scripts updated");
		
	
	}
	
	public static File[] getScriptsInProject(File dir) {

		return dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String filename) {
				return filename.endsWith(".pscript");
			}
		});

	}

	public static String readFile(String path, Charset encoding)
			throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}

	
	public static String getJDKPath(){
		File java = new File("..\\JAVAPATH.txt");
		try {
			Scanner s = new Scanner(java);
			String path = s.nextLine();
			System.out.println(path);
			return path;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
