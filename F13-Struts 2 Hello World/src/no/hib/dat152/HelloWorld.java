package no.hib.dat152;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Hello World for struts 2.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 *
 */
public class HelloWorld extends ActionSupport {

    private static final long serialVersionUID = 1L;

    @Override
    public final String execute() {
        return SUCCESS;
    }

    /**
     * Get message.
     *
     * @return message
     */
    public final String getMessage() {
        return "Hello World";
    }
}
