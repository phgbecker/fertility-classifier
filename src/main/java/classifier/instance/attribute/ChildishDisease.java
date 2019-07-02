package classifier.instance.attribute;

public enum ChildishDisease {
    YES(0),
    NO(1);

    private final int indicator;

    ChildishDisease(int indicator) {
        this.indicator = indicator;
    }

    public int getIndicator() {
        return indicator;
    }
}
