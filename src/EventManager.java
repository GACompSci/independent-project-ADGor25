import java.util.ArrayList;

public class EventManager {
    private RotationalSchedule rotationalSchedule;
    private ArrayList<Event> totalEvents = new ArrayList<Event>();

    public EventManager(RotationalSchedule rotationalSchedule) {
        this.rotationalSchedule = rotationalSchedule;
    }

    public void createEvent(String name, String type, Boolean recurring, String start, String end, String color) {
        Event newEvent = new Event(name, type, recurring, start, end, color); 
        totalEvents.add(newEvent);
        if (recurring) {
            handleRecurring();
        }
    }

    public void handleRecurring() {
    }

    public void deleteEvent(int dayNumber, Event event) {
        totalEvents.remove(event);
    }

    public ArrayList<Event> getEventsForDay(int dayNumber) {
        ArrayList<Event> events = new ArrayList<Event>();
        for (Event event : totalEvents) {
            if (event.dayNumber() == dayNumber) {
                events.add(event);
            }
        }
        return events;
    }
}
