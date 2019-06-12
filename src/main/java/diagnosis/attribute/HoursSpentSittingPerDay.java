package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class HoursSpentSittingPerDay {
    private double denormalized;

    public HoursSpentSittingPerDay() {
    }

    public HoursSpentSittingPerDay(double hours) {
        this.denormalized = hours;
    }

    public double getDenormalized() {
        return denormalized;
    }

    @JsonIgnore
    public double getNormalized() {
        double minHours = 0;
        double maxHours = 16;

        double amplitude = maxHours - minHours;
        double proportion = denormalized - minHours;

        return proportion / amplitude;
    }
}
