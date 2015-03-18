package Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * 
 * @author Barry and Jacob
 *
 */
public class ComponentCombo extends JComboBox {

	// This may need to be changed to find scripts from file locations?
	/**
	 * Contsructs Combo Box for Inspector.
	 */
	public ComponentCombo() {

		for (int x = 0; x < ScriptCompiler.PlayerScripts.size(); x++) {
			this.addItem(makeObj(ScriptCompiler.PlayerScripts
					.get(x)
					.getName()
					.substring(
							ScriptCompiler.PlayerScripts.get(x).getName()
									.indexOf('.') + 1)));
		}

	}

	/**Create object from string to add to combo box.
	 * 
	 * @param item - name of item
	 * @return Object to add to combo box.
	 */
	private Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}

}
