package no.hib.dat152.tags;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import no.hib.dat152.utility.RomanNumeral;

public class Copyright extends SimpleTagSupport {
    private int since = 2000;

    public final void setSince(final int since) {
        this.since = since;
    }

    @Override
    public final void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print("\u00a9 " + RomanNumeral.toRoman(since) + " - " + RomanNumeral.toRoman(Calendar.getInstance().get(Calendar.YEAR)) + " ");
        getJspBody().invoke(null);
    }
}
