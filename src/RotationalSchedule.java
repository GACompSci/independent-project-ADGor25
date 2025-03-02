
public class RotationalSchedule {
    private RotationalDay[] rotationalDays;

    public RotationalSchedule() {
        rotationalDays = new RotationalDay[7];
        for (int i = 0; i < rotationalDays.length; i++) {
            rotationalDays[i] = new RotationalDay(i + 1);
        }
    }

    public RotationalDay[] getRotationalDays() {
        return rotationalDays;
    }

    public RotationalDay getDay(int dayIndex) {
        return rotationalDays[dayIndex - 1];
    }

}
