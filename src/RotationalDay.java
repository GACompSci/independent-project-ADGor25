import java.util.ArrayList;

public class RotationalDay {

    private int dayNumber; 
    private String dayOfWeek;
    private ArrayList<Event> events = new ArrayList<Event>();
    
    public RotationalDay(int dayNum) {
        dayNumber = dayNum;
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

    @Override
    public String toString() {
        return "Day " + dayNumber;
    }

    public int getDayNumber() {
        return dayNumber;
    }
}
