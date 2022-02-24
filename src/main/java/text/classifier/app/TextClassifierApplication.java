package text.classifier.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import text.classifier.data.type.implementation.TextClassificationServiceInput;
import text.classifier.service.implementation.TextClassificationService;
import text.classifier.service.interfaces.ITextClassificationService;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({"text.classifier.*"})
public class TextClassifierApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TextClassifierApplication.class);

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TextClassifierApplication.class, args);
        validateArgument(args);

        ITextClassificationService textClassificationService = ctx.getBean(TextClassificationService.class);
        textClassificationService.setTextClassificationServiceInput(new TextClassificationServiceInput(args[0],args[1]));
        textClassificationService.execute();
        textClassificationService.getTextClassificationServiceOutput();
        System.out.println(textClassificationService.getTextClassificationServiceOutput().getDomains());
    }

    private static void validateArgument(String [] args) {

        if(args.length!=2)
        {
            LOG.error(" usage is not correct expected 2 input : <scanned file location> <Json file location>");
            throw new IllegalArgumentException();
        }

        String fileLocation = args[0];
        String jsonLocation = args[1];

        if(!checkValidPathLocation(fileLocation))
        {
            LOG.error(" path file system : {} is incorrect. ",args[0]);
            throw new IllegalArgumentException();
        }
        else if (!checkJsonPathLocation(jsonLocation))
        {
            LOG.error(" path file system : {} is incorrect. ",args[1]);
            throw new IllegalArgumentException();
        }


    }

    private static boolean checkJsonPathLocation(String jsonLocation) {
        checkValidPathLocation(jsonLocation);

        return true;
    }

    private static boolean checkValidPathLocation(String path) {
        try {
            Paths.get(path);

        } catch (InvalidPathException ex) {
            return false;
        }
        return true;

    }


}
