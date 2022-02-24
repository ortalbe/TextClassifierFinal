package text.classifier.data.type.interfaces;

import java.util.List;

public interface ITextClassificationServiceOutput {

    List<String> getDomains() ;

    void setDomains(List<String> domains);
}
