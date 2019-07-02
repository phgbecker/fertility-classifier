package classifier.instance.attribute;

public enum FrequencyAlcoholConsumption {
    SEVERAL_TIMES_A_DAY(0),
    EVERY_DAY(0.25),
    SEVERAL_TIMES_A_WEEK(0.5),
    ONCE_A_WEEK(0.75),
    HARDLY_NEVER_OR_NEVER(1);

    private final double indicator;

    FrequencyAlcoholConsumption(double indicator) {
        this.indicator = indicator;
    }

    public double getIndicator() {
        return indicator;
    }
}
