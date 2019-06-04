package diagnosis.attribute;

public enum ChildishDisease {
    YES(0),
    NO(1);

    private int indicator;

    ChildishDisease(int indicator) {
        this.indicator = indicator;
    }

    public int getIndicator() {
        return indicator;
    }
}
