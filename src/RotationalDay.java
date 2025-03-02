import java.util.ArrayList;

public class RotationalDay {

    private int dayNumber; 
    private String dayOfWeek;
    private ArrayList<Event> events;
    
    public RotationalDay(int dayNum, String weekDay, ArrayList<Event> listOfEvents) {
        dayNumber = dayNum;
        dayOfWeek = weekDay;
        events = listOfEvents;
    }

    public void addEvent(Event event) {
        events.add(event);
    }
    
    public void removeEvent(Event event) {
        events.remove(event);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

}
