package classifier;

import classifier.model.ClassifierModel;
import org.junit.Test;
import weka.classifiers.functions.SimpleLogistic;
import weka.core.Instances;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassifierModelTest {

    @Test
    public void givenFileName_whenLoadModel_thenIsInstanceOfSimpleLogistic() throws IOException, ClassNotFoundException {
        assertThat(
                new ClassifierModel<>().loadModel("fertility.model")
        ).isInstanceOf(SimpleLogistic.class);
    }

    @Test
    public void givenFileName_whenLoadDataSetFromCsv_thenIsInstanceOfInstances() throws IOException {
        assertThat(
                ClassifierModel.loadDataSetFromCsv("fertility_dataset.csv")
        ).isInstanceOf(Instances.class);
    }
}