package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Tag that writes a decimal number as a binary number.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class BinaryNumber extends SimpleTagSupport {

    private int decimalNumber = 0;

    /**
     * Sets the tag attribute decimalNumber.
     *
     * @param decimalNumber number given with radix 10
     */
    public final void setDecimalNumber(final int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    @Override
    public final void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println(  Integer.toBinaryString(decimalNumber)  );
    }

}
