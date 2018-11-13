package model;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * Defines a comparetor for Employee-objects.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public class EmployeeComparator implements Comparator<Employee> {

    private Locale locale;

    /**
     * Creates a new EmployeeComparator with default locale.
     */
    public EmployeeComparator() {
        this.locale = Locale.getDefault();
    }

    /**
     * Creates a new EmployeeComparator.
     *
     * @param locale locale
     */
    public EmployeeComparator(final Locale locale) {
        this.locale = locale;
    }

    @Override
    public final int compare(final Employee employee1, final Employee employee2) {
        Collator col = Collator.getInstance(locale);
        return col.compare(employee1.getName(), employee2.getName());
    }

}
