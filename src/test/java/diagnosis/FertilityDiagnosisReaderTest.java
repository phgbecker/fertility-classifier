package diagnosis;

import diagnosis.attribute.*;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class FertilityDiagnosisReaderTest {

    @Test
    public void givenFertilityDiagnosis_whenReadFile_thenIsEquals() throws IOException {
        FertilityDiagnosisReader fertilityDiagnosisReader = new FertilityDiagnosisReader("fertilityDiagnosis.json");
        FertilityDiagnosis fertilityDiagnosis = fertilityDiagnosisReader.readFile();

        assertThat(fertilityDiagnosis.getSeason()).isEqualTo(Season.FALL);
        assertThat(fertilityDiagnosis.getAge().getAge()).isEqualTo(new Age(31).getAge());
        assertThat(fertilityDiagnosis.getChildishDisease()).isEqualTo(ChildishDisease.YES);
        assertThat(fertilityDiagnosis.getAccidentOrSeriousTrauma()).isEqualTo(AccidentOrSeriousTrauma.NO);
        assertThat(fertilityDiagnosis.getSurgicalIntervention()).isEqualTo(SurgicalIntervention.YES);
        assertThat(fertilityDiagnosis.getHighFeversLastYear()).isEqualTo(HighFeversLastYear.NO);
        assertThat(fertilityDiagnosis.getFrequencyAlcoholConsumption()).isEqualTo(FrequencyAlcoholConsumption.ONCE_A_WEEK);
        assertThat(fertilityDiagnosis.getSmokingHabit()).isEqualTo(SmokingHabit.NEVER);
        assertThat(fertilityDiagnosis.getHoursSpentSittingPerDay().getHours()).isEqualTo(new HoursSpentSittingPerDay(6).getHours());
    }

}