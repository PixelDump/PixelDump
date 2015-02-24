package Utils;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Renderer.UI;

public class PreSpectors extends JPanel{

	JTextField t = new JTextField();
	JRadioButton r = new JRadioButton();
	
	public PreSpectors(String type, String name, Object variable){	
		
		this.setLayout(new GridLayout(1,2));
		
		t.setText("Variable Value");
		t.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				//Do Shit
				System.out.println("hey");
	        }
		});
		r.addActionListener( new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Do Shit
				System.out.println("yo");
			}
		});	
		this.add(UI.MakeText(name+": "));
		PreSpect(type,variable);
	}
	
	public JPanel PreSpect(String type, Object o){
		switch(type){
		case "Integer":
			this.add(t);
			break;
		case "Double":
			this.add(t);
			break;
		case "Boolean":
			this.add(r);
			break;
		case "Vector2":
			this.add(t);
			this.add(t);
			break;
		case "Vector2I":
			this.add(t);
			this.add(t);
			break;
		default:
			System.out.println("Invalid Data Type");
			break;
		
		}
		
		this.add(t);
		return this;	
	}
	
	
}
