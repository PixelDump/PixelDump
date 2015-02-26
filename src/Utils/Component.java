package Utils;

import java.lang.reflect.Field;
import java.util.ArrayList;

public abstract class Component {

	public String name;
	public static Field[] variables;
	
	Component(String name){
		this.name =name;
	}
	
	public Field[] getVariables() {
		try{
			Class<?> act = Class.forName(name);
			variables = act.getFields();
			return variables;
		}
		catch(Exception e){
			return null;
		}
	}
	
}
