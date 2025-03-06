import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

public class OffDays {
    private static final Set<LocalDate> offDays = new HashSet<>();

    static {
        offDays.add(LocalDate.of(2025, Month.SEPTEMBER, 23));
        addOffDayRange(LocalDate.of(2025, Month.OCTOBER, 2), LocalDate.of(2025, Month.OCTOBER, 3));
        offDays.add(LocalDate.of(2025, Month.OCTOBER, 31));
        offDays.add(LocalDate.of(2025, Month.NOVEMBER, 21));
        addOffDayRange(LocalDate.of(2025, Month.NOVEMBER, 26), LocalDate.of(2025, Month.DECEMBER, 1));
        addOffDayRange(LocalDate.of(2025, Month.DECEMBER, 22), LocalDate.of(2026, Month.JANUARY, 2));
        offDays.add(LocalDate.of(2026, Month.JANUARY, 19));
        addOffDayRange(LocalDate.of(2026, Month.FEBRUARY, 13), LocalDate.of(2026, Month.FEBRUARY, 16));
        addOffDayRange(LocalDate.of(2026, Month.MARCH, 20), LocalDate.of(2026, Month.APRIL, 3));
        offDays.add(LocalDate.of(2026, Month.APRIL, 17));
        offDays.add(LocalDate.of(2026, Month.MAY, 25));
    }
    
    private static void addOffDayRange(LocalDate start, LocalDate end) {
        LocalDate date = start;
        while (!date.isAfter(end)) {
            offDays.add(date);
            date = date.plusDays(1);
        }
    }
    
    public static boolean isOffDay(LocalDate date) {
        return offDays.contains(date);
    }
}