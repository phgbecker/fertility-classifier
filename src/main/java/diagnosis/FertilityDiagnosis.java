package diagnosis;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import diagnosis.attribute.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    public void serializeToCsv(String fileName) throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = csvMapper.schemaFor(FertilityDiagnosis.class).withHeader();

        csvMapper.writer(csvSchema).writeValue(
                new File(fileName),
                this
        );
    }

    public void serializeToJson(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        objectWriter.writeValue(
                new File(fileName),
                this
        );
    }

    public FertilityDiagnosis deserializeFromJson(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                new File(fileName),
                this.getClass()
        );
    }
}
