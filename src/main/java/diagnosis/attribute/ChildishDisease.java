package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChildishDisease {
    YES("0"),
    NO("1");

    private String indicator;

    ChildishDisease(String indicator) {
        this.indicator = indicator;
    }

    @JsonValue
    public String getIndicator() {
        return indicator;
    }
}
