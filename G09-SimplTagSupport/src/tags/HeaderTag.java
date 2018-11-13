package tags;
/*****************************************************************/
/* Copyright 2013 Code Strategies                                */
/* This code may be freely used and distributed in any project.  */
/* However, please do not remove this credit if you publish this */
/* code in paper or electronic form, such as on a web site.      */
/*****************************************************************/


import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HeaderTag extends SimpleTagSupport {

	private int headerSize = 1;

	public void setHeaderSize(int headerSize) {
		this.headerSize = headerSize;
	}

	public void doTag() throws JspException {
		try {
			if (headerSize < 1) {
				headerSize = 1;
			} else if (headerSize > 3) {
				headerSize = 3;
			}

			StringWriter sw = new StringWriter();
			sw.append("<h" + headerSize + ">");

			JspFragment body = getJspBody();
			body.invoke(sw);

			sw.append("</h" + headerSize + ">");
			getJspContext().getOut().println(sw.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}