package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SurgicalIntervention {
    YES("0"),
    NO("1");

    private String indicator;

    SurgicalIntervention(String indicator) {
        this.indicator = indicator;
    }

    @JsonValue
    public String getIndicator() {
        return indicator;
    }
}
