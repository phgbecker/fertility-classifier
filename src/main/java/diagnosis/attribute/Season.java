package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Season {
    WINTER("-1"),
    SPRING("-0.33"),
    SUMMER("0.33"),
    FALL("1");

    private String indicator;

    Season(String indicator) {
        this.indicator = indicator;
    }

    @JsonValue
    public String getIndicator() {
        return indicator;
    }
}
