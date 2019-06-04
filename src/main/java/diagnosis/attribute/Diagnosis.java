package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Diagnosis {
    NORMAL("N"),
    ALTERED("0");

    private String indicator;

    Diagnosis(String indicator) {
        this.indicator = indicator;
    }

    @JsonValue
    public String getIndicator() {
        return indicator;
    }
}
