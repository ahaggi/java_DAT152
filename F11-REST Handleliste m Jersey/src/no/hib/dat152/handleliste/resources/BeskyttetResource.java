package no.hib.dat152.handleliste.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import no.hib.dat152.handleliste.util.AuthHelper;

/**
 * Implements a rest API for authentication. This is a separate example and is not directly in use by the handleliste.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
@Path("/beskyttet")
public class BeskyttetResource {

    private static final Logger LOGGER = Logger.getLogger(BeskyttetResource.class.getName());

    /**
     * Sample of authentication of an URI by using JAX-RS.
     *
     * @param authHeader the header
     * @return a response string
     */
    @GET
    @Produces("text/html")
    public final String hentHemmeligeData(@HeaderParam("Authorization") final String authHeader) {

        LOGGER.log(Level.INFO, authHeader);

        if (!AuthHelper.isAuthorized(authHeader)) {
            throw new WebApplicationException(Status.UNAUTHORIZED);
        } else {
            return "Du fikk tilgang til hemmelige data. :)";
        }
    }
}
