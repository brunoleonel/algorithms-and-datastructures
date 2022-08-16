package br.com.course.common;

public class KeyValueEmployee {
    
    private String key;
    private Employee employee;
    
    public KeyValueEmployee(String key, Employee employee) {
        this.key = key;
        this.employee = employee;
    }

    public String getKey() {
        return key;
    }

    public Employee getEmployee() {
        return employee;
    }
}
