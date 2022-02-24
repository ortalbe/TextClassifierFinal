package text.classifier.json.data.model.interfaces;

import java.util.List;

public interface IClassificationRules {

    List<IClassificationRulesEntry> getClassificationRulesEntries();
    void setClassificationRulesEntries(List<IClassificationRulesEntry> classificationRulesEntries);

}
