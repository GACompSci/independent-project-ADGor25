import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class FullSchedule {

    ArrayList<Day[]> fullSchedule;

    public FullSchedule() {
        fullSchedule = new ArrayList<Day[]>();

        LocalDate startDate = LocalDate.of(2025, Month.AUGUST, 1);
        LocalDate endDate = LocalDate.of(2026, Month.JUNE, 30);

        LocalDate calendarStart = startDate;
        while (calendarStart.getDayOfWeek() != DayOfWeek.SUNDAY) {
            calendarStart = calendarStart.minusDays(1);
        }

        LocalDate current = calendarStart;
        while (!current.isAfter(endDate)) {
            Day[] week = new Day[7];
            for (int i = 0; i < 7; i++) {
                // Creates a Day for each date:
                week[i] = new Day(current); 
                current = current.plusDays(1);
            }
            fullSchedule.add(week);
        }
    }

    public ArrayList<Day[]>returnSchedule() {
        return fullSchedule;
    }

    public void assignRotationalDays(RotationalSchedule rotationalSchedule) {
        int rotationalIndex = 0;
        // First and Last Days of School:
        LocalDate schoolStart = LocalDate.of(2025, Month.SEPTEMBER, 4);
        LocalDate schoolEnd = LocalDate.of(2026,Month.JUNE,10);
        for (Day[] week : fullSchedule) {
            for (Day day : week) {
                LocalDate date = day.getDate();
                // Only assigns a rotational day when there is school:
                if (
                    date.compareTo(schoolStart) >= 0 &&
                    date.compareTo(schoolEnd) <= 0 &&
                    !OffDays.isOffDay(date) &&
                    date.getDayOfWeek() != DayOfWeek.SATURDAY &&
                    date.getDayOfWeek() != DayOfWeek.SUNDAY
                ) {
                    day.setRotationalDay(rotationalSchedule.get(rotationalIndex));
                    rotationalIndex = (rotationalIndex + 1) % rotationalSchedule.getRotationalDays().length;
                }
            }
        }
    }
}
