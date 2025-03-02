import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        RotationalSchedule schedule = new RotationalSchedule();
        RotationalDay currentRotationalDay = schedule.getRotationalDays()[1];
        currentRotationalDay.createEvent("4SL", "March 30th, 2025", "Class", true, "12:30", "13:30", "Blue");
        ArrayList<Event> eventsToday = currentRotationalDay.getEventsForDay("March 30th, 2025");
        System.out.println(eventsToday);
        for (Event event : eventsToday) {
            System.out.println(event.getDate() + ", " + event.getTime());

        }

    }
}
