package no.hib.dat152.handleliste.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hib.dat152.handleliste.model.Handleliste;
import no.hib.dat152.handleliste.model.Vare;

/**
 * A dummy implementation of the HandlelisteDAO. This will create some dummy data.
 *
 * @author Lars-Petter Helland
 * @author Atle Geitung
 */
public final class HandlelisteDAODummy implements HandlelisteDAO {

    private final Map<Integer, Handleliste> handlelister = new HashMap<Integer, Handleliste>();

    private int sisteHandlelisteId = 0;
    private int sisteVareId = 0;

    // Singleton-greier
    private static HandlelisteDAODummy instance = null;

    /**
     * Gets the only single instance of this class.
     *
     * @return the instance
     */
    public static synchronized HandlelisteDAODummy getInstance() {
        if (instance == null) {
            instance = new HandlelisteDAODummy();
        }
        return instance;
    }

    /**
     * Constructs a new HandlelisteDAODummy. This class is a singleton and the constructors should be private.
     */
    private HandlelisteDAODummy() {
        // Starter med 2 handlelister, hver med 3 varer.

        List<Vare> varer = new ArrayList<Vare>();
        varer.add(new Vare(nesteVid(), "bananer", 2, "stk."));
        varer.add(new Vare(nesteVid(), "epler", 1, "kg"));
        varer.add(new Vare(nesteVid(), "melk", 3, "liter"));
        int hid = nesteHid();
        Handleliste handleliste = new Handleliste(hid, "Handleliste1");
        handleliste.setVarer(varer);
        handlelister.put(hid, handleliste);

        varer = new ArrayList<Vare>();
        varer.add(new Vare(nesteVid(), "strømper", 2, "par"));
        varer.add(new Vare(nesteVid(), "undikker", 1, "stk."));
        varer.add(new Vare(nesteVid(), "lue", 3, "stk."));
        hid = nesteHid();
        handleliste = new Handleliste(hid, "Handleliste2");
        handleliste.setVarer(varer);
        handlelister.put(hid, handleliste);
    }

    @Override
    public int opprettHandleliste(final String navn) {
        final int hid = nesteHid();
        final Handleliste handleliste = new Handleliste(hid, navn);
        handlelister.put(hid, handleliste);
        return hid;
    }

    @Override
    public int opprettVareIHandleliste(final int hid, final Vare vare) {
        final int vid = nesteVid();
        vare.setId(vid);
        finnHandleliste(hid).getVarer().add(vare);
        return vid;
    }

    @Override
    public List<Handleliste> finnAlleHandlelister() {
        return new ArrayList<Handleliste>(handlelister.values());
    }

    @Override
    public Handleliste finnHandleliste(final int hid) {
        return handlelister.get(hid);
    }

    @Override
    public List<Vare> finnAlleVarer(final int hid) {
        return finnHandleliste(hid).getVarer();
    }

    @Override
    public Vare finnVare(final int hid, final int vid) {
        final List<Vare> vareliste = finnHandleliste(hid).getVarer();
        final Vare vare = new Vare(vid);
        if (vareliste.contains(vare)) {
            return vareliste.get(vareliste.indexOf(vare));
        } else {
            return null;
        }
    }

    @Override
    public void oppdaterHandleliste(final int hid, final Handleliste handleliste) {
        handlelister.put(hid, handleliste);
    }

    @Override
    public void oppdaterVare(final int hid, final int vid, final Vare vare) {
        slettVare(hid, vid);
        opprettVareIHandleliste(hid, vare);
    }

    @Override
    public void slettHandleliste(final int hid) {
        handlelister.remove(hid);
    }

    @Override
    public void slettVare(final int hid, final int vid) {
        finnAlleVarer(hid).remove(new Vare(vid));
    }

    @Override
    public boolean finnesHandleliste(final int hid) {
        return handlelister.containsKey(hid);
    }

    @Override
    public boolean finnesVare(final int hid, final int vid) {
        return finnesHandleliste(hid) && finnHandleliste(hid).getVarer().contains(new Vare(vid));
    }

    /**
     * Generates the next shopping list id.
     *
     * @return next id
     */
    private int nesteHid() {
        return ++sisteHandlelisteId;
    }

    /**
     * Generates the next item id.
     *
     * @return next id
     */
    private int nesteVid() {
        return ++sisteVareId;
    }

}
