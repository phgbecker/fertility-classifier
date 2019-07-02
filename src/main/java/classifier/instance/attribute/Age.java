package classifier.instance.attribute;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Age {
    private double denormalized;

    public Age() {
    }

    public Age(double age) {
        this.denormalized = age;
    }

    public double getDenormalized() {
        return denormalized;
    }

    @JsonIgnore
    public double getNormalized() {
        double minAge = 18;
        double maxAge = 36;

        double amplitude = maxAge - minAge;
        double proportion = denormalized - minAge;

        return proportion / amplitude;
    }
}
