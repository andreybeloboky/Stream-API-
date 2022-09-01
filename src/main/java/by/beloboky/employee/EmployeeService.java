package by.beloboky.employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import static java.util.Comparator.comparingInt;

public class EmployeeService {

    FileRepositoryOfEmployeesAndDuties read = new FileRepositoryOfEmployeesAndDuties();
    List<Employee> employees;

    public EmployeeService() throws IOException {
        this.employees = read.readFromFileEmployees();
    }

    public void getTaskOne() {
        employees.forEach(System.out::println);
    }

    public List<String> getTaskTwo() {
        return employees.stream().filter(s -> s.getWorkExperience() >= 3 && s.getSalary() >= 1500).map(str -> str.getName() + " " + str.getLastName()).toList();
    }

    public List<Employee> getTaskThree() {
        return employees.stream().filter(s -> (s.getAge() >= 35 && s.getAge() <= 60) && Objects.equals(s.getPosition(), "manager")).sorted(Comparator.comparing(Employee::getName)).toList();
    }

    public List<Employee> getTaskFour() {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary)).limit(5).toList();
    }

    public int getTaskFive() {
        return employees.stream().filter(s -> Objects.equals(s.getPosition(), "security")).map(s -> 3 * s.getSalary()).mapToInt(Integer::intValue).sum();
    }

    public List<String> getTaskSix() {
        return employees.stream().filter(s -> s.getWorkExperience() >= 7).map(z -> z.getName() + " " + z.getSalary()).toList();
    }

    public List<String> getTaskSeven(List<Duties> dutiesForEmployee) {
        return dutiesForEmployee.stream().filter(value -> {
                    LocalDate date = LocalDate.parse("03/01/2022", FileRepositoryOfEmployeesAndDuties.FORMATTER);
                    return Objects.equals(value.getDateTime(), date);
                }
        ).map(Duties::getDuties).toList();
    }

    public List<Employee> getTaskEight() {
        return employees.stream().filter(value -> value.getDutiesSize() <= 2).sorted(Comparator.comparing(Employee::getWorkExperience)).toList();
    }

    public List<Employee> getTaskNine() {
        return employees.stream().filter(s -> Objects.equals(s.getPosition(), "manager")).collect(Collectors.toSet()).stream().toList();
    }

    public List<Employee> getTaskTen() {
        return employees.stream().filter(s -> s.getAge() >= 35 && s.getAge() <= 65).skip(5).toList();
    }

    public boolean getTaskEleven() {
        return employees.stream().allMatch(s -> s.getAge() >= 18);
    }

    public Optional<Employee> getMax() {
        return employees.stream().max(comparingInt(Employee::getAge));
    }

    public Optional<Employee> getMin() {
        return employees.stream().min(comparingInt(Employee::getAge));
    }

    public double getAvg() {
        return employees.stream().collect(Collectors.averagingInt(Employee::getAge));
    }

    public List<String> getTaskThirteen() {
        return employees.stream().filter(s -> s.getAge() >= 30).map(s -> s.getName() + " " + s.getLastName() + " " + s.getWorkExperience()).toList();
    }

    public Map<Integer, Integer> getTaskFourteen() {
        return employees.stream().filter(s -> s.getAge() >= 18).collect(Collectors.toMap(Employee::getWorkExperience, Employee::getSalary, Integer::sum));
    }
}
