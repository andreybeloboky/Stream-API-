package by.beloboky.employee;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class EmployeesAndDutiesFileRepository {

    private static final String FILE_EMPLOYEE = "data_users.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final File file;

    public EmployeesAndDutiesFileRepository() {
        this.file = new File(FILE_EMPLOYEE);
    }

    /**
     * @return The List includes employees.
     */
    public List<Employee> readFromFileEmployees() {
        try {
            return Files.lines(file.toPath(), StandardCharsets.UTF_8).map(EmployeesAndDutiesFileRepository::convertToEmployee).toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * @param s is string from duties_with_data file.
     * @return Duties object
     */
    private static Duty convertToDuties(String s) {
        String[] employeeAttributes = s.split(",");
        LocalDate date = LocalDate.parse(employeeAttributes[1], FORMATTER);
        int currentID = Integer.parseInt(employeeAttributes[0]);
        return new Duty(currentID, date, employeeAttributes[2]);
    }

    /**
     * @param s is string from data_users file.
     * @return Employee object
     */
    private static Employee convertToEmployee(String s) {
        String[] find = s.split(",");
        int age = Integer.parseInt(find[2]);
        int salary = Integer.parseInt(find[5]);
        int workExp = Integer.parseInt(find[6]);
        int id = Integer.parseInt(find[7]);
        List<Duty> forEachEmployee = findDutyForEmployee(id);
        Position position = findEmployeePosition(find);
        Sex sex = findEmployeeSex(find);
        return new Employee(find[0], find[1], age, sex, position, salary, workExp, forEachEmployee, id);
    }

    /**
     * @param find - take a string with employee's position.
     * @return Position type, what the employee's position is.
     */
    private static Position findEmployeePosition(String[] find) {
        switch (find[4]) {
            case "manager" -> {
                return Position.MANAGER;
            }
            case "security" -> {
                return Position.SECURITY;
            }
            case "director" -> {
                return Position.DIRECTOR;
            }
            case "employee" -> {
                return Position.EMPLOYEE;
            }
            default ->
                    throw new NotFoundEmployeeException(String.format("Type %s is not a valid position. Please check you file", find[4]));
        }
    }

    /**
     * @param find - take a string with employee's sex.
     * @return Sex that the employee has.
     */
    private static Sex findEmployeeSex(String[] find) {
        if (Objects.equals(find[3], "M") || Objects.equals(find[3], "W")) {
            return Objects.equals(find[3], "M") ? Sex.MALE : Sex.FEMALE;
        } else {
            throw new NotFoundEmployeeException(String.format("Type %s is not a valid position. Please check you file", find[3]));
        }
    }

    /**
     * @param id - id employee;
     * @return List Duty type of each employees;
     */
    private static List<Duty> findDutyForEmployee(int id) {
        List<Duty> forEachEmployee = new LinkedList<>();
        File fileDuties = new File("duties_with_data.csv");
        try {
            List<Duty> dutiesForEmployee = Files.lines(fileDuties.toPath(), StandardCharsets.UTF_8).map(EmployeesAndDutiesFileRepository::convertToDuties).toList();
            for (Duty duties : dutiesForEmployee) {
                if (duties.getID() == id) {
                    forEachEmployee.add(duties);
                }
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return forEachEmployee;
    }
}
