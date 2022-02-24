package text.classifier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import text.classifier.json.data.model.implementations.ClassificationRules;
import text.classifier.json.data.model.implementations.ClassificationRulesEntry;
import text.classifier.json.data.model.implementations.Domain;
import text.classifier.json.data.model.implementations.Indicator;
import text.classifier.json.data.model.interfaces.IClassificationRules;
import text.classifier.json.data.model.interfaces.IClassificationRulesEntry;
import text.classifier.json.data.model.interfaces.IDomain;
import text.classifier.json.data.model.interfaces.IIndicator;

@Configuration
public class DataModelConfig {

    @Bean
    @Scope("prototype")
    public IClassificationRulesEntry classificationRulesEntry()
    {
        return new ClassificationRulesEntry();
    }

    @Bean
    @Scope("prototype")
    public IClassificationRules classificationRules()
    {
        return new ClassificationRules();
    }

    @Bean
    public IDomain domain()
    {
        return new Domain();
    }

    @Bean
    public IIndicator indicator()
    {
        return new Indicator();
    }



}
