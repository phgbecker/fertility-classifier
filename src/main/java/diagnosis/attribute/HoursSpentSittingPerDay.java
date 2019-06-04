package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class HoursSpentSittingPerDay {
    private String hours;

    public HoursSpentSittingPerDay() {
    }

    public HoursSpentSittingPerDay(String hours) {
        this.hours = hours;
    }

    @JsonValue
    public String getHours() {
        return hours;
    }
}
