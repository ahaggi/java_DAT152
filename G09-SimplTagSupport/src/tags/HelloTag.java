package tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Tag that write the text "Hello (name)" on a page.
 * 
 * @author Atle Geitung
 */
public class HelloTag extends SimpleTagSupport {
    private String name = "World"; //Default name

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("Hello " + name + "!");
    }
    
    /**
     * Sets the name.
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
