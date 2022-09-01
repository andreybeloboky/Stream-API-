package by.beloboky.employee;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class EmployeeService {

    EmployeesAndDutiesFileRepository readFromFileEmployee;
    List<Employee> employees;

    public EmployeeService() {
        try {
            this.readFromFileEmployee = new EmployeesAndDutiesFileRepository();
            this.readFromFileEmployee.readFromFileDuties();
            this.employees = readFromFileEmployee.readFromFileEmployees();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterOnScreenAllList() {
        employees.forEach(System.out::println);
    }

    public List<String> getListWithSalaryAndExperienceLimit() {
        return employees.stream().filter(s -> s.getWorkExperience() >= 3 && s.getSalary() >= 1500).map(str -> str.getName() + " " + str.getLastName()).toList();
    }

    public List<Employee> getListOnlyManagerWithAgeLimit() {
        return employees.stream().filter(s -> (s.getAge() >= 35 && s.getAge() <= 60) && Objects.equals(s.getPosition(), "manager")).sorted(Comparator.comparing(Employee::getName)).toList();
    }

    public List<Employee> getListSalaryComparingWithLimitFirstFive() {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary)).limit(5).toList();
    }

    public int getIntegerOnlySumSecurity() {
        return employees.stream().filter(s -> Objects.equals(s.getPosition(), "security")).map(s -> 3 * s.getSalary()).mapToInt(Integer::intValue).sum();
    }

    public List<String> getListWithExperienceLimitAndConsistOnlyNameAndSalary() {
        return employees.stream().filter(s -> s.getWorkExperience() >= 7).map(z -> z.getName() + " " + z.getSalary()).toList();
    }

    public List<String> getListCurtainDate(List<Duty> dutiesForEmployee) {
        return dutiesForEmployee.stream().filter(value -> {
                    LocalDate date = LocalDate.parse("03/01/2022", EmployeesAndDutiesFileRepository.FORMATTER);
                    return Objects.equals(value.getDateTime(), date);
                }
        ).map(Duty::getDuties).toList();
    }

    public List<Employee> getListDutyLimitAndComparing() {
        return employees.stream().filter(value -> value.getDutiesSize() <= 2).sorted(Comparator.comparing(Employee::getWorkExperience)).toList();
    }

    public List<Employee> getListOnlyManagerAndUnique() {
        return employees.stream().filter(s -> Objects.equals(s.getPosition(), "manager")).collect(Collectors.toSet()).stream().toList();
    }

    public List<Employee> getListAgeFrom35To65AndSkipFirstFive() {
        return employees.stream().filter(s -> s.getAge() >= 35 && s.getAge() <= 65).skip(5).toList();
    }

    public boolean getBooleanIfAllAgeEmployeeOlderThanEighteen() {
        return employees.stream().allMatch(s -> s.getAge() >= 18);
    }

    public Optional<Employee> getMaxAge() {
        return employees.stream().max(comparingInt(Employee::getAge));
    }

    public Optional<Employee> getMinAge() {
        return employees.stream().min(comparingInt(Employee::getAge));
    }

    public OptionalDouble getAverageAge() {
        return employees.stream().mapToInt(Employee::getAge).average();
    }

    public List<String> getListHaveOnlyEmployeeOlderThanThirty() {
        return employees.stream().filter(s -> s.getAge() >= 30).map(s -> s.getName() + " " + s.getLastName() + " " + s.getWorkExperience()).toList();
    }

    public Map<Integer, Integer> getMapSumOfAllEmployeeByPosition() {
        return employees.stream().filter(s -> s.getAge() >= 18).collect(Collectors.toMap(Employee::getWorkExperience, Employee::getSalary, Integer::sum));
    }
}
