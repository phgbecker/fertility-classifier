package diagnosis;

import diagnosis.attribute.Diagnosis;
import weka.classifiers.functions.SimpleLogistic;
import weka.core.Instance;
import weka.core.Instances;

import java.util.HashMap;

public class InstanceClassification {

    public static void main(String[] args) throws Exception {
        // Load classifier model
        ClassifierModel<SimpleLogistic> classifierModel = new ClassifierModel<>();
        SimpleLogistic simpleLogistic = loadModel(classifierModel);

        // Load dataset
        Instances dataSet = loadDataSet(classifierModel);

        // Parse a JSON file to an Instance
        FertilityInstance fertilityInstance = FertilityInstance.deserializeFromJson("fertility_instance.json");
        Instance instance = setUpInstance(dataSet, fertilityInstance);

        // Classify instance
        classifyInstance(simpleLogistic, instance);
    }

    private static SimpleLogistic loadModel(ClassifierModel<SimpleLogistic> classifierModel) throws java.io.IOException, ClassNotFoundException {
        SimpleLogistic simpleLogistic = classifierModel.loadModel("fertility.model");

        System.out.println("MODEL:");
        System.out.println(simpleLogistic);

        return simpleLogistic;
    }

    private static Instances loadDataSet(ClassifierModel<SimpleLogistic> classifierModel) throws java.io.IOException {
        Instances dataSet = classifierModel.loadDataSetFromCsv("fertility_dataset.csv");
        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        System.out.println("DATASET:");
        System.out.println(dataSet);

        return dataSet;
    }

    private static Instance setUpInstance(Instances dataSet, FertilityInstance fertilityInstance) {
        Instance instance = fertilityInstance.getInstance();
        instance.setDataset(dataSet);

        System.out.println();
        System.out.print("INSTANCE: ");
        System.out.println(instance);

        return instance;
    }

    private static void classifyInstance(SimpleLogistic simpleLogistic, Instance instance) throws Exception {
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
