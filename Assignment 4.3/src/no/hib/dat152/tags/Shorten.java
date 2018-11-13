package no.hib.dat152.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Shorten extends SimpleTagSupport {
    private int length;

    public final void setLength(final int length) {
        this.length = length;
    }

    @Override
    public final void doTag() throws JspException, IOException {
    	StringWriter sw = new StringWriter();
    	getJspBody().invoke(sw);
    	getJspContext().getOut().print(sw.toString().substring(0, length) + " ...");
    }
}
