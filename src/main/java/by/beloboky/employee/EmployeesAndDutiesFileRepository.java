package by.beloboky.employee;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
            return Files.lines(file.toPath()).map(EmployeesAndDutiesFileRepository::convertToEmployee).toList();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * @return The List includes duties.
     */
    public List<Duty> readFromFileDuties() {
        try {
            return Files.lines(fileDuties.toPath()).map(EmployeesAndDutiesFileRepository::convertToDuties).toList();
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
    private static Employee convertToEmployee(String s) {
        EmployeesAndDutiesFileRepository e = new EmployeesAndDutiesFileRepository();
        List<Duty> dutiesForEmployee = e.readFromFileDuties();
        String[] find = s.split(",");
        int age = Integer.parseInt(find[2]);
        int salary = Integer.parseInt(find[5]);
        int workExp = Integer.parseInt(find[6]);
        int id = Integer.parseInt(find[7]);
        List<Duty> forEachEmployee = new LinkedList<>();
        for (Duty duties : dutiesForEmployee) {
            if (duties.getID() == id) {
                forEachEmployee.add(duties);
            }
        }
        Position position;
        if (Objects.equals(find[4], "manager")){
            position = Position.MANAGER;
        } else if (Objects.equals(find[4], "employee")) {
            position = Position.EMPLOYEE;
        } else if (Objects.equals(find[4], "security")) {
            position = Position.SECURITY;
        } else{
            position = Position.DIRECTOR;
        }
        return new Employee(find[0], find[1], age, Objects.equals(find[3], "M") ? Sex.MALE : Sex.FEMALE, position, salary, workExp, forEachEmployee, id);
    }
}
