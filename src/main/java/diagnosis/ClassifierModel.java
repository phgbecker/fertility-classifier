package diagnosis;

import weka.classifiers.AbstractClassifier;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClassifierModel<T extends AbstractClassifier> {
    private String fileName;

    public ClassifierModel(String fileName) {
        this.fileName = fileName;
    }

    public T loadModel() throws IOException, ClassNotFoundException {
        return (T) (new ObjectInputStream(
                getClass().getClassLoader().getResourceAsStream(fileName)
        ).readObject());
    }

    public CSVLoader loadCsv(String fileName) throws IOException {
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.setSource(new File(fileName));

        return csvLoader;
    }

}
