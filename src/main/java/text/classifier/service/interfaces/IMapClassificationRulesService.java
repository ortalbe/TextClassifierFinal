package text.classifier.service.interfaces;

import text.classifier.json.data.model.interfaces.IClassificationRules;
import java.util.List;
import java.util.Map;


public interface IMapClassificationRulesService {

     boolean execute(String jsonUrl);
     Map<String, List<String>> getMapClassificationRules();
     void setMapClassificationRules(Map<String, List<String>> mapClassificationRules);
     IClassificationRules getClassificationRules();
     void setClassificationRules(IClassificationRules classificationRules) ;

}
