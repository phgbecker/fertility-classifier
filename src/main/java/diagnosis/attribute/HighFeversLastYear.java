package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonValue;

public enum HighFeversLastYear {
    LESS_THAN_THREE_MONTHS_AGO("-1"),
    MORE_THAN_THREE_MONTHS_AGO("0"),
    NO("1");

    private String indicator;

    HighFeversLastYear(String indicator) {
        this.indicator = indicator;
    }

    @JsonValue
    public String getIndicator() {
        return indicator;
    }
}
