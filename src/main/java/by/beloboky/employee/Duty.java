package by.beloboky.employee;

import java.time.LocalDate;

public class Duty {

    private final LocalDate dateTime;
    private final String duties;
    private final int id;

    public Duty(int id, LocalDate dateTime, String duties) {
        this.dateTime = dateTime;
        this.duties = duties;
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public String getDuties() {
        return duties;
    }

    @Override
    public String toString() {
        return "Duties{" +
                "dateTime=" + dateTime +
                ", duties='" + duties + '\'' +
                '}';
    }
}
