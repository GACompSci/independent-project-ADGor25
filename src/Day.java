import java.time.LocalDate;
import java.util.ArrayList;

public class Day {
    private LocalDate date;
    private RotationalDay rotationalDay;
    private ArrayList<Event> events;

    public void removeEvent(String eventName) {
        if (events != null) {
            // Use a for loop to remove events with the given name.
            for (int i = 0; i < events.size(); i++) {
                // Assuming you add a getName() method to Event to return the event's name.
                if (events.get(i).toString().equals(eventName)) {
                    events.remove(i);
                    i--; // Adjust the index because the list has shrunk.
                }
            }
        }
    }
    
    public Day(LocalDate date) {
        this.date = date;
    }

    public Day(LocalDate date, RotationalDay rotDay) {
        this.date = date;
        this.rotationalDay = rotDay;
    }

    public void setRotationalDay(RotationalDay rotationalDay) {
        this.rotationalDay = rotationalDay;
    }

    public LocalDate getDate() {
        return date;
    }
    
    public RotationalDay getRotationalDay() {
        return rotationalDay;
    }

    public ArrayList<Event> getEvents() {
        if (events == null) {
            events = new ArrayList<>();
        }
        return events;
    }
}