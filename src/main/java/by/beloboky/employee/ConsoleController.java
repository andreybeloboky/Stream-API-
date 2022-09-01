package by.beloboky.employee;

import java.io.*;
import java.util.*;

public class ConsoleController {

    public static void main(String[] args) throws IOException {
        FileRepositoryOfEmployeesAndDuties read = new FileRepositoryOfEmployeesAndDuties();
        read.readFromFileDuties();
        EmployeeService businessLogic = new EmployeeService();

        // Task number One;
        System.out.println("TASK NUMBER ONE");
        businessLogic.getTaskOne();
        System.out.println();

        // Task number Two;
        System.out.println("TASK NUMBER TWO");
        List<String> taskTwo = businessLogic.getTaskTwo();
        taskTwo.forEach(System.out::println);
        System.out.println();

        // Task number Three;
        System.out.println("TASK NUMBER THREE");
        List<Employee> getTaskThree = businessLogic.getTaskThree();
        getTaskThree.forEach(System.out::println);
        System.out.println();

        // Task number Four;
        System.out.println("TASK NUMBER FOUR");
        List<Employee> getTaskFour = businessLogic.getTaskFour();
        getTaskFour.forEach(System.out::println);
        System.out.println();

        // Task number Five;
        System.out.println("TASK NUMBER FIVE");
        System.out.println(businessLogic.getTaskFive());

        // Task number Six;
        System.out.println("TASK NUMBER SIX");
        List<String> getTaskSix = businessLogic.getTaskSix();
        getTaskSix.forEach(System.out::println);
        System.out.println();

        // Task number Seven;
        System.out.println("TASK NUMBER SEVEN");
        List<String> getTaskSeven = businessLogic.getTaskSeven(read.getDutiesForEmployee());
        getTaskSeven.forEach(System.out::println);
        System.out.println();

        // Task number Eight;
        System.out.println("TASK NUMBER EIGHT");
        List<Employee> getTaskEight = businessLogic.getTaskEight();
        getTaskEight.forEach(System.out::println);
        System.out.println();

        // Task number Nine;
        System.out.println("TASK NUMBER NINE");
        List<Employee> getTaskNine = businessLogic.getTaskNine();
        getTaskNine.forEach(System.out::println);
        System.out.println();

        // Task number Ten;
        System.out.println("TASK NUMBER TEN");
        List<Employee> getTaskTen = businessLogic.getTaskTen();
        getTaskTen.forEach(System.out::println);
        System.out.println();

        // Task number Eleven;
        System.out.println("TASK NUMBER ELEVEN");
        System.out.println(businessLogic.getTaskEleven());
        System.out.println();

        // Task number Twelve;
        System.out.println("TASK MAX");
        Optional<Employee> getMax = businessLogic.getMax();
        System.out.println(getMax);
        System.out.println();

        System.out.println("TASK MIN");
        Optional<Employee> getMin = businessLogic.getMin();
        System.out.println(getMin);
        System.out.println();

        System.out.println("TASK AVERAGE");
        System.out.println(businessLogic.getAvg());
        System.out.println();

        // Task number Thirteen;
        System.out.println("TASK THIRTEEN");
        List<String> getTaskThirteen = businessLogic.getTaskThirteen();
        getTaskThirteen.forEach(System.out::println);
        System.out.println();

        // Task number Fourteen;
        System.out.println("TASK FOURTEEN");
        Map<Integer, Integer> getTaskFourteen = businessLogic.getTaskFourteen();
        System.out.println(Collections.singletonList(getTaskFourteen));
    }
}
