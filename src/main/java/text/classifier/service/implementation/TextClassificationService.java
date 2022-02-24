package text.classifier.service.implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import text.classifier.data.type.interfaces.ITextClassificationServiceInput;
import text.classifier.data.type.interfaces.ITextClassificationServiceOutput;
import text.classifier.service.interfaces.ILuceneManagerService;
import text.classifier.service.interfaces.IClassifyDomainService;
import text.classifier.service.interfaces.IMapClassificationRulesService;
import text.classifier.service.interfaces.ITextClassificationService;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class TextClassificationService implements ITextClassificationService {

    @Autowired
   private IClassifyDomainService classifyDomainService;

    @Autowired
   private IMapClassificationRulesService mapClassificationRulesService;

    @Autowired
   private ITextClassificationServiceInput textClassificationServiceInput;

    @Autowired
   private ITextClassificationServiceOutput textClassificationServiceOutput;

    @Autowired
    private ILuceneManagerService luceneManagerService;

    private static final Logger LOG = LoggerFactory.getLogger(TextClassificationService.class);

    @Override
    public void execute() {
        //read the json file and parse it to Map<Word,ArraList<Domain>>
         boolean createMap = mapClassificationRulesService.execute(textClassificationServiceInput.getJsonPath());
         if(createMap) {
             //read file to Lucene
             boolean createIndex = luceneManagerService.creatIndex(textClassificationServiceInput.getSystemPath());
             if (createIndex) {
                 Set<String> domainSet = new HashSet<>();
                 for (Map.Entry<String, List<String>> word : mapClassificationRulesService.getMapClassificationRules().entrySet()) {
                     if (luceneManagerService.searchWord(word.getKey()))
                         domainSet.addAll(word.getValue());
                 }
                 textClassificationServiceOutput.setDomains(domainSet.stream().collect(Collectors.toList()));
             }


         }
        else
            LOG.error(" index for lucene search tool not created.");
    }

    @Override
    public IClassifyDomainService getClassifyDomainService() {
        return classifyDomainService;
    }

    @Override
    public void setClassifyDomainService(IClassifyDomainService classifyDomainService) {
        this.classifyDomainService = classifyDomainService;
    }

    @Override
    public IMapClassificationRulesService getMapClassificationRulesService() {
        return mapClassificationRulesService;
    }

    public void setMapClassificationRulesService(IMapClassificationRulesService mapClassificationRulesService) {
        this.mapClassificationRulesService = mapClassificationRulesService;
    }

    @Override
    public ITextClassificationServiceInput getTextClassificationServiceInput() {
        return textClassificationServiceInput;
    }

    public void setTextClassificationServiceInput(ITextClassificationServiceInput textClassificationServiceInput) {
        this.textClassificationServiceInput = textClassificationServiceInput;
    }

    public ITextClassificationServiceOutput getTextClassificationServiceOutput() {
        return textClassificationServiceOutput;
    }

    @Override
    public void setTextClassificationServiceOutput(ITextClassificationServiceOutput textClassificationServiceOutput) {
        this.textClassificationServiceOutput = textClassificationServiceOutput;
    }
}
