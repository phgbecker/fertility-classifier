package diagnosis;

import diagnosis.attribute.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class FertilityDiagnosisTest {
    private FertilityDiagnosis fertilityDiagnosis;

    @Before
    public void setUp() {
        fertilityDiagnosis = new FertilityDiagnosis(
                Season.FALL,
                new Age("31"),
                ChildishDisease.YES,
                AccidentOrSeriousTrauma.NO,
                SurgicalIntervention.YES,
                HighFeversLastYear.NO,
                FrequencyAlcoholConsumption.ONCE_A_WEEK,
                SmokingHabit.NEVER,
                new HoursSpentSittingPerDay("6"),
                Diagnosis.NORMAL
        );
    }

    @Test
    public void givenFertilityDiagnosis_whenSerializeToCsv_thenWriteToFile() throws IOException {
        fertilityDiagnosis.serializeToCsv("fertility_diagnosis_instance.csv");
    }

    @Test
    public void givenFertilityDiagnosis_whenSerializeToJson_thenWriteToFile() throws IOException {
        fertilityDiagnosis.serializeToJson("fertility_diagnosis_instance.json");
    }

    @Test
    public void givenJsonFile_whenDeserialize_thenIsEquals() throws IOException {
        assertThat(fertilityDiagnosis.deserializeFromJson("fertility_diagnosis_instance.json")).isEqualTo(fertilityDiagnosis);
    }
}