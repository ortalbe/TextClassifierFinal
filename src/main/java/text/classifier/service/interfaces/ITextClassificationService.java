package text.classifier.service.interfaces;

import text.classifier.data.type.interfaces.ITextClassificationServiceInput;
import text.classifier.data.type.interfaces.ITextClassificationServiceOutput;

public interface ITextClassificationService {

    void execute();
    IClassifyDomainService getClassifyDomainService() ;
    void setClassifyDomainService(IClassifyDomainService classifyDomainService);
    IMapClassificationRulesService getMapClassificationRulesService() ;
    void setMapClassificationRulesService(IMapClassificationRulesService mapClassificationRulesService);
    ITextClassificationServiceInput getTextClassificationServiceInput();
    void setTextClassificationServiceInput(ITextClassificationServiceInput textClassificationServiceInput) ;
    ITextClassificationServiceOutput getTextClassificationServiceOutput();
    void setTextClassificationServiceOutput(ITextClassificationServiceOutput textClassificationServiceOutput) ;
}
