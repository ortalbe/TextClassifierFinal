package text.classifier.data.type.interfaces;

import text.classifier.json.data.model.interfaces.IDomain;

import java.util.List;

public interface IClassifyDomainServiceOutput {

    List<IDomain> getDomain();
}
