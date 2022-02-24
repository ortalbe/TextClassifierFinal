package text.classifier.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import text.classifier.json.data.model.implementations.ClassificationRules;
import text.classifier.json.data.model.interfaces.IClassificationRules;
import text.classifier.json.data.model.interfaces.IClassificationRulesEntry;
import text.classifier.service.interfaces.IMapClassificationRulesService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class MapClassificationRulesService implements IMapClassificationRulesService {

    private Map<String, List<String>> mapClassificationRules;
    private static final Logger LOG = LoggerFactory.getLogger(MapClassificationRulesService.class);

    @Autowired
    private IClassificationRules classificationRules;

    public MapClassificationRulesService() {
    }

    public MapClassificationRulesService(IClassificationRules classificationRules) {
        this.mapClassificationRules = new HashMap<> ();
        this.classificationRules = classificationRules;
    }

    @Override
    public boolean execute(String jsonUrl) {
        File jsonFile= new File(jsonUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            classificationRules = objectMapper.readValue(jsonFile, ClassificationRules.class);

            mapClassificationRules = new HashMap<>();
            for(IClassificationRulesEntry currentEntry : classificationRules.getClassificationRulesEntries())
            {
                for(String currentIndicator :currentEntry.getIndicators() ) {
                    if (mapClassificationRules.get(currentEntry.getIndicators()) == null) {

                        mapClassificationRules.put(currentIndicator.toLowerCase(), new ArrayList<>(Arrays.asList(currentEntry.getDomain().toLowerCase())));
                    }
                    else
                        mapClassificationRules.get(currentIndicator.toLowerCase()).add(currentEntry.getDomain().toLowerCase());
                }
            }
        }
        catch (FileNotFoundException e)
        {
            LOG.error("File not Exist {}. please do check",jsonUrl);
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            LOG.error("mapping classification rule failed. please check trace.");
            e.printStackTrace();
            return false;
        }


        return true;
    }

    @Override
    public Map<String, List<String>> getMapClassificationRules() {
        return mapClassificationRules;
    }

    @Override
    public void setMapClassificationRules(Map<String, List<String>> mapClassificationRules) {
        this.mapClassificationRules = mapClassificationRules;
    }

    @Override
    public IClassificationRules getClassificationRules() {
        return classificationRules;
    }

    @Override
    public void setClassificationRules(IClassificationRules classificationRules) {
        this.classificationRules = classificationRules;
    }
}
