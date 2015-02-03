package Renderer;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Engine.GameObject;




public class Window extends PixDumpWindow{

	
	public Canvas c =new Canvas();
	
	
	JPanel Inspector;
	JPanel Hierarchy = new JPanel();
	Window() {
		
		super();
		this.setTitle("Pixel Dump Development Build! (get to work already)");
		this.setLayout(new GridLayout(1,2));
		this.setPreferredSize(new Dimension(700,400));
		this.setResizable(false);
		
		UpdateHierarchy();
		UpdateInspector();
		JPanel InspEierarchy = new JPanel();
		InspEierarchy.setLayout(new GridLayout(1,4));
		InspEierarchy.add(Inspector);
		InspEierarchy.add(Hierarchy);
		
		this.add(c);
		this.add(InspEierarchy);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	
	}

	
	//This is the "View" side of createObjArray from the "Object" class. It literally just lists the objects
	public void UpdateHierarchy(){
		
	ArrayList<GameObject> objects= GameObject.getAllGameObjects();
	
		
		Hierarchy.removeAll();
		Hierarchy.setLayout(new BoxLayout(Hierarchy, BoxLayout.PAGE_AXIS));
		
		//adds to hierarchy UI
		Hierarchy.add(MakeText("Hierarchy:"));
		Hierarchy.add(Box.createRigidArea(new Dimension(0,2)));
		
		
		Childinator();
		
		
		for(int x = 0; x<objects.size(); x++){

			String s = "     ";
			
			
			if(ParentCount(objects.get(x))!=0){
				for (int z = 0; z<ParentCount(objects.get(x)); z++){
					s+="     ";
					//System.out.println("yo");
				}
			}
			Hierarchy.add(MakeText("     "+s+objects.get(x).name()));
			Hierarchy.add(Box.createRigidArea(new Dimension(0,2)));
			
			
		}
		
		this.revalidate();
		this.repaint();
		
	}
	
	
	
	//This will read any attributes and display them in order alongside any variables etc. that are there.
	//The display will have variable alter-ers (shit may be tough) and an option to remove each attribute
	void UpdateInspector(){
		Inspector=new JPanel();
		
	}
	
	//organizes GameObject array into children and subChildren
	void Childinator(){
		ArrayList<GameObject> base = new ArrayList<GameObject>();
		for(int shit = 0; shit<GameObject.getAllGameObjects().size(); shit++){
			base.add(GameObject.getAllGameObjects().get(shit));
			//fuck this
		}
		
		for(int x = 0; x<base.size()-1; x++){
			
			if(ParentCount(base.get(x))==0){
			}
			else{
				//save to holder, remove, place holder in right place
				GameObject holder = base.get(x);
				base.remove(base.get(x));
				base.add(base.indexOf(base.get(x).getParent())+1,holder);
			}
		}
	}
	
	int ParentCount(GameObject c){
		int parentCount =0;
		while(c.getParent()!=null){
			parentCount++;
			c = c.getParent();
		}
		return parentCount;
	}
	
	JLabel MakeText(String name){
		
		final JLabel text = new JLabel();
		text.setText(name);
		text.setMinimumSize(new Dimension(10,10));
		text.setPreferredSize(new Dimension(10,10));
		text.setMaximumSize(new Dimension(Short.MAX_VALUE,20));
		text.setForeground(new Color(150, 150, 150));
        text.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                //Your code here
            }

            @Override
            public void focusLost(FocusEvent e) {
                //Your code here
            }
        });
        return text;
	}
	
}
