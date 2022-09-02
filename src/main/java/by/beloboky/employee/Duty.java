package by.beloboky.employee;

import java.time.LocalDate;

public class Duty {

    private final LocalDate date;
    private final String duty;
    private final int id;

    public Duty(int id, LocalDate date, String duty) {
        this.date = date;
        this.duty = duty;
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public String toString() {
        return "Duties{" +
                "dateTime=" + date +
                ", duties='" + duty + '\'' +
                '}';
    }
}
