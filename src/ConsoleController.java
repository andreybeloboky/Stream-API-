import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;


public class ConsoleController {
    private static final File file = new File("data_users.csv");
    private static final File file_duties = new File("duties_with_data.csv");
    private static List<Duties> dutiesForEmployee = new LinkedList<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) throws IOException {
        dutiesForEmployee = ConsoleController.readFromFileDuties();
        List<Employee> employees = ConsoleController.readFromFileEmployees();
        //employees.forEach(System.out::println);

        // 1 task
        //employees.forEach(System.out::println);
        //employees.stream().forEach(System.out::println);

        // 2 task
        List<String> taskTwo = employees.stream().filter(s -> s.getWorkExperience() >= 3 && s.getSalary() >= 1500).sorted(new ComparatorEmployees()).map(str -> str.getName() + " " + str.getLastName()).toList();
        //taskTwo.forEach(System.out::println);

        // 3 task
        List<Employee> taskThree = employees.stream().filter(s -> (s.getAge() >= 35 && s.getAge() <= 60) && Objects.equals(s.getPosition(), "manager")).sorted(new ComparatorEmployees()).toList();
        //taskThree.forEach(s -> System.out.println(s.getName() + " " + s.getLastName() + " " + s.getAge()));

        // 4 task
        List<Employee> taskFour = employees.stream().sorted(Employee::compareTo).limit(5).toList();
        //taskFour.forEach(System.out::println);

        // 5 task
        int taskFive = employees.stream().filter(s -> Objects.equals(s.getPosition(), "security")).map(s -> 3 * s.getSalary()).mapToInt(Integer::intValue).sum();
        //System.out.println(taskFive);

        // 6 task
        List<String> taskSix = employees.stream().filter(s -> s.getWorkExperience() >= 7).map(z -> z.getName() + " " + z.getSalary()).toList();
        //taskSeven.forEach(System.out::println);

        // 7 task
        List<String> taskSeven = dutiesForEmployee.stream().filter(value -> {
                    LocalDate date = LocalDate.parse("03/01/2022", FORMATTER);
                    return Objects.equals(value.getDateTime(), date);
                }
        ).map(Duties::getDuties).toList();
        //taskSeven.forEach(System.out::println);

        // 8 task
        List<Employee> taskEight = employees.stream().filter(value -> value.getDutiesSize() <= 2).sorted(new ComparatorWorkExperience()).toList();
        //taskEight.forEach(System.out::println);

        // 9 task
        List<Employee> taskNine = employees.stream().filter(s -> Objects.equals(s.getPosition(), "manager")).collect(Collectors.toSet()).stream().toList();
        //taskNine.forEach(System.out::println);

        // 10 task
        List<Employee> taskTen = employees.stream().filter(s -> s.getAge() >= 35 && s.getAge() <= 65).skip(5).toList();
        //taskTen.forEach(System.out::println);

        // 11 task
        boolean taskEleven = employees.stream().allMatch(s -> s.getAge() >= 18);
        //System.out.println(taskEleven);

        // 12 task
        Optional<Employee> max = employees.stream().max(comparingInt(Employee::getAge));
        //System.out.println(max);
        Optional<Employee> min = employees.stream().min(comparingInt(Employee::getAge));
        //System.out.println(min);
        double avg = employees.stream().collect(Collectors.averagingInt(Employee::getAge));

        // 13 task
        List<String> taskThirteen = employees.stream().filter(s -> s.getAge() >= 30).map(s -> s.getName() + " " + s.getLastName() + " " + s.getWorkExperience()).toList();
        //taskThirteen.forEach(System.out::println);

        // 14 task
        Map<Integer, Integer> taskFourteen = employees.stream().filter(s -> s.getAge() >= 18).collect(Collectors.toMap(Employee::getWorkExperience, Employee::getSalary, Integer::sum));
        /*for (Map.Entry entry : taskFourteen.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
         */
    }

    static class ComparatorEmployees implements Comparator<Employee> {
        /**
         * @param a the first object to be compared.
         * @param b the second object to be compared.
         * @return sorting (int value).
         */
        public int compare(Employee a, Employee b) {

            return a.getName().compareTo(b.getName());
        }
    }

    static class ComparatorWorkExperience implements Comparator<Employee> {
        /**
         * @param a the first object to be compared.
         * @param b the second object to be compared.
         * @return sorting (int value).
         */
        public int compare(Employee a, Employee b) {

            return a.getWorkExperience() - b.getWorkExperience();
        }
    }

    /**
     * @return The List includes employees.
     * @throws IOException unchecked exception.
     */
    public static List<Employee> readFromFileEmployees() throws IOException {
        return Files.lines(file.toPath()).map(ConsoleController::convertToEmployee).toList();
    }

    /**
     * @return The List includes duties.
     * @throws IOException  unchecked exception.
     */
    public static List<Duties> readFromFileDuties() throws IOException {
        return Files.lines(file_duties.toPath()).map(ConsoleController::convertToDuties).toList();
    }

    /**
     * @param s is string from duties_with_data file.
     * @return Duties object
     */
    private static Duties convertToDuties(String s) {
        String[] find = s.split(",");
        LocalDate date = LocalDate.parse(find[1], FORMATTER);
        int currentID = Integer.parseInt(find[0]);
        return new Duties(currentID, date, find[2]);
    }

    /**
     * @param s is string from data_users file.
     * @return Employee object
     */
    private static Employee convertToEmployee(String s) {
        String[] find = s.split(",");
        int i = Integer.parseInt(find[2]);
        int j = Integer.parseInt(find[5]);
        int k = Integer.parseInt(find[6]);
        int ID = Integer.parseInt(find[7]);
        List<Duties> forEachEmployee = new LinkedList<>();
        for (Duties duties : dutiesForEmployee) {
            if (duties.getID() == ID) {
                forEachEmployee.add(duties);
            }
        }
        return new Employee(find[0], find[1], i, find[3], find[4], j, k, forEachEmployee, ID);
    }
}
