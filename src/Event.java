public class Event {
    private String name;
    private String eventType; 
    private Boolean recurrance;
    private String startTime; 
    private String endTime; 
    private String color;
    private String weekDay;
    private int rotationalDay;


    public Event(String eventName, String typeOfEvent, Boolean eventRecurrance, String eventStartTime, String eventEndTime, String eventColor){
        name = eventName;
        eventType = typeOfEvent;
        recurrance = eventRecurrance;
        startTime = eventStartTime;
        endTime = eventEndTime;
        color = eventColor;
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

    public String toString() {
        return name;
    }

}
