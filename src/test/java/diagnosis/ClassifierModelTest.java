package diagnosis;

import org.junit.Test;
import weka.classifiers.functions.SimpleLogistic;
import weka.core.Instances;

public class ClassifierModelTest {

    @Test
    public void givenModelAndClassifier_whenLoadCsvFile_thenClassify() throws Exception {
        ClassifierModel<SimpleLogistic> classifierModel = new ClassifierModel<>("fertility.model");
        SimpleLogistic simpleLogistic = classifierModel.loadModel();

        Instances dataSetInstances = classifierModel.loadCsv("fertility_diagnosis_instance.csv").getDataSet();
        dataSetInstances.setClassIndex(dataSetInstances.numAttributes() - 1);
        System.out.println(dataSetInstances);

        simpleLogistic.classifyInstance(dataSetInstances.get(0));
        System.out.println(simpleLogistic);
    }

}