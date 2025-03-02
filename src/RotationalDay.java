import java.util.ArrayList;

public class RotationalDay {

    private int dayNumber; 
    private String dayOfWeek;
    private ArrayList<Event> events = new ArrayList<Event>();
    
    public RotationalDay(int dayNum) {
        dayNumber = dayNum;
    }

    public void createEvent(String name, String date, String type, Boolean recurring, String start, String end, String color) {
        Event newEvent = new Event(name, date, type, recurring, start, end, color); 
        events.add(newEvent);
        if (recurring) {
            handleRecurring(newEvent);
        }
    }

    public void handleRecurring(Event event) {
        // To Be Implemented after UI for Selecting Recurrance Type is Estbalished
    }
    
    public void removeEvent(Event event) {
        events.remove(event);
    }

    public ArrayList<Event> getEventsForDay(String date) {
        ArrayList<Event> eventsToday= new ArrayList<Event>();
        for (Event event : events) {
            if (date.equals(event.getDate())) {
                eventsToday.add(event);
            }
        }
        return eventsToday;
    }
}
