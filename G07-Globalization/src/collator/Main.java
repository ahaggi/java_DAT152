package collator;

import java.text.Collator;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

import model.Employee;
import model.EmployeeComparator;

/**
 * The main app.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public final class Main {

    /**
     * The main app.
     *
     * @param args Not used.
     */
    public static void main(final String[] args) {

        Employee[] employees = { new Employee("Nilsen   ", 34567.00), new Employee("Ytrebygd ", 35567.00),
                new Employee("Aaseb�   ", 36567.00), new Employee("�vreb�   ", 32567.00), new Employee("Abelsen  ", 38567.00),
                new Employee("�lvik    ", 30567.00) };

        Locale locale = new Locale("en", "US");
//        Locale locale = new Locale("nb", "NO");

        
        
        EmployeeComparator comp = new EmployeeComparator(locale);
        Arrays.sort(employees, comp);

        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);

        System.out.println("Name\t\tSalary");
        System.out.println("----------------------------");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " " + formatter.format(employee.getSalary()));
        }
        
        
        System.out.println("\n****************************************************************\n\n");

        
        Locale locale2 = new Locale("no", "NO");

        Collator cl = Collator.getInstance(locale2);

        
		
		System.out.println("NO \"Xx\".compareTo(\"Aa\"): " + "Xx".compareTo("Aa"));
		System.out.println("NO cl.compare(\"Xx\", \"Aa\") : "+ cl.compare("Xx", "Aa"));
		
        locale2 = new Locale("en", "US");
        cl = Collator.getInstance(locale2);

		System.out.println("EN \"Xx\".compareTo(\"Aa\"): " + "Xx".compareTo("Aa"));
		System.out.println("EN cl.compare(\"Xx\", \"Aa\") : " + cl.compare("Xx", "Aa"));


    }

}
