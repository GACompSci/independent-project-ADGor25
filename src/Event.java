import java.time.DayOfWeek;

public class Event {

    public enum RecurrenceType {
        NONE,
        ROTATIONAL,
        WEEKDAY
    }
    
    private String name;
    private String date;  
    private String eventType; 
    private RecurrenceType recurrenceType; 
    private String startTime; 
    private String endTime; 
    private String color;
    private DayOfWeek weekDay;
    private int rotationalDay;
    
    public Event(String eventName, String eventDate, String typeOfEvent, 
                 RecurrenceType recurrenceType, String eventStartTime, 
                 String eventEndTime, String eventColor, 
                 DayOfWeek weekDay, int rotationalDay) {
        name = eventName;
        date = eventDate;
        eventType = typeOfEvent;
        this.recurrenceType = recurrenceType;
        startTime = eventStartTime;
        endTime = eventEndTime;
        color = eventColor;
        this.weekDay = weekDay;
        this.rotationalDay = rotationalDay;
    }
    
    public String getDate() {
        return date;
    }
    
    public RecurrenceType getRecurrenceType() {
        return recurrenceType;
    }
    
    public DayOfWeek getWeekDay() {
        return weekDay;
    }
    
    public int getRotationalDay() {
        return rotationalDay;
    }
    
    public String getTime() {
        return startTime + " - " + endTime;
    }
    
    @Override
    public String toString() {
        return name;
    }
}