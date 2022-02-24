package text.classifier.service.implementation;

import lucene.LuceneApp;
import org.springframework.beans.factory.annotation.Autowired;
import text.classifier.service.interfaces.ILuceneManagerService;

public class LuceneManagerService implements ILuceneManagerService {

    @Autowired
    private LuceneApp luceneApp;

    @Override
    public boolean creatIndex(String path)
    {
        return luceneApp.creatIndex(path);
    }

    @Override
    public boolean searchWord(String word)
    {
       return  luceneApp.searchWord(word);
    }

    @Override
    public LuceneApp getLuceneApp() {
        return luceneApp;
    }
}
