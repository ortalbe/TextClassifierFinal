package text.classifier.service.interfaces;

import text.classifier.data.type.interfaces.IClassifyDomainServiceInput;
import text.classifier.data.type.interfaces.IClassifyDomainServiceOutput;

public interface IClassifyDomainService {

    void setIntput(IClassifyDomainServiceInput classifyDomainServiceInput);
    void execute();
    IClassifyDomainServiceOutput getOutput();


}
