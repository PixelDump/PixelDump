package Utils;

import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Engine.GameObject;
import Engine.Main;
import SystemScripts.EditorUtilities;

/**A JPanel specifically for displaying the Hierarchy
 * 
 * @author Jacob
 *
 */
public class HierarchyPanel extends JPanel{

	ArrayList<GameObject> base ;
	ArrayList<SelectableText> texts = new ArrayList<SelectableText>();

	
	
	/**Instantiates and initializes the HierarchyPanel
	 * 
	 */
	public HierarchyPanel(){
		Update();

	}
	
	
	
	public void Update(){

		base = new ArrayList<GameObject>();
		for (int shit = 0; shit < GameObject.getAllGameObjects().size(); shit++) {
			base.add(GameObject.getAllGameObjects().get(shit));
		}
		

		
		this.removeAll();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		// adds to hierarchy UI
		this.add(TextDefaults.MakeText("Hierarchy:"));
		this.add(Box.createRigidArea(new Dimension(0, 2)));

		Childinator();


		//Adds Selectable Text
		for (GameObject x : base) {

			String s = "     ";

			//Adds Indentation to children
			if (x.ParentCount() != 0) {
				for (int z = 0; z < x.ParentCount(); z++) {
					s += "     ";
				}
			}
			
			SelectableText dummytext = new SelectableText(x.name(), "     " + s + x.name());
			texts.add(dummytext);
			this.add(dummytext);
			
			this.add(Box.createRigidArea(new Dimension(0, 2)));

		}
		
		
		this.revalidate();
		this.repaint();
		
		
	}
	
	
	
	/**Organizes all GameObjects by parenthood
	 * 
	 */
	void Childinator() {
		
		ArrayList<GameObject> temp = new ArrayList<GameObject>();
		
		for (int shit = 0; shit < GameObject.getAllGameObjects().size(); shit++) {
			temp.add(GameObject.getAllGameObjects().get(shit));
		}
		
		for (int x = 0; x < temp.size() - 1; x++) {

			if (temp.get(x).ParentCount() != 0) {
				
				// save to holder, remove, place holder in right place
				GameObject holder = temp.get(x);
				temp.remove(temp.get(x));
				temp.add(temp.indexOf(temp.get(x).getParent()) + 1, holder);
			}
		}
	}
	
	
	
	
	/**Edit the selected Text to highlight it.
	 * 
	 * @param name - Name of the GameObject
	 */
	public void setSelected(GameObject go) {

		
		for (SelectableText s : texts) {
			
			if(go!=null){
				
				if (s.getName()==go.name()) {

				s.setSelected(true);
				EditorUtilities.SelectedObject = go;

				} 
			else {
				s.setSelected(false);
				}
			}
			else{
				s.setSelected(false);
			}
		}

	}
	
	
	
	public void setCursor(String type){
		Cursor c;
		
		switch(type){
		case "Move":
			c = new Cursor(Cursor.N_RESIZE_CURSOR);
			break;
		default:
			c = new Cursor(Cursor.DEFAULT_CURSOR);
			break;
		}
		
		this.setCursor(c);	
	}

	
	
}
