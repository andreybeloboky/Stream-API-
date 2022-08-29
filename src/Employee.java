import java.util.List;

public class Employee implements Comparable<Employee> {

    private int ID;
    private String name;
    private String lastName;
    private int age;
    private String sex;
    private String position;
    private int salary;
    private int workExperience;
    private List<Duties> duties;

    public Employee(String name, String lastName, Integer age, String sex, String position, Integer salary, Integer workExperience, List<Duties> duties, Integer ID) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.position = position;
        this.salary = salary;
        this.workExperience = workExperience;
        this.duties = duties;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public int getID() {
        return ID;
    }

    public List<Duties> getDuties() {
        return duties;
    }

    public int getDutiesSize() {
        return duties.size();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", workExperience=" + workExperience +
                ", duties=" + duties +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return o.getSalary() - this.salary;
    }


}
