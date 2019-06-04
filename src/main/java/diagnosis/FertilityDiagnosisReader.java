package diagnosis;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class FertilityDiagnosisReader {
    private String fileName;
    private FertilityDiagnosis fertilityDiagnosis;

    public FertilityDiagnosisReader(String fileName) {
        this.fileName = fileName;
    }

    public FertilityDiagnosis readFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(
                new File(fileName),
                FertilityDiagnosis.class
        );
    }

    public FertilityDiagnosis getFertilityDiagnosis() {
        return fertilityDiagnosis;
    }
}
