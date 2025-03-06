import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ScheduleProcessor {
    private FullSchedule fullSchedule;
    private ArrayList<Event> events;
    
    public ScheduleProcessor(FullSchedule fullSchedule, ArrayList<Event> events) {
        this.fullSchedule = fullSchedule;
        this.events = events;
    }
    
    public void assignEventsToSchedule() {
        // Formats event date strings:
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        
        // Loops over each day in the full schedule:
        for (Day[] week : fullSchedule.returnSchedule()) {
            for (Day day : week) {
                LocalDate currentDate = day.getDate();

                // Proccesses each day's events based on recurrance type
                for (Event event : events) {
                    switch (event.getRecurrenceType()) {
                        case NONE:
                            // Non-recurring Events: adds only if the date matches
                            if (currentDate.equals(LocalDate.parse(event.getDate(), formatter))) {
                                day.getEvents().add(event);
                            }
                            break;
                        case ROTATIONAL:
                            // Rotational Events: checks that the day’s rotational day matches
                            if (day.getRotationalDay() != null &&
                                day.getRotationalDay().getDayNumber() == event.getRotationalDay()) {
                                day.getEvents().add(event);
                            }
                            break;
                        case WEEKDAY:
                            // Weekly Events: matches the day of week
                            if (currentDate.getDayOfWeek().equals(event.getWeekDay())) {
                                day.getEvents().add(event);
                            }
                            break;
                    }
                }
            }
        }
    }
}