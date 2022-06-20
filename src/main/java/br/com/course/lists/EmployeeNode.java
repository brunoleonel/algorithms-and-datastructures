package br.com.course.lists;

public class EmployeeNode {
    
    private Employee employee;
    private EmployeeNode next;

    public EmployeeNode(Employee node) {
        this.employee = node;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee node) {
        this.employee = node;
    }

    public EmployeeNode getNext() {
        return this.next;
    }

    public void setNext(EmployeeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return this.employee.toString();
    }
}
