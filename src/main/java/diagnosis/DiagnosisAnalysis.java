package diagnosis;

import weka.classifiers.functions.SimpleLogistic;
import weka.core.Instances;

public class DiagnosisAnalysis {

    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("O arquivo para análise não foi informado!");
        }

        new FertilityDiagnosis().deserializeFromJson(args[0]);

        ClassifierModel<SimpleLogistic> classifierModel = new ClassifierModel<>("fertility.model");
        SimpleLogistic simpleLogistic = classifierModel.loadModel();

        Instances dataSetInstances = classifierModel.loadCsv(args[0].replace(".json", ".csv")).getDataSet();
        dataSetInstances.setClassIndex(dataSetInstances.numAttributes() - 1);
        System.out.println(dataSetInstances);

        simpleLogistic.classifyInstance(dataSetInstances.get(0));
        System.out.println(simpleLogistic);
    }
}
