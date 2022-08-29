import java.time.LocalDate;
import java.time.LocalDateTime;

public class Duties {

    private LocalDate dateTime;
    private String duties;
    private int ID;

    public Duties(int ID, LocalDate dateTime, String duties) {
        this.dateTime = dateTime;
        this.duties = duties;
        this.ID = ID;
    }

    public int getID() {
        return ID;
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
