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

    private static final String FILE_DUTIES = "duties_with_data.csv";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final File file;
    private final File fileDuties;

    public EmployeesAndDutiesFileRepository() {
        this.file = new File(FILE_EMPLOYEE);
        this.fileDuties = new File(FILE_DUTIES);
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
     * @return The List includes duties.
     */
    public List<Duty> readFromFileDuties() {
        try {
            return Files.lines(fileDuties.toPath(), StandardCharsets.UTF_8).map(EmployeesAndDutiesFileRepository::convertToDuties).toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * @param s is string from duties_with_data file.
     * @return Duties object
     */
    private static Duty convertToDuties(String s) {
        String[] find = s.split(",");
        LocalDate date = LocalDate.parse(find[1], FORMATTER);
        int currentID = Integer.parseInt(find[0]);
        return new Duty(currentID, date, find[2]);
    }

    /**
     * @param s is string from data_users file.
     * @return Employee object
     */
    private static Employee convertToEmployee(String s) throws NotFoundEmployeeException {
        String[] find = s.split(",");
        int age = Integer.parseInt(find[2]);
        int salary = Integer.parseInt(find[5]);
        int workExp = Integer.parseInt(find[6]);
        int id = Integer.parseInt(find[7]);
        List<Duty> forEachEmployee = findDutyForEmployee(id);
        Position position = isEmployeePosition(find);
        Sex sex = isEmployeeSex(find);
        return new Employee(find[0], find[1], age, sex, position, salary, workExp, forEachEmployee, id);
    }

    /**
     * @param find - take a string with employee's position.
     * @return Position type, what the employee's position is.
     */
    private static Position isEmployeePosition(String[] find) throws NotFoundEmployeeException {
        if (Objects.equals(find[4], "manager")) {
            return Position.MANAGER;
        } else if (Objects.equals(find[4], "employee")) {
            return Position.EMPLOYEE;
        } else if (Objects.equals(find[4], "security")) {
            return Position.SECURITY;
        } else if (Objects.equals(find[4], "director")) {
            return Position.DIRECTOR;
        } else {
            throw new NotFoundEmployeeException("Not found position");
        }
    }

    /**
     * @param find - take a string with employee's sex.
     * @return Sex that the employee has.
     */
    private static Sex isEmployeeSex(String[] find) throws NotFoundEmployeeException {
        if (Objects.equals(find[3], "M") || Objects.equals(find[3], "F")) {
            return Objects.equals(find[3], "M") ? Sex.MALE : Sex.FEMALE;
        } else {
            throw new NotFoundEmployeeException("Not found position");
        }
    }

    /**
     * @param id - id employee;
     * @return List Duty type of each employees;
     */
    private static List<Duty> findDutyForEmployee(int id) {
        List<Duty> forEachEmployee = new LinkedList<>();
        EmployeesAndDutiesFileRepository takeDutyList = new EmployeesAndDutiesFileRepository();
        List<Duty> dutiesForEmployee = takeDutyList.readFromFileDuties();
        for (Duty duties : dutiesForEmployee) {
            if (duties.getID() == id) {
                forEachEmployee.add(duties);
            }
        }
        return forEachEmployee;
    }
}
