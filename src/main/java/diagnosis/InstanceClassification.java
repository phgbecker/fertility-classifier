package diagnosis;

import diagnosis.attribute.Diagnosis;
import weka.classifiers.functions.SimpleLogistic;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.HashMap;

public class InstanceClassification {

    public static void main(String[] args) throws Exception {
        // Load classifier Model and Dataset
        ClassifierModel<SimpleLogistic> classifierModel = new ClassifierModel<>();
        SimpleLogistic simpleLogistic = loadModel(classifierModel);
        Instances dataSet = loadDataSet(classifierModel);

        // Parse a JSON file to an Instance
        FertilityDiagnosis fertilityDiagnosis = FertilityDiagnosis.deserializeFromJson("fertility_diagnosis_instance.json");
        Instance instance = setUpInstance(dataSet, fertilityDiagnosis);

        classifyInstance(simpleLogistic, instance);
    }

    private static SimpleLogistic loadModel(ClassifierModel<SimpleLogistic> classifierModel) throws java.io.IOException, ClassNotFoundException {
        SimpleLogistic simpleLogistic = classifierModel.loadModel("fertility.model");
        System.out.println("MODEL:");
        System.out.println(simpleLogistic);

        return simpleLogistic;
    }

    private static Instances loadDataSet(ClassifierModel<SimpleLogistic> classifierModel) throws java.io.IOException {
        Instances dataSet = classifierModel.loadDataSetFromCsv("fertility_diagnosis_dataset.csv");
        dataSet.setClassIndex(dataSet.numAttributes() - 1);
        System.out.println("DATASET:");
        System.out.println(dataSet);

        return dataSet;
    }

    private static Instance setUpInstance(Instances dataSet, FertilityDiagnosis fertilityDiagnosis) {
        Instance instance = new DenseInstance(9);
        instance.setDataset(dataSet);
        instance.setValue(0, fertilityDiagnosis.getSeason().getIndicator());
        instance.setValue(1, fertilityDiagnosis.getAge().getNormalized());
        instance.setValue(2, fertilityDiagnosis.getChildishDisease().getIndicator());
        instance.setValue(3, fertilityDiagnosis.getAccidentOrSeriousTrauma().getIndicator());
        instance.setValue(4, fertilityDiagnosis.getSurgicalIntervention().getIndicator());
        instance.setValue(5, fertilityDiagnosis.getHighFeversLastYear().getIndicator());
        instance.setValue(6, fertilityDiagnosis.getFrequencyAlcoholConsumption().getIndicator());
        instance.setValue(7, fertilityDiagnosis.getSmokingHabit().getIndicator());
        instance.setValue(8, fertilityDiagnosis.getHoursSpentSittingPerDay().getNormalized());
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
