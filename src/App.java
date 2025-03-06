import java.time.DayOfWeek;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Creates the rotational schedule:
        RotationalSchedule rotationalSchedule = new RotationalSchedule();
        
        // Creates a full calendar schedule from August 2025 to June 2026 and assign rotational days:
        FullSchedule fullSchedule = new FullSchedule();
        fullSchedule.assignRotationalDays(rotationalSchedule);
        
        // Initializes a list of sample events:
        ArrayList<Event> events = new ArrayList<>();
        
        // Sample events:
        // 1. A non-recurring event on September 4, 2025 (Opening Day):
        events.add(new Event(
            "Opening Day", 
            "2025-09-04", 
            "Special", 
            Event.RecurrenceType.NONE, 
            "09:00", 
            "10:00", 
            "Blue", 
            null,      
            0        
        ));
        
        // 2. A rotational recurring event (e.g., Math Class every Day 1):
        events.add(new Event(
            "Math Class", 
            "2025-09-04",   
            "Class", 
            Event.RecurrenceType.ROTATIONAL, 
            "10:00", 
            "11:00", 
            "Red", 
            null,     
            1        
        ));
        
        // 3. A weekday recurring event (e.g., Art Club every Monday):
        events.add(new Event(
            "Art Club", 
            "2025-09-04",   
            "Club", 
            Event.RecurrenceType.WEEKDAY, 
            "14:00", 
            "15:00", 
            "Green", 
            DayOfWeek.MONDAY,   
            0         
        ));
        
        // Processes the events: assign each event to the appropriate day(s) in the schedule:
        ScheduleProcessor processor = new ScheduleProcessor(fullSchedule, events);
        processor.assignEventsToSchedule();
        
        // Prints schedule before modifications:
        System.out.println("Schedule before modifications:");
        printSchedule(fullSchedule);
        
        // Removes the "Art Club" event:
        for (Day[] week : fullSchedule.returnSchedule()) {
            for (Day day : week) {
                day.removeEvent("Art Club");
            }
        }
        
        // Prints schedule after modifications:
        System.out.println("\nSchedule after modifications:");
        printSchedule(fullSchedule);
    }
    
    // Helper method tohat prints the schedule:
    public static void printSchedule(FullSchedule fullSchedule) {
        for (Day[] week : fullSchedule.returnSchedule()) {
            for (Day day : week) {
                StringBuilder output = new StringBuilder();
                output.append(day.getDate()).append(": ");
                if (day.getEvents() != null && !day.getEvents().isEmpty()) {
                    for (Event event : day.getEvents()) {
                        output.append(event.toString()).append(" ");
                    }
                } else {
                    output.append("No Events");
                }
                System.out.print(output + "\t");
            }
            System.out.println();
        }
    }
}