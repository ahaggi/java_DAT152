package model;

/**
 * A class that defines an employee.
 *
 * @author Atle Geitung
 * @author Lars-Petter Helland
 */
public class Employee {

    private String name;
    private Double salary;

    /**
     * Creates a new instance of Employee.
     *
     * @param name name
     * @param salary salary
     */
    public Employee(final String name, final Double salary) {
        this.name = name;
        this.salary = salary;
    }

    /**
     * Returns the name.
     *
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name new name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Returns the salary.
     *
     * @return salary
     */
    public final Double getSalary() {
        return salary;
    }

    /**
     * Sets the salary.
     *
     * @param salary new salary
     */
    public final void setSalary(final Double salary) {
        this.salary = salary;
    }

}
