package diagnosis.attribute;

public enum Diagnosis {
    NORMAL("N"),
    ALTERED("0");

    private String indicator;

    Diagnosis(String indicator) {
        this.indicator = indicator;
    }

    public String getIndicator() {
        return indicator;
    }
}
