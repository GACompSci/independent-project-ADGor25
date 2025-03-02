import java.util.ArrayList;

public class RotationalSchedule {
    private RotationalDay[] rotationalDays;

    public RotationalSchedule() {
        rotationalDays = new RotationalDay[7];
    }

    public void addEventToDay(int dayIndex, Event event) {
        RotationalDay day = rotationalDays[dayIndex];
        ArrayList<Event> dayEvents = day.getEvents();
        dayEvents.add(event);
    }

    public RotationalDay[] getRotationalDays() {
        return rotationalDays;
    }

    public RotationalDay getDay(int dayIndex) {
        return rotationalDays[dayIndex];
    }

}
