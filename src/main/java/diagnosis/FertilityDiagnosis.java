package diagnosis;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import diagnosis.attribute.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
public class FertilityDiagnosis {
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

    public FertilityDiagnosis(Season season, Age age, ChildishDisease childishDisease, AccidentOrSeriousTrauma accidentOrSeriousTrauma, SurgicalIntervention surgicalIntervention, HighFeversLastYear highFeversLastYear, FrequencyAlcoholConsumption frequencyAlcoholConsumption, SmokingHabit smokingHabit, HoursSpentSittingPerDay hoursSpentSittingPerDay) {
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

    public static FertilityDiagnosis deserializeFromJson(String fileName) throws IOException {
        return new ObjectMapper().readValue(
                new File(fileName),
                FertilityDiagnosis.class
        );
    }
}
