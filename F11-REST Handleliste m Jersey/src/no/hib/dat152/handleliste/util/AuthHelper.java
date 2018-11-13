package no.hib.dat152.handleliste.util;

import org.apache.tomcat.util.codec.binary.Base64;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

/**
 * An helper class that shows how authentication clould be done.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public final class AuthHelper {

    private static final String HARDCODED_USER = "lars-petter";
    private static final String HARDCODED_PASS = "helland";

    /**
     * Hides the constructor for this class.
     */
    private AuthHelper() {
    }

    /**
     * Return true if the header contains the correct information about the user.
     *
     * @param authHeader the header
     * @return true if authenticated
     */
    public static boolean isAuthorized(final String authHeader) {

        try {
            final String[] userPass = userPassFromAuthHeader(authHeader);

            return userPass[0].equals(HARDCODED_USER) && userPass[1].equals(HARDCODED_PASS);

        } catch (Base64DecodingException e) {
            return false;
        } catch (final NullPointerException e) {
            return false;
        }
    }

    /**
     * Utility method for authentication. It gets the password from the header.
     *
     * @param authHeader header
     * @return password
     * @throws Base64DecodingException if the decoding failed
     */
    private static String[] userPassFromAuthHeader(final String authHeader) throws Base64DecodingException {

        if (authHeader == null || !authHeader.startsWith("Basic")) {
            return null;
        }

        String header = authHeader;
        header = authHeader.split(" ")[1]; // Extract the credentials-part
        final String credentials = new String(new Base64().decode(header));

        final String[] userPass = credentials.split(":");
        if (userPass.length != 2) {
            return null;
        }

        return userPass;
    }
}
