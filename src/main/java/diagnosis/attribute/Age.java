package diagnosis.attribute;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Age {
    private String age;

    public Age() {
    }

    public Age(String age) {
        this.age = age;
    }

    @JsonValue
    public String getAge() {
        return age;
    }
}
