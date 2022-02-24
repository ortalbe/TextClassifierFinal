package text.classifier.json.data.model.interfaces;

import java.util.List;

public interface IClassificationRulesEntry {

    String getDomain() ;
    void setDomain(String domain) ;
    List<String> getIndicators();
    void setIndicators(List<String> indicators) ;
}
