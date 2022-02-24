package text.classifier.json.data.model.implementations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import text.classifier.json.data.model.interfaces.IClassificationRules;
import text.classifier.json.data.model.interfaces.IClassificationRulesEntry;

import java.util.List;

public class ClassificationRules implements IClassificationRules {

    @JsonDeserialize(contentAs = ClassificationRulesEntry.class)
    @JsonProperty("classification_rules")
    private List<IClassificationRulesEntry> classificationRulesEntries;

    @Override
    public List<IClassificationRulesEntry> getClassificationRulesEntries() {
        return classificationRulesEntries;
    }

    @Override
    public void setClassificationRulesEntries(List<IClassificationRulesEntry> classificationRulesEntries) {
        this.classificationRulesEntries = classificationRulesEntries;
    }


}
