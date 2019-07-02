package classifier;

import classifier.instance.FertilityInstance;
import classifier.instance.attribute.Diagnosis;
import classifier.model.ClassifierModel;
import weka.classifiers.functions.SimpleLogistic;
import weka.core.Instance;
import weka.core.Instances;

import java.io.IOException;
import java.util.HashMap;

public class FertilityClassifier {
    private SimpleLogistic simpleLogistic;
    private Instances dataSet;

    public FertilityClassifier loadModel(String fileName) throws IOException, ClassNotFoundException {
        simpleLogistic = new ClassifierModel<SimpleLogistic>().loadModel(fileName);

        return this;
    }

    public FertilityClassifier loadDataSet(String fileName) throws IOException {
        dataSet = ClassifierModel.loadDataSetFromCsv(fileName);
        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        return this;
    }

    public void classifyInstance(String fileName) throws Exception {
        FertilityInstance fertilityInstance = FertilityInstance.deserializeFromJson("fertility_instance.json");
        Instance instance = setUpInstance(fertilityInstance);
        classifyInstance(instance);
    }

    private Instance setUpInstance(FertilityInstance fertilityInstance) {
        Instance instance = fertilityInstance.getInstance();
        instance.setDataset(dataSet);

        System.out.println();
        System.out.print("INSTANCE: ");
        System.out.println(instance);

        return instance;
    }

    private void classifyInstance(Instance instance) throws Exception {
        HashMap<Integer, Diagnosis> diagnosisMap = new HashMap<>();
        diagnosisMap.put(0, Diagnosis.NORMAL);
        diagnosisMap.put(1, Diagnosis.ALTERED);

        System.out.println();
        System.out.print("DIAGNOSIS: ");
        System.out.println(diagnosisMap.get((int) simpleLogistic.classifyInstance(instance)));

        double[] distributionForInstance = simpleLogistic.distributionForInstance(instance);
        diagnosisMap.forEach((index, diagnosis) ->
                System.out.println(diagnosis + "\t-> " + distributionForInstance[index])
        );
    }
}
