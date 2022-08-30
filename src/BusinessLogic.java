import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class BusinessLogic {
    List<Employee> employees;

    public BusinessLogic(List<Employee> emp) throws IOException {
        this.employees = emp;
    }

    public void getTaskOne() {
        employees.forEach(System.out::println);
    }

    public List<String> getTaskTwo() {
        return employees.stream().filter(s -> s.getWorkExperience() >= 3 && s.getSalary() >= 1500).sorted(new ComparatorEmployees()).map(str -> str.getName() + " " + str.getLastName()).toList();
    }

    public List<Employee> getTaskThree() {
        return employees.stream().filter(s -> (s.getAge() >= 35 && s.getAge() <= 60) && Objects.equals(s.getPosition(), "manager")).sorted(new ComparatorEmployees()).toList();
    }
    //taskThree.forEach(s -> System.out.println(s.getName() + " " + s.getLastName() + " " + s.getAge()));

    public List<Employee> getTaskFour() {
        return employees.stream().sorted(Employee::compareTo).limit(5).toList();
    }
    //taskFour.forEach(System.out::println);

    public int getTaskFive() {
        return employees.stream().filter(s -> Objects.equals(s.getPosition(), "security")).map(s -> 3 * s.getSalary()).mapToInt(Integer::intValue).sum();
    }
    //System.out.println(taskFive);

    public List<String> getTaskSix() {
        return employees.stream().filter(s -> s.getWorkExperience() >= 7).map(z -> z.getName() + " " + z.getSalary()).toList();
    }
    //taskSeven.forEach(System.out::println);

    public List<String> getTaskSeven(List<Duties> dutiesForEmployee) {
        return dutiesForEmployee.stream().filter(value -> {
                    LocalDate date = LocalDate.parse("03/01/2022", ReadFromFile.FORMATTER);
                    return Objects.equals(value.getDateTime(), date);
                }
        ).map(Duties::getDuties).toList();
    }
    //taskSeven.forEach(System.out::println);

    public List<Employee> getTaskEight() {
        return employees.stream().filter(value -> value.getDutiesSize() <= 2).sorted(new ComparatorWorkExperience()).toList();
    }
    //taskEight.forEach(System.out::println);

    public List<Employee> getTaskNine() {
        return employees.stream().filter(s -> Objects.equals(s.getPosition(), "manager")).collect(Collectors.toSet()).stream().toList();
    }
    //taskNine.forEach(System.out::println);

    public List<Employee> getTaskTen() {
        return employees.stream().filter(s -> s.getAge() >= 35 && s.getAge() <= 65).skip(5).toList();
    }
    //taskTen.forEach(System.out::println);

    public boolean getTaskEleven() {
        return employees.stream().allMatch(s -> s.getAge() >= 18);
    }
    //System.out.println(taskEleven);

    public Optional<Employee> getMax() {
        return employees.stream().max(comparingInt(Employee::getAge));
    }
    //System.out.println(max);

    public Optional<Employee> getMin() {
        return employees.stream().min(comparingInt(Employee::getAge));
    }

    //System.out.println(min);
    public double getAvg() {
        return employees.stream().collect(Collectors.averagingInt(Employee::getAge));
    }

    public List<String> getTaskThirteen() {
        return employees.stream().filter(s -> s.getAge() >= 30).map(s -> s.getName() + " " + s.getLastName() + " " + s.getWorkExperience()).toList();
    }
    //taskThirteen.forEach(System.out::println);

    public Map<Integer, Integer> getTaskFourteen() {
        return employees.stream().filter(s -> s.getAge() >= 18).collect(Collectors.toMap(Employee::getWorkExperience, Employee::getSalary, Integer::sum));
    }

    /*for (Map.Entry entry : taskFourteen.entrySet()) {
        System.out.println(entry.getKey() + " " + entry.getValue());
    }
     */
    public static class ComparatorEmployees implements Comparator<Employee> {
        /**
         * @param a the first object to be compared.
         * @param b the second object to be compared.
         * @return sorting (int value).
         */
        public int compare(Employee a, Employee b) {

            return a.getName().compareTo(b.getName());
        }
    }

    public static class ComparatorWorkExperience implements Comparator<Employee> {
        /**
         * @param a the first object to be compared.
         * @param b the second object to be compared.
         * @return sorting (int value).
         */
        public int compare(Employee a, Employee b) {

            return a.getWorkExperience() - b.getWorkExperience();
        }
    }
}
