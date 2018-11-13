package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Tag that surrounds the body text with a coloured box.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class ColoredBox extends SimpleTagSupport {

    private String color = "white";

    /**
     * Sets the tag attribute color.
     * 
     * @param color the color
     */
    public final void setColor(final String color) {
        this.color = color;
    }

    @Override
    public final void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();

        out.println("<table width=\"200\" cellpadding=\"5\" bgcolor=\"" + color + "\">");
        out.println("<tr>");
        out.println("<td>");
        getJspBody().invoke(out);
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
    }

}
