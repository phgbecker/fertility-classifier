package classifier.instance.attribute;

public enum Season {
    WINTER(-1),
    SPRING(-0.33),
    SUMMER(0.33),
    FALL(1);

    private final double indicator;

    Season(double indicator) {
        this.indicator = indicator;
    }

    public double getIndicator() {
        return indicator;
    }
}
