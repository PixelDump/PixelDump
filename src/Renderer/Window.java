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
	
	
	
	Window(ArrayList<GameObject> objects) {
		super();
		this.setTitle("Pixel Dump Development Build! (get to work already)");
		this.setLayout(new GridLayout(1,2));
		this.setPreferredSize(new Dimension(700,400));
		this.setResizable(false);
		
		
		JPanel InspEiarchy = new JPanel();
		InspEiarchy.setLayout(new GridLayout(1,4));
		InspEiarchy.add(UpdateInspector(objects));
		InspEiarchy.add(UpdateHeiarchy());
		
		this.add(c);
		this.add(InspEiarchy);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	
	}

	
	//This is the "View" side of createObjArray from the "Object" class. It literally just lists the objects
	JPanel UpdateHeiarchy(){
		
	ArrayList<GameObject> objects= GameObject.getAllGameObjects();
	
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		//adds to heiarchy UI
		panel.add(makeText("Heiarchy:"));
		panel.add(Box.createRigidArea(new Dimension(0,2)));
		
		
		
		for(int x = 0; x<objects.size(); x++){

			panel.add(makeText("     "+objects.get(x).name()));
			panel.add(Box.createRigidArea(new Dimension(0,2)));
			System.out.println(objects.get(x).name());
			
			if(objects.get(x).GetChildren()!=null){
				for(int y = 0; y<objects.get(x).GetChildren().size(); y++){
					
					objects.remove(objects.get(x).GetChildren().get(y));
					panel.add(makeText("                 "+objects.get(x).GetChildren().get(y).name()));
					panel.add(Box.createRigidArea(new Dimension(0,2)));
					System.out.println("Child: " + objects.get(x).GetChildren().get(y).name());
					
				}
			}
			
		}
		return panel;
	}
	
	
	
	//This will read any attributes and display them in order alongside any variables etc. that are there.
	//The display will have variable alter-ers (shit may be tough) and an option to remove each attribute
	JPanel UpdateInspector(ArrayList<GameObject> objects){
		return new JPanel();
	}
	
	
	
	JLabel makeText(String name){
		
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
