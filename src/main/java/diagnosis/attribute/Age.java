package diagnosis.attribute;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Age {
    private int number;

    public Age() {
    }

    public Age(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
