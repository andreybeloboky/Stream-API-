package by.beloboky.employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class EmployeesAndDutiesFileRepository {

    private final File file;
    private final File file_duties;
    public static List<Duty> dutiesForEmployee = new LinkedList<>();
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public EmployeesAndDutiesFileRepository() {
        this.file = new File("data_users.csv");
        this.file_duties = new File("duties_with_data.csv");
    }

    /**
     * @return the list of Duties objects;
     */
    public List<Duty> getDutiesForEmployee() {
        return dutiesForEmployee;
    }

    /**
     * @return The List includes employees.
     * @throws IOException unchecked exception.
     */
    public List<Employee> readFromFileEmployees() throws IOException {
        return Files.lines(file.toPath()).map(EmployeesAndDutiesFileRepository::convertToEmployee).toList();
    }

    /**
     * @return The List includes duties.
     * @throws IOException unchecked exception.
     */
    public void readFromFileDuties() throws IOException {
        EmployeesAndDutiesFileRepository.dutiesForEmployee = Files.lines(file_duties.toPath()).map(EmployeesAndDutiesFileRepository::convertToDuties).toList();
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
        String[] find = s.split(",");
        int i = Integer.parseInt(find[2]);
        int j = Integer.parseInt(find[5]);
        int k = Integer.parseInt(find[6]);
        int ID = Integer.parseInt(find[7]);
        List<Duty> forEachEmployee = new LinkedList<>();
        for (Duty duties : dutiesForEmployee) {
            if (duties.getID() == ID) {
                forEachEmployee.add(duties);
            }
        }
        return new Employee(find[0], find[1], i, find[3], find[4], j, k, forEachEmployee, ID);
    }
}
