package by.beloboky.employee;

import java.util.List;

public class Employee {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Sex sex;
    private final Position position;
    private final int salary;
    private final int workExperience;
    private final List<Duty> duties;

    public Employee(String firstName, String lastName, Integer age, Sex sex, Position position, Integer salary, Integer workExperience, List<Duty> duties, Integer id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.position = position;
        this.salary = salary;
        this.workExperience = workExperience;
        this.duties = duties;
        this.id = id;
    }

    public List<Duty> getDuties() {
        return duties;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public Position getPosition() {
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
                ", name='" + firstName + '\'' +
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
