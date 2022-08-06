package br.com.course.common;

public class Employee {
    
    private int id;
    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
            "{id: %s, firstName: %s, lastName: %s}",
            String.valueOf(id),
            firstName,
            lastName);
    }

    @Override
    public boolean equals(Object arg0) {
        Employee param = (Employee) arg0;
        return this.id == param.id &&
            this.firstName.equals(param.firstName) &&
            this.lastName.equals(param.lastName);
    }
}
