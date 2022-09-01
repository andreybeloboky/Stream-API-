package by.beloboky.employee;

import java.util.List;

public class Employee {

    private final int id;
    private final String name;
    private final String lastName;
    private final int age;
    private final String sex;
    private final String position;
    private final int salary;
    private final int workExperience;
    private final List<Duty> duties;

    public Employee(String name, String lastName, Integer age, String sex, String position, Integer salary, Integer workExperience, List<Duty> duties, Integer id) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.position = position;
        this.salary = salary;
        this.workExperience = workExperience;
        this.duties = duties;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public int getWorkExperience() {
        return workExperience;
    }
    public int getDutiesSize() {
        return duties.size();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", workExperience=" + workExperience +
                ", duties=" + duties +
                '}';
    }
}
