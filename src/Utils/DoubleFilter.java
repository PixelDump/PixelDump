package Utils;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
/**
 * Restricts the data types to be entered into double text fields.
 * @author jacob
 *
 */
public class DoubleFilter extends DocumentFilter {

	
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
                             String string, AttributeSet attr)
            throws BadLocationException {

        StringBuffer buffer = new StringBuffer(string);
        for (int i = buffer.length() - 1; i >= 0; i--) {
            char ch = buffer.charAt(i);
            if (!(Character.isDigit(ch)||ch=='.'||ch=='-')) {
                buffer.deleteCharAt(i);
            }
        }
        super.insertString(fb, offset, buffer.toString(), attr);
    }
 /**
  * Removes invalid characters.
  */
    public void replace(DocumentFilter.FilterBypass fb,
                        int offset, int length, String string, AttributeSet attr) throws BadLocationException {
        if (length > 0) fb.remove(offset, length);
        insertString(fb, offset, string, attr);
    }
}

