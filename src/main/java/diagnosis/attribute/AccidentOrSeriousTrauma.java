package diagnosis.attribute;

public enum AccidentOrSeriousTrauma {
    YES(0),
    NO(1);

    private int indicator;

    AccidentOrSeriousTrauma(int indicator) {
        this.indicator = indicator;
    }

    public int getIndicator() {
        return indicator;
    }
}
