package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Tag that write a number with radix 8 (octal).
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class OctalNumber extends SimpleTagSupport {

    private int decimalNumber = 0;

    /**
     * Sets the tag attribute decimalNumber.
     *
     * @param decimalNumber nhumber with radix 10
     */
    public final void setDecimalNumber(final int decimalNumber) {
        this.decimalNumber = decimalNumber;
    }

    @Override
    public final void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();

        out.println(Integer.toOctalString(decimalNumber));
    }

}
