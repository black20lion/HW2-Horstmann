package ru.mycompany.thirdchapter;

public class Employee implements Measurable {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        assert (salary >= 0) : "Salary can not be negative";
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getMeasure() {
        return salary;
    }
}
