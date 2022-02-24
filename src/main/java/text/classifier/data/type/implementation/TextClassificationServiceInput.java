package text.classifier.data.type.implementation;

import text.classifier.data.type.interfaces.ITextClassificationServiceInput;

public class TextClassificationServiceInput implements ITextClassificationServiceInput {

    private String jsonPath;
    private String systemPath;

    public TextClassificationServiceInput() {
    }

    public TextClassificationServiceInput(String systemPath,String jsonPath) {
        this.jsonPath = jsonPath;
        this.systemPath = systemPath;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public String getSystemPath() {
        return systemPath;
    }

    public void setSystemPath(String systemPath) {
        this.systemPath = systemPath;
    }
}
