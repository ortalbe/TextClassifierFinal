package text.classifier.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import text.classifier.data.type.interfaces.IClassifyDomainServiceInput;
import text.classifier.data.type.interfaces.IClassifyDomainServiceOutput;
import text.classifier.service.interfaces.IClassifyDomainService;

public class ClassifyDomainService implements IClassifyDomainService {

    private IClassifyDomainServiceInput classifyDomainServiceInput;

    private IClassifyDomainServiceOutput classifyDomainServiceOutput;

    private static final Logger LOG = LoggerFactory.getLogger(ClassifyDomainService.class);
    @Override
    public void setIntput(IClassifyDomainServiceInput classifyDomainServiceInput) {
        this.classifyDomainServiceInput = classifyDomainServiceInput;
    }

    @Override
    public void execute() {
        if(classifyDomainServiceInput==null)
        {
            LOG.error("missing input. the Object IClassifyDomainServiceInput is empty.");
            throw new IllegalStateException();
        }


    }

    @Override
    public IClassifyDomainServiceOutput getOutput() {
        return classifyDomainServiceOutput;
    }


}
