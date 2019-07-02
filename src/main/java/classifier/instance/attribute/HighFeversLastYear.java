package classifier.instance.attribute;

public enum HighFeversLastYear {
    LESS_THAN_THREE_MONTHS_AGO(-1),
    MORE_THAN_THREE_MONTHS_AGO(0),
    NO(1);

    private final int indicator;

    HighFeversLastYear(int indicator) {
        this.indicator = indicator;
    }

    public int getIndicator() {
        return indicator;
    }
}
