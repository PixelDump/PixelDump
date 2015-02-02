package Renderer;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Engine.GameObject;


//TODO: 

public class Window extends PixDumpWindow{

	
	public Canvas c =new Canvas();
	
	
	
	Window(ArrayList<GameObject> objects) {
		super();
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
		//panel.setLayout(null);
		
		//adds to heiarchy UI
		for(int x = 0; x<objects.size(); x++){

			panel.add(makeText(objects.get(x).name()));
			System.out.println(objects.get(x).name());
			if(objects.get(x).GetChildren()!=null){
				for(int y = 0; y<objects.get(x).GetChildren().size(); y++){
				panel.add(makeText(objects.get(x).GetChildren().get(y).name()));
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
	
	
	
	JTextArea makeText(String name){
		final JTextArea textArea = new JTextArea();
		textArea.setText(name);
        textArea.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                //Your code here
            }

            @Override
            public void focusLost(FocusEvent e) {
                //Your code here
            }
        });
        return textArea;
	}
	
}
