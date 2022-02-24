package text.classifier.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import text.classifier.data.type.implementation.TextClassificationServiceInput;
import text.classifier.data.type.implementation.TextClassificationServiceOutput;
import text.classifier.data.type.interfaces.ITextClassificationServiceInput;
import text.classifier.data.type.interfaces.ITextClassificationServiceOutput;

@Configuration
public class DataTypeConfig {

    @Bean
    public ITextClassificationServiceInput textClassificationServiceInput()
    {
        return new TextClassificationServiceInput() ;
    }

    @Bean
    public ITextClassificationServiceOutput textClassificationServiceOutput()
    {
        return new TextClassificationServiceOutput() ;
    }
}
