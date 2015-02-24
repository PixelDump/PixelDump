package Renderer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.GameObject;
import SystemScripts.EditorUtilities;
import Utils.Component;
import Utils.PreSpectors;

public class Window extends PixDumpWindow {

	public Canvas c = new Canvas();
	final ArrayList<JLabel> textList = new ArrayList<JLabel>();
	int textCount = 0;
	JPanel Inspector;
	JPanel Hierarchy = new JPanel();

	Window() {
		super();

		ArrayList<GameObject> base = new ArrayList<GameObject>();
		for (int shit = 0; shit < GameObject.getAllGameObjects().size(); shit++) {
			base.add(GameObject.getAllGameObjects().get(shit));
			// fuck this
		}
		this.setTitle("Pixel Dump Development Build! (get to work already)");
		this.setLayout(new GridLayout(1, 2));
		this.setPreferredSize(new Dimension(700, 400));
		this.setResizable(false);

		UpdateHierarchy();
		UpdateInspector();
		JPanel InspEierarchy = new JPanel();
		InspEierarchy.setLayout(new GridLayout(1, 4));
		InspEierarchy.add(Inspector);
		InspEierarchy.add(Hierarchy);
		

		this.add(c);
		this.add(InspEierarchy);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();

	}

	// This is the "View" side of createObjArray from the "Object" class. It
	// literally just lists the objects
	public void UpdateHierarchy() {
		
		textList.clear();
		textCount = 0;
		ArrayList<GameObject> base = new ArrayList<GameObject>();

		for (int shit = 0; shit < GameObject.getAllGameObjects().size(); shit++) {
			base.add(GameObject.getAllGameObjects().get(shit));
			// fuck this
		}

		Hierarchy.removeAll();
		Hierarchy.setLayout(new BoxLayout(Hierarchy, BoxLayout.PAGE_AXIS));

		// adds to hierarchy UI
		Hierarchy.add(UI.MakeText("Hierarchy:"));
		Hierarchy.add(Box.createRigidArea(new Dimension(0, 2)));

		Childinator();

		for (int x = 0; x < base.size(); x++) {

			String s = "     ";

			if (ParentCount(base.get(x)) != 0) {
				for (int z = 0; z < ParentCount(base.get(x)); z++) {
					s += "     ";
					// System.out.println("yo");
				}
			}
			Hierarchy.add(MakeSelectableText("     " + s + base.get(x).name()));
			Hierarchy.add(Box.createRigidArea(new Dimension(0, 2)));

		}

		this.revalidate();
		this.repaint();

	}

	// This will read any components and display them in order alongside any
	// variables etc. that are there.
	// The display will have variable alter-ers (shit may be tough) and an
	// option to remove each attribute
	void UpdateInspector() {
		
		//List<Component> components = GameObject.getAllComponents();
		Inspector = new JPanel();
		Inspector.setLayout(new BoxLayout(Inspector, BoxLayout.PAGE_AXIS));

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

		  JLabel p = UI.MakeText(text);
		  p.setName(Integer.toString(textCount));

		 p.addMouseListener(new MouseAdapter() {
		   @Override
		   public void mouseClicked(MouseEvent e) {

		    EditorUtilities.setSelected(labelToGo(((JLabel) e.getSource())
		      .getName()));

		   }

		  });
		  textList.add(p);
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
