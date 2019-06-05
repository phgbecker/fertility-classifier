package diagnosis.attribute;

public enum SmokingHabit {
    NEVER(-1),
    OCCASIONAL(0),
    DAILY(1);

    private final int indicator;

    SmokingHabit(int indicator) {
        this.indicator = indicator;
    }

    public int getIndicator() {
        return indicator;
    }
}
