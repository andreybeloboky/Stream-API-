package by.beloboky.employee;

import java.util.*;

public class EmployeeConsoleController {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        System.out.println("TASK NUMBER ONE");
        employeeService.enterOnScreenAllList();
        System.out.println();

        System.out.println("TASK NUMBER TWO");
        List<String> listWithSalaryAndExperienceLimit = employeeService.getListWithSalaryAndExperienceLimit();
        listWithSalaryAndExperienceLimit.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER THREE");
        List<Employee> listOnlyManagerWithAgeLimit = employeeService.getListOnlyManagerWithAgeLimit();
        listOnlyManagerWithAgeLimit.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER FOUR");
        List<Employee> listSalaryComparingWithLimitFirstFive = employeeService.getListSalaryComparingWithLimitFirstFive();
        listSalaryComparingWithLimitFirstFive.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER FIVE");
        System.out.println(employeeService.getIntegerOnlySumSecurity());

        System.out.println("TASK NUMBER SIX");
        List<String> listWithExperienceLimitAndConsistOnlyNameAndSalary = employeeService.getListWithExperienceLimitAndConsistOnlyNameAndSalary();
        listWithExperienceLimitAndConsistOnlyNameAndSalary.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER SEVEN");
        List<String> listCurtainDate = employeeService.getListCurtainDate(EmployeesAndDutiesFileRepository.dutiesForEmployee);
        listCurtainDate.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER EIGHT");
        List<Employee> listDutyLimitAndComparing = employeeService.getListDutyLimitAndComparing();
        listDutyLimitAndComparing.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER NINE");
        List<Employee> getTaskNine = employeeService.getListOnlyManagerAndUnique();
        getTaskNine.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER TEN");
        List<Employee> getTaskTen = employeeService.getListAgeFrom35To65AndSkipFirstFive();
        getTaskTen.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER ELEVEN");
        System.out.println(employeeService.getBooleanIfAllAgeEmployeeOlderThanEighteen());
        System.out.println();

        System.out.println("TASK MAX");
        Optional<Employee> getMax = employeeService.getMaxAge();
        System.out.println(getMax.get().getAge());
        System.out.println();

        System.out.println("TASK MIN");
        Optional<Employee> getMin = employeeService.getMinAge();
        System.out.println(getMin.get().getAge());
        System.out.println();

        System.out.println("TASK AVERAGE");
        System.out.println(employeeService.getAverageAge().getAsDouble());
        System.out.println();

        System.out.println("TASK THIRTEEN");
        List<String> listHaveOnlyEmployeeOlderThanThirty = employeeService.getListHaveOnlyEmployeeOlderThanThirty();
        listHaveOnlyEmployeeOlderThanThirty.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK FOURTEEN");
        Map<Integer, Integer> sumOfAllEmployeeByPosition = employeeService.getMapSumOfAllEmployeeByPosition();
        System.out.println(Collections.singletonList(sumOfAllEmployeeByPosition));
    }
}
