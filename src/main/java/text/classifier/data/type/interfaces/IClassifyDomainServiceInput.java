package text.classifier.data.type.interfaces;

import java.util.List;
import java.util.Map;

public interface IClassifyDomainServiceInput {

    void setClassificationRules(Map<String, List<String>> map);
}
