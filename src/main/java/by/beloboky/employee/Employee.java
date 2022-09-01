package by.beloboky.employee;

import java.util.List;

public class Employee {

    private final int ID;
    private final String name;
    private final String lastName;
    private final int age;
    private final String sex;
    private final String position;
    private final int salary;
    private final int workExperience;
    private final List<Duties> duties;

    public Employee(String name, String lastName, Integer age, String sex, String position, Integer salary, Integer workExperience, List<Duties> duties, Integer ID) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.position = position;
        this.salary = salary;
        this.workExperience = workExperience;
        this.duties = duties;
        this.ID = ID;
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

    public int getID() {
        return ID;
    }

    public List<Duties> getDuties() {
        return duties;
    }

    public int getDutiesSize() {
        return duties.size();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
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
