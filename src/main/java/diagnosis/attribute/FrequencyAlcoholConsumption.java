package diagnosis.attribute;

public enum FrequencyAlcoholConsumption {
    SEVERAL_TIMES_A_DAY(0),
    EVERY_DAY(0.2),
    SEVERAL_TIMES_A_WEEK(0.4),
    ONCE_A_WEEK(0.6),
    HARDLY_NEVER(0.8),
    NEVER(1);

    private final double indicator;

    FrequencyAlcoholConsumption(double indicator) {
        this.indicator = indicator;
    }

    public double getIndicator() {
        return indicator;
    }
}
