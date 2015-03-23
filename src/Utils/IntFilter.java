package Utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**A custom filter for documents (type Int)
 * 
 * @author Jacob
 *
 */
public class IntFilter extends DocumentFilter {

	/**Only allows characters associated with Integers to be entered
	 * 
	 */
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
                             String string, AttributeSet attr)
            throws BadLocationException {

        StringBuffer buffer = new StringBuffer(string);
        for (int i = buffer.length() - 1; i >= 0; i--) {
            char ch = buffer.charAt(i);
            if (!Character.isDigit(ch)) {
                buffer.deleteCharAt(i);
            }
        }
        super.insertString(fb, offset, buffer.toString(), attr);
    }

    /**Replaces existing string with changed one (modified by passed in FilterBypass and AttributeSet)
     * 
     */
    public void replace(DocumentFilter.FilterBypass fb,
                        int offset, int length, String string, AttributeSet attr) throws BadLocationException {
        if (length > 0) fb.remove(offset, length);
        insertString(fb, offset, string, attr);
    }
}
