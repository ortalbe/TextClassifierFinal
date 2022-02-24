package text.classifier.json.data.model.implementations;

import text.classifier.json.data.model.interfaces.IClassificationRulesEntry;
import java.util.List;


public class ClassificationRulesEntry implements IClassificationRulesEntry {

    private String domain;
    private List<String> indicators;

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public List<String> getIndicators() {
        return indicators;
    }

    @Override
    public void setIndicators(List<String> indicators) {
        this.indicators = indicators;
    }
}
