package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SmokingHabit {
    NEVER("-1"),
    OCCASIONAL("0"),
    DAILY("1");

    private String indicator;

    SmokingHabit(String indicator) {
        this.indicator = indicator;
    }

    @JsonValue
    public String getIndicator() {
        return indicator;
    }
}
