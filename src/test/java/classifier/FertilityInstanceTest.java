package classifier;

import classifier.instance.FertilityInstance;
import classifier.instance.attribute.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FertilityInstanceTest {
    private FertilityInstance fertilityInstance;

    @Before
    public void setUp() {
        fertilityInstance = new FertilityInstance(
                Season.FALL,
                new Age(36),
                ChildishDisease.YES,
                AccidentOrSeriousTrauma.NO,
                SurgicalIntervention.YES,
                HighFeversLastYear.NO,
                FrequencyAlcoholConsumption.ONCE_A_WEEK,
                SmokingHabit.NEVER,
                new HoursSpentSittingPerDay(6)
        );
    }

    @Test
    public void givenFertilityInstance_whenSerializeToJson_thenWriteToFile() throws IOException {
        fertilityInstance.serializeToJson("fertility_instance.json");
    }

    @Test
    public void givenJsonFile_whenDeserialize_thenIsEquals() throws IOException {
        assertThat(FertilityInstance.deserializeFromJson("fertility_instance.json")).isEqualTo(fertilityInstance);
    }
}