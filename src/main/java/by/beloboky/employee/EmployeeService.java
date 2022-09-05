package by.beloboky.employee;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EmployeeService {
    private final List<Employee> employees;

    public EmployeeService() {
        EmployeesAndDutiesFileRepository readFromFileEmployee = new EmployeesAndDutiesFileRepository();
        this.employees = readFromFileEmployee.readFromFileEmployees();
    }

    /**
     * @return all list of employee;
     */
    public List<Employee> returnFullEmployeeList() {
        return employees;
    }

    /**
     * @return Employee list with first and last names, and filtered by work experience from 3 years and salary from 1500.
     */
    public List<String> findEmployeeWithWorkExperienceMoreThanThreeYearAndSalaryMoreThanOneThousandFiveHundred() {
        return employees.stream().filter(s -> s.getWorkExperience() >= 3 && s.getSalary() >= 1500).map(str -> str.getFirstName() + " " + str.getLastName()).toList();
    }

    /**
     * @return List of Employee type which consists of manager objects and sorted by first name;
     */
    public List<Employee> findManagerAgeFromThirtyFiveToSixty() {
        return employees.stream().filter(s -> (s.getAge() >= 35 && s.getAge() <= 60) && Objects.equals(s.getPosition(), Position.MANAGER)).sorted(Comparator.comparing(Employee::getFirstName)).toList();
    }

    /**
     * @return List of Employee type which consists of five the first element and sorted by salary;
     */
    public List<Employee> sortFirstFiveSalaryOfEmployee() {
        return employees.stream().sorted(Comparator.comparing(Employee::getSalary)).limit(5).toList();
    }

    /**
     * @return int type, calculate all salary of security and multiply their by three.
     */
    public int calculateSumOfAllSecutiryAndMultiplyByThree() {
        return employees.stream().filter(s -> Objects.equals(s.getPosition(), Position.SECURITY)).map(s -> 3 * s.getSalary()).mapToInt(Integer::intValue).sum();
    }

    /**
     * @return List of String type, which consists of name and salary and filtered by work experience;
     */
    public List<String> findNameAndSalaryEmployeeWhichWorkingMoreThanSevenYears() {
        return employees.stream().filter(s -> s.getWorkExperience() >= 7).map(z -> z.getFirstName() + " " + z.getSalary()).toList();
    }

    /**
     * @return List of String type, which consists of duties for the day;
     */
    public List<String> findDutiesForTheDay() {
        return employees.stream().map(Employee::getDuties).flatMap(Collection::stream).filter(value -> {
                    LocalDate date = LocalDate.of(2022, 1, 3);
                    return Objects.equals(value.getDate(), date);
                }
        ).map(Duty::getDuty).toList();

    }

    /**
     * @return List of Employee type, which consists of employees who have less than two duties;
     */
    public List<Employee> findEmployeeWhichHaveLessThanTwoDutiesAndComparingByWorkExperience() {
        return employees.stream().filter(value -> value.getDutiesSize() <= 2).sorted(Comparator.comparing(Employee::getWorkExperience)).toList();
    }

    /**
     * @return List of Employee type, which consists of managers with having unique objects.
     */
    public List<Employee> findUniqueManagerEmployee() {
        return employees.stream().filter(s -> Objects.equals(s.getPosition(), Position.MANAGER)).collect(Collectors.toSet()).stream().toList();
    }

    /**
     * @return list of employee type, it consists of employees from 35 to 65 years old and skipping the first 5 employees;
     */
    public List<Employee> findEmployeeWhichHaveFromThirtyFiveToSixtyFiveAndSkipFirstFiveEmployee() {
        return employees.stream().filter(s -> s.getAge() >= 35 && s.getAge() <= 65).skip(5).toList();
    }

    /**
     * @return boolean type, are all employees over 18 years old.
     */
    public boolean areWhetherAllAreEighteenAge() {
        return employees.stream().allMatch(s -> s.getAge() >= 18);
    }

    /**
     * @return find Max, Min and Average values;
     */
    public IntSummaryStatistics getMaxMinAverageAge() {
        IntStream toIntStream = employees.stream().mapToInt(Employee::getAge);
        return toIntStream.summaryStatistics();
    }

    /**
     * @return list of  string type, including first and last names, work experience and sorting by age more than thirty years old;
     */
    public List<String> findFirstAndLastNameAndWorkExpEmployeeHasMoreThanThirtyAge() {
        return employees.stream().filter(s -> s.getAge() >= 30).map(s -> s.getFirstName() + " " + s.getLastName() + " " + s.getWorkExperience()).toList();
    }

    /**
     * @return Map, which includes employees over 18 years old, calculating sum of all employees by position.
     */
    public Map<Integer, Integer> findSumOfAllEmployeeByPosition() {
        return employees.stream().filter(s -> s.getAge() >= 18).collect(Collectors.toMap(Employee::getWorkExperience, Employee::getSalary, Integer::sum));
    }
}
