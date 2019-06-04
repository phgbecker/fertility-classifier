package diagnosis;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class ClassifierModelReader {
    private String fileName;

    public ClassifierModelReader(String fileName) {
        this.fileName = fileName;
    }

    public InputStream readFile() {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }

    public Object getClassifier() throws IOException, ClassNotFoundException {
        return new ObjectInputStream(readFile()).readObject();
    }
}
