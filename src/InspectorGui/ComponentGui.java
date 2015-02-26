package InspectorGui;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.swing.JPanel;

import Utils.Component;

public class ComponentGui extends JPanel{

	ComponentGui(Component c){
		
		for(Field j : c.getVariables()){
			Type t = j.getGenericType();
			
            if (t instanceof ParameterizedType) {

                ParameterizedType pType = (ParameterizedType)t;
                Type[] arr = pType.getActualTypeArguments();

                for (Type tp: arr) {
                    Class<?> clzz = (Class<?>)tp;
                    System.out.println(clzz.getName());
                }
            }
		}
		
		
		
	}
	
	
}
