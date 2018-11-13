package tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Tag that converts the body text to CAPS.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public class UpperCase extends SimpleTagSupport {

    @Override
    public final void doTag() throws JspException, IOException {

        StringWriter stringWriter = new StringWriter();

        getJspBody().invoke(stringWriter);
        
        String bodyText = stringWriter.getBuffer().toString();
        
        getJspContext().getOut().println(bodyText.toUpperCase());
    }

}
