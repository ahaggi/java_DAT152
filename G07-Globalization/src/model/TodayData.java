package model;

/**
 * Helper that returns today's date.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public final class TodayData {

    private static final int MAX_TEMP = 294;

    /**
     * No instaces are allowed.
     */
    private TodayData() {
    }

    /**
     * Returns maximum temperature for today in kelvin.
     *
     * @return max temperature
     */
    public static double getMaxTemp() {
        return MAX_TEMP;
    }

}
