package no.hib.dat152.handleliste.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import no.hib.dat152.handleliste.model.Handleliste;
import no.hib.dat152.handleliste.model.Vare;
import no.hib.dat152.handleliste.persistence.HandlelisteDAO;
import no.hib.dat152.handleliste.persistence.HandlelisteDAODummy;

/**
 * Implements a rest service for the handleliste. This is using JAX-RS and the annotations defines how the methods
 * should be interpreted.
 *
 * The following API will be implemented: 
 * +------------------------------+-----+------+-----+------+ 
 * |URL                           | GET | POST | PUT |DELETE| 
 * +------------------------------+-----+------+-----+------+ 
 * |/handleliste                  |  V  |   V  |  X  |   X  |
 * |/handleliste/{hid}            |  V  |   X  |  V  |   V  | 
 * |/handleliste/{hid}/vare       |  V  |   V  |  X  |   X  | 
 * |/handleliste/{hid}/vare/{vid} |  V  |   X  |  V  |   V  | 
 * +------------------------------+-----+------+-----+------+
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
@Path("/handleliste")
@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
public class HandlelisteResource {

    private final HandlelisteDAO dao = HandlelisteDAODummy.getInstance();

    /**
     * Read all shopping lists. Implements GET /handleliste.
     *
     * @return All shopping lists
     */
    @GET
    public final List<Handleliste> hentAlleHandlelister() {
        return dao.finnAlleHandlelister();
    }

    /**
     * Creates a new shopping list. Implements POST /handleliste.
     *
     * @param handleliste the new shopping list
     * @return id of the new shopping list
     */
    @POST
    public final Response opprettHandleliste(final Handleliste handleliste) {
        final int hid = dao.opprettHandleliste(handleliste.getNavn());
        return Response.created(URI.create("/" + hid)).build();
    }

    /**
     * Reads the shopping list identified by hid. Implements GET /handleliste/{hid}.
     *
     * @param hid Id of the shopping list
     * @return the shopping list
     */
    @GET
    @Path("{hid}")
    public final Handleliste hentHandleliste(@PathParam("hid") final int hid) {
        if (!dao.finnesHandleliste(hid)) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return dao.finnHandleliste(hid);
    }

    /**
     * Updates the shopping list identified by hid. Implements PUT /handleliste/{hid}.
     *
     * @param hid Id of the shopping list
     * @param handleliste the updated shopping list
     */
    @PUT
    @Path("{hid}")
    public final void oppdaterHandleliste(@PathParam("hid") final int hid, final Handleliste handleliste) {
        if (!dao.finnesHandleliste(hid)) {
            throw new WebApplicationException(Status.FORBIDDEN);
        }
        dao.oppdaterHandleliste(hid, handleliste);
        // return Response.noContent().build(); DENNE ER DAFAULT VED void
    }

    /**
     * Deletes the shopping list identified by hid. Implements DELETE /handleliste/{hid}.
     *
     * @param hid Id of the shopping list
     */
    @DELETE
    @Path("{hid}")
    public final void slettHandleliste(@PathParam("hid") final int hid) {
        if (!dao.finnesHandleliste(hid)) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        dao.slettHandleliste(hid);
        // return Response.noContent().build(); DENNE ER DAFAULT VED void
    }

    /**
     * Reads all items from the shopping list identified by hid. Implements GET /handleliste/{hid}/vare.
     *
     * @param hid Id of the shopping list.
     * @return a list of items
     */
    @GET
    @Path("{hid}/vare")
    public final List<Vare> hentVareliste(@PathParam("hid") final int hid) {
        if (dao.finnAlleVarer(hid) == null) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return dao.finnAlleVarer(hid);
    }

    /**
     * Creates a new item into a shopping list. Implements POST /handleliste/{hid}/vare.
     *
     * @param hid Id of the shopping list
     * @param vare The new item to be added
     * @return id of the new item
     */
    @POST
    @Path("{hid}/vare")
    public final Response leggTilNyVare(@PathParam("hid") final int hid, final Vare vare) {
        if (!dao.finnesHandleliste(hid)) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        final int vid = dao.opprettVareIHandleliste(hid, vare);
        return Response.created(URI.create("/vare/" + vid)).build();
    }

    /**
     * Read an item from a shopping list. Implements GET /handleliste/{hid}/vare/{vid}.
     *
     * @param hid Id of the shopping list
     * @param vid Id of the item
     * @return the item identified by vid in hid
     */
    @GET
    @Path("{hid}/vare/{vid}")
    public final Vare hentVare(@PathParam("hid") final int hid, @PathParam("vid") final int vid) {
        if (!dao.finnesVare(hid, vid)) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        return dao.finnVare(hid, vid);
    }

    /**
     * Update an item in a shopping list. Implements PUT /handleliste/{hid}/vare/{vid}.
     *
     * @param hid Id of the shopping list
     * @param vid Id of the item
     * @param vare the updated item
     */
    @PUT
    @Path("{hid}/vare/{vid}")
    public final void oppdaterVare(@PathParam("hid") final int hid, @PathParam("vid") final int vid, final Vare vare) {
        if (!dao.finnesVare(hid, vid)) {
            throw new WebApplicationException(Status.FORBIDDEN);
        }
        dao.oppdaterVare(hid, vid, vare);
        // return Response.noContent().build(); DENNE ER DAFAULT VED void
    }

    /**
     * Deletes an item from a shopping list. Implements DELETE /handleliste/{hid}/vare/{vid}.
     *
     * @param hid Id of the shopping list
     * @param vid Id of the item
     */
    @DELETE
    @Path("{hid}/vare/{vid}")
    public final void slettVare(@PathParam("hid") final int hid, @PathParam("vid") final int vid) {
        if (!dao.finnesHandleliste(hid)) {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
        dao.slettVare(hid, vid);
        // return Response.noContent().build(); DENNE ER DAFAULT VED void
    }
}
