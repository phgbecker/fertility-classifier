package diagnosis.attribute;

public enum SurgicalIntervention {
    YES(0),
    NO(1);

    private int indicator;

    SurgicalIntervention(int indicator) {
        this.indicator = indicator;
    }

    public int getIndicator() {
        return indicator;
    }
}
