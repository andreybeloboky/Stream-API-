package by.beloboky.employee;

import java.util.*;

public class EmployeeConsoleController {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        System.out.println("TASK NUMBER ONE");
        employeeService.returnFullEmployeeList().forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER TWO");
        List<String> employeesWithWorkExperienceMoreThanThreeYearAndSalaryMoreThanOneThousandFiveHundred = employeeService.findEmployeeWithWorkExperienceMoreThanThreeYearAndSalaryMoreThanOneThousandFiveHundred();
        employeesWithWorkExperienceMoreThanThreeYearAndSalaryMoreThanOneThousandFiveHundred.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER THREE");
        List<Employee> managersAgeFromThirtyFiveToSixty = employeeService.findManagerAgeFromThirtyFiveToSixty();
        managersAgeFromThirtyFiveToSixty.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER FOUR");
        List<Employee> firstFiveSalaryOfEmployee = employeeService.sortFirstFiveSalaryOfEmployee();
        firstFiveSalaryOfEmployee.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER FIVE");
        System.out.println(employeeService.calculateSumOfAllSecutiryAndMultiplyByThree());

        System.out.println("TASK NUMBER SIX");
        List<String> nmeAndSalaryEmployeeWhichWorkingMoreThanSevenYears = employeeService.findNameAndSalaryEmployeeWhichWorkingMoreThanSevenYears();
        nmeAndSalaryEmployeeWhichWorkingMoreThanSevenYears.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER SEVEN");
        List<String> listCurtainDate = employeeService.findDutiesForTheDay();
        listCurtainDate.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER EIGHT");
        List<Employee> employeesWhichHaveLessThanTwoDutiesAndComparingByWorkExperience = employeeService.findEmployeeWhichHaveLessThanTwoDutiesAndComparingByWorkExperience();
        employeesWhichHaveLessThanTwoDutiesAndComparingByWorkExperience.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER NINE");
        List<Employee> uniqueManagerEmployee = employeeService.findUniqueManagerEmployee();
        uniqueManagerEmployee.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER TEN");
        List<Employee> employeeWhichHaveFromThirtyFiveToSixtyFiveAndSkipFirstFiveEmployee = employeeService.findEmployeeWhichHaveFromThirtyFiveToSixtyFiveAndSkipFirstFiveEmployee();
        employeeWhichHaveFromThirtyFiveToSixtyFiveAndSkipFirstFiveEmployee.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK NUMBER ELEVEN");
        System.out.println(employeeService.areWhetherAllAreEighteenAge());
        System.out.println();

        System.out.println("TASK MAX/MIN/AVERAGE");
        IntSummaryStatistics getMaxMinAverage = employeeService.getMaxMinAverageAge();
        System.out.println(getMaxMinAverage);

        System.out.println("TASK THIRTEEN");
        List<String> findFirstAndLastNameAndWorkExpEmployeeHasMoreThanThirtyAge = employeeService.findFirstAndLastNameAndWorkExpEmployeeHasMoreThanThirtyAge();
        findFirstAndLastNameAndWorkExpEmployeeHasMoreThanThirtyAge.forEach(System.out::println);
        System.out.println();

        System.out.println("TASK FOURTEEN");
        Map<Integer, Integer> sumOfAllEmployeeByPosition = employeeService.findSumOfAllEmployeeByPosition();
        System.out.println(Collections.singletonList(sumOfAllEmployeeByPosition));

    }
}
