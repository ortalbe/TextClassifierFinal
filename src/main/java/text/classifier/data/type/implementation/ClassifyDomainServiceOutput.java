package text.classifier.data.type.implementation;

import org.springframework.stereotype.Component;
import text.classifier.data.type.interfaces.IClassifyDomainServiceOutput;
import text.classifier.json.data.model.interfaces.IDomain;
import java.util.List;

@Component
public class ClassifyDomainServiceOutput implements IClassifyDomainServiceOutput {

    List<IDomain> domains;

    @Override
    public List<IDomain> getDomain() {
        return domains;
    }
}
