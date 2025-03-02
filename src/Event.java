
public class Event {
    private String name;
    private String date;
    private String eventType; 
    private Boolean recurrance;
    private String startTime; 
    private String endTime; 
    private String color;
    private String weekDay;
    private int rotationalDay;
    private Boolean today;


    public Event(String eventName, String eventDate, String typeOfEvent, Boolean eventRecurrance, String eventStartTime, String eventEndTime, String eventColor){
        name = eventName;
        date = eventDate;
        eventType = typeOfEvent;
        recurrance = eventRecurrance;
        startTime = eventStartTime;
        endTime = eventEndTime;
        color = eventColor;
    }

    public String getDate() {
        return date;
    }

    public Boolean getToday() {
        return today;
    }

    public String getEventType() {
        return eventType;
    }

    public Boolean getReccurance() {
        return recurrance;
    }

    public String getTime() {
        return startTime + " - " + endTime;
    }

    @Override
    public String toString() {
        return name;
    }

}
