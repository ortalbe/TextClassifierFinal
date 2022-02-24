package text.classifier.data.type.implementation;

import org.springframework.stereotype.Component;
import text.classifier.data.type.interfaces.IClassifyDomainServiceInput;
import java.util.List;
import java.util.Map;

@Component
public class ClassifyDomainServiceInput implements IClassifyDomainServiceInput {

    Map<String, List<String>> map ;
    @Override
    public void setClassificationRules(Map<String, List<String>> map) {
        this.map=map;
    }

}
