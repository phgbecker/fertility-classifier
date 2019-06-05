package diagnosis.attribute;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class HoursSpentSittingPerDay {
    private double hours;

    public HoursSpentSittingPerDay() {
    }

    public HoursSpentSittingPerDay(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }
}
