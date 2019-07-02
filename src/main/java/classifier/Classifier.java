package classifier;

public class Classifier {

    public static void main(String[] args) throws Exception {
        FertilityClassifier classifier = new FertilityClassifier();

        classifier
                .loadModel("fertility.model")
                .loadDataSet("fertility_dataset.csv")
                .classifyInstance("fertility_instance.json");
    }
}
