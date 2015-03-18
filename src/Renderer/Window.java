package Renderer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

import Engine.GameObject;
import Engine.Main;
import InspectorGui.InspectorPanel;
import SystemScripts.EditorUtilities;
import Utils.HierarchyPanel;
import Utils.TextDefaults;
import Utils.windowMenu;

/**Creates the JFrame containing the entire project.
 * 
 * @author Jacob
 *
 */
public class Window extends PixDumpWindow {

	public Canvas c = new Canvas();
	public JPanel InspeIarchy = new JPanel();
	public ArrayList<GameObject> base;
	
	JPanel Inspector;
	public HierarchyPanel Hierarchy;
	JScrollPane InspectorScroll;
	JScrollPane HierarchyScroll;
	JPanel CanvasPanel = new JPanel();
	windowMenu w = new windowMenu();
	JToggleButton play = new JToggleButton();

	/**Constructs a new Window (containing the entire project)
	 * 
	 */
	public Window() {
		super();

		/**Retrieves all GameObjects
		 * 
		 */
		base = new ArrayList<GameObject>();
		for (int shit = 0; shit < GameObject.getAllGameObjects().size(); shit++) {
			base.add(GameObject.getAllGameObjects().get(shit));
		}
		
		Hierarchy = new HierarchyPanel();
		
		this.setTitle("Pixel Dump Development Build! (get to work already)");
		this.setLayout(new GridLayout(1, 2));
		this.setPreferredSize(new Dimension(700, 400));
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setResizable(true);

		
		Inspector = new JPanel();
		Inspector.setLayout(new BoxLayout(Inspector, BoxLayout.Y_AXIS));
		InspectorScroll = new JScrollPane(Inspector,InspectorScroll.VERTICAL_SCROLLBAR_AS_NEEDED,InspectorScroll.HORIZONTAL_SCROLLBAR_NEVER);
		
		play.setText("Play");
		play.setForeground(new Color(100,100,100));
		play.setAlignmentX(CENTER_ALIGNMENT);
		play.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(play.isSelected()){
					Main.PlayMode=true;
				}
				else{
					Main.PlayMode=false;
				}
				
			}});
		
		InspeIarchy = new JPanel();
		InspeIarchy.setLayout(new GridLayout(1, 4));
		
		CanvasPanel.add(play);
		CanvasPanel.add(c);
		CanvasPanel.setLayout(new BoxLayout(CanvasPanel, BoxLayout.Y_AXIS));
		
		InspeIarchy.add(InspectorScroll);
		UpdateHierarchy();

		this.add(CanvasPanel);
		this.add(InspeIarchy);
		this.setJMenuBar(w);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();

	}


	/**Displays all GameObjects (ordered algorithmically by parenthood) with selection functionality.
	 * 
	 */
	public void UpdateHierarchy() {
		
		InspeIarchy.removeAll();
		
		if(InspectorScroll!=null)
		InspeIarchy.add(InspectorScroll);
		InspeIarchy.add( new JScrollPane(Hierarchy));
		
		this.revalidate();
		this.repaint();
		
	}


	/**Reads all Components of a passed in GameObject and displays them.
	 * 
	 * @param g - GameObject to inspect
	 */
	public void UpdateInspector(GameObject g) {
		Inspector.removeAll();
		
		if(g!=null)
		Inspector.add(new InspectorPanel(g));
		
		//updates gui
		Inspector.revalidate();
		Inspector.repaint();
		
	}

	

	
}
