package text.classifier.data.type.implementation;

import text.classifier.data.type.interfaces.ITextClassificationServiceOutput;
import java.util.List;

public class TextClassificationServiceOutput implements ITextClassificationServiceOutput {

    private List<String> domains;

    public TextClassificationServiceOutput() {
    }

    @Override
    public List<String> getDomains() {
        return domains;
    }

    @Override
    public void setDomains(List<String> domains) {
        this.domains = domains;
    }
}
