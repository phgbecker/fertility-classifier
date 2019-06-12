package diagnosis;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import diagnosis.attribute.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weka.core.DenseInstance;
import weka.core.Instance;

import java.io.File;
import java.io.IOException;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder(
        {
                "season",
                "age",
                "childishDisease",
                "accidentOrSeriousTrauma",
                "surgicalIntervention",
                "highFeversLastYear",
                "frequencyAlcoholConsumption",
                "smokingHabit",
                "hoursSpentSittingPerDay",
                "diagnosis"
        }
)
public class FertilityInstance {
    private Season season;
    private Age age;
    private ChildishDisease childishDisease;
    private AccidentOrSeriousTrauma accidentOrSeriousTrauma;
    private SurgicalIntervention surgicalIntervention;
    private HighFeversLastYear highFeversLastYear;
    private FrequencyAlcoholConsumption frequencyAlcoholConsumption;
    private SmokingHabit smokingHabit;
    private HoursSpentSittingPerDay hoursSpentSittingPerDay;
    private Diagnosis diagnosis;

    public FertilityInstance(Season season, Age age, ChildishDisease childishDisease, AccidentOrSeriousTrauma accidentOrSeriousTrauma, SurgicalIntervention surgicalIntervention, HighFeversLastYear highFeversLastYear, FrequencyAlcoholConsumption frequencyAlcoholConsumption, SmokingHabit smokingHabit, HoursSpentSittingPerDay hoursSpentSittingPerDay) {
        this.season = season;
        this.age = age;
        this.childishDisease = childishDisease;
        this.accidentOrSeriousTrauma = accidentOrSeriousTrauma;
        this.surgicalIntervention = surgicalIntervention;
        this.highFeversLastYear = highFeversLastYear;
        this.frequencyAlcoholConsumption = frequencyAlcoholConsumption;
        this.smokingHabit = smokingHabit;
        this.hoursSpentSittingPerDay = hoursSpentSittingPerDay;
    }

    public void serializeToJson(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        objectWriter.writeValue(
                new File(fileName),
                this
        );
    }

    public static FertilityInstance deserializeFromJson(String fileName) throws IOException {
        return new ObjectMapper().readValue(
                new File(fileName),
                FertilityInstance.class
        );
    }

    @JsonIgnore
    public Instance getInstance() {
        Instance fertilityInstance = new DenseInstance(9);
        fertilityInstance.setValue(0, getSeason().getIndicator());
        fertilityInstance.setValue(1, getAge().getNormalized());
        fertilityInstance.setValue(2, getChildishDisease().getIndicator());
        fertilityInstance.setValue(3, getAccidentOrSeriousTrauma().getIndicator());
        fertilityInstance.setValue(4, getSurgicalIntervention().getIndicator());
        fertilityInstance.setValue(5, getHighFeversLastYear().getIndicator());
        fertilityInstance.setValue(6, getFrequencyAlcoholConsumption().getIndicator());
        fertilityInstance.setValue(7, getSmokingHabit().getIndicator());
        fertilityInstance.setValue(8, getHoursSpentSittingPerDay().getNormalized());

        return fertilityInstance;
    }
}
