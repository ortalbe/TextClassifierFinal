package text.classifier.config;

import lucene.LuceneApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import text.classifier.service.implementation.ClassifyDomainService;
import text.classifier.service.implementation.LuceneManagerService;
import text.classifier.service.implementation.MapClassificationRulesService;
import text.classifier.service.implementation.TextClassificationService;
import text.classifier.service.interfaces.IClassifyDomainService;
import text.classifier.service.interfaces.ILuceneManagerService;
import text.classifier.service.interfaces.IMapClassificationRulesService;
import text.classifier.service.interfaces.ITextClassificationService;

@Configuration
public class ServiceConfig {

    @Bean
    public IClassifyDomainService classifyDomainService()
    {
        return new ClassifyDomainService();
    }

    @Bean
    public IMapClassificationRulesService mapClassificationRules()
    {
        return new MapClassificationRulesService();
    }

    @Bean
    public ITextClassificationService textClassificationService()
    {
        return new TextClassificationService();
    }

    @Bean
    public ILuceneManagerService luceneManagerService (){
        return new LuceneManagerService();
    }

    @Bean
    public LuceneApp luceneApp (){
        return new LuceneApp();
    }
}
