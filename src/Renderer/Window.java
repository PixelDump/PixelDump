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
import Utils.TextDefaults;
import Utils.windowMenu;

public class Window extends PixDumpWindow {

	public Canvas c = new Canvas();
	public JPanel InspeIarchy = new JPanel();
	final ArrayList<JLabel> textList = new ArrayList<JLabel>();
	int textCount = 0;
	JPanel Inspector;
	JPanel Hierarchy = new JPanel();
	JScrollPane InspectorScroll;
	JScrollPane HierarchyScroll;
	JPanel CanvasPanel = new JPanel();
	windowMenu w = new windowMenu();
	JToggleButton play = new JToggleButton();
	

	//Constructor
	public Window() {
		super();

		ArrayList<GameObject> base = new ArrayList<GameObject>();
		for (int shit = 0; shit < GameObject.getAllGameObjects().size(); shit++) {
			base.add(GameObject.getAllGameObjects().get(shit));
			// fuck this
		}
		this.setTitle("Pixel Dump Development Build! (get to work already)");
		this.setLayout(new GridLayout(1, 2));
		this.setPreferredSize(new Dimension(700, 400));
		//this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setResizable(true);

		UpdateHierarchy();
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
		InspeIarchy.add(HierarchyScroll);

		this.add(CanvasPanel);
		this.add(InspeIarchy);
		this.setJMenuBar(w);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();

	}

	// This is the "View" side of createObjArray from the "Object" class. It
	// literally just lists the objects (fancily)
	public void UpdateHierarchy() {
		textList.clear();
		textCount = 0;
		ArrayList<GameObject> base = new ArrayList<GameObject>();

		for (GameObject g: GameObject.getAllGameObjects()) {
			base.add(g);
			// fuck this
		}

		Hierarchy.removeAll();
		Hierarchy.setLayout(new BoxLayout(Hierarchy, BoxLayout.PAGE_AXIS));

		// adds to hierarchy UI
		Hierarchy.add(TextDefaults.MakeText("Hierarchy:"));
		Hierarchy.add(Box.createRigidArea(new Dimension(0, 2)));

		Childinator();

		for (int x = 0; x < base.size(); x++) {

			String s = "     ";

			if (ParentCount(base.get(x)) != 0) {
				for (int z = 0; z < ParentCount(base.get(x)); z++) {
					s += "     ";
				}
			}
			Hierarchy.add(MakeSelectableText("     " + s + base.get(x).name()));
			Hierarchy.add(Box.createRigidArea(new Dimension(0, 2)));

		}
		HierarchyScroll = new JScrollPane(Hierarchy);
		this.revalidate();
		this.repaint();
		
		

	}

	// This will read any attributes and display them in order alongside any
	// variables etc. that are there.
	// The display will have variable alter-ers (shit may be tough) and an
	// option to remove each attribute
	
	public void UpdateInspector(GameObject g) {
		Inspector.removeAll();
		Inspector.add(new InspectorPanel(g));
		
		//updates gui
		Inspector.revalidate();
		Inspector.repaint();
		
		
		
	}

	
	
	
	
	// organizes GameObject array into children and subChildren
	void Childinator() {
		ArrayList<GameObject> base = new ArrayList<GameObject>();
		for (int i = 0; i < GameObject.getAllGameObjects().size(); i++) {
			base.add(GameObject.getAllGameObjects().get(i));
			// fuck this
		}
		for (int x = 0; x < base.size() - 1; x++) {

			if (ParentCount(base.get(x)) == 0) {
			} else {
				// save to holder, remove, place holder in right place
				GameObject holder = base.get(x);
				base.remove(base.get(x));
				base.add(base.indexOf(base.get(x).getParent()) + 1, holder);
			}
		}
	}

	int ParentCount(GameObject c) {
		int parentCount = 0;
		while (c.getParent() != null) {
			parentCount++;
			c = c.getParent();
		}
		return parentCount;
	}

	JLabel MakeSelectableText(String text) {

		JLabel p = new JLabel();
		p.setName(Integer.toString(textCount));

		textList.add(p);

		textList.get(textCount).setText(text);
		textList.get(textCount).setMinimumSize(new Dimension(10, 10));
		textList.get(textCount).setPreferredSize(new Dimension(10, 10));
		textList.get(textCount).setMaximumSize(
				new Dimension(Short.MAX_VALUE, 20));
		textList.get(textCount).setForeground(new Color(150, 150, 150));

		textList.get(textCount).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				EditorUtilities.setSelected(labelToGo(((JLabel) e.getSource())
						.getName()));

			}

		});
		textCount++;
		return textList.get(textCount - 1);
	}

	public void setSelected(String name) {

		for (int x = 0; x < textList.size(); x++) {

			if (labelToGo(textList.get(x).getName()).name().equals(name)) {

				textList.get(x).setBackground(new Color(60, 60, 60));
				textList.get(x).setOpaque(true);

			} else {
				textList.get(x).setBackground(new Color(150, 150, 150));
				textList.get(x).setOpaque(false);
			}
		}

	}

	public GameObject labelToGo(String n) {
		return GameObject.getAllGameObjects().get(Integer.parseInt((n)));
	}
}
