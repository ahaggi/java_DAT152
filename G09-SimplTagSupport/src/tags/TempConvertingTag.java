package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Converts av temperature in kelvin to celsius or fahrenight.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public class TempConvertingTag extends SimpleTagSupport {

    private double temp;
    private String scale;

    /**
     * Sets the tag attribute temp.
     *
     * @param temp temerature
     */
    public final void setTemp(final double temp) {
        this.temp = temp;
    }

    /**
     * Sets the tag attribute scale.
     *
     * @param scale scale
     */
    public final void setScale(final String scale) {
        this.scale = scale;
    }

    @Override
    public final void doTag() throws JspException, IOException {

        double t;
        if (scale.equals("celsius")) {
            t = temp - 273;
        } else if (scale.equals("fahrenheit")) {
            t = (temp - 273) * 1.8 + 32;
        } else {
            t = temp;
        }

        JspWriter out = getJspContext().getOut();
        out.print(t);

    }

}
