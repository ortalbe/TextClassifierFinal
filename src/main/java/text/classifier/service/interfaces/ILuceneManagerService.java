package text.classifier.service.interfaces;

import lucene.LuceneApp;

public interface ILuceneManagerService {

    boolean creatIndex(String path);

    boolean searchWord(String word);

    LuceneApp getLuceneApp();
}
