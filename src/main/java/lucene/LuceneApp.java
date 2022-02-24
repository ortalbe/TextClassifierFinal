package lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@Component
public class LuceneApp {

    @Value("${lucene.index.location}")
    private String indexLocation;
    private String docPath;

    public boolean creatIndex(String path) {
        try
        {
            docPath = path;
            Path docDirectory = Paths.get(indexLocation);
            Directory dir = FSDirectory.open( docDirectory );

            Analyzer analyzer = new StandardAnalyzer();
            IndexWriterConfig wtirerConfig = new IndexWriterConfig(analyzer);
            wtirerConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

            IndexWriter writer = new IndexWriter(dir, wtirerConfig);

            indexDocs(writer, Paths.get(docPath));

            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    void indexDocs(final IndexWriter writer, Path path) throws IOException
    {
        if (Files.isDirectory(path))
        {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>()
            {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
                {
                    try
                    {
                        indexDoc(writer, file, attrs.lastModifiedTime().toMillis());
                    }
                    catch (IOException ioe)
                    {
                        ioe.printStackTrace();
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        else
        {
            indexDoc(writer, path, Files.getLastModifiedTime(path).toMillis());
        }
    }

    static void indexDoc(IndexWriter writer, Path file, long lastModified) throws IOException
    {
        try (InputStream stream = Files.newInputStream(file))
        {
            Document doc = new Document();
            doc.add(new StringField("path", file.toString(), Field.Store.YES));
            doc.add(new LongPoint("modified", lastModified));
            doc.add(new TextField("contents", new String(Files.readAllBytes(file)), Field.Store.YES));
            writer.updateDocument(new Term("path", file.toString()), doc);
        }
    }

    public boolean searchWord(String word) {
        IndexSearcher searcher = null;
        try {
            searcher = createSearcher();
            TopDocs foundDocs = null;
            try {
                foundDocs = searchInContent(word, searcher);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(foundDocs!=null)
                return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;

    }

    private  TopDocs searchInContent(String textToFind, IndexSearcher searcher) throws Exception
    {
        QueryParser qp = new QueryParser("contents", new StandardAnalyzer());
        Query query = qp.parse(textToFind);

        TopDocs hits = searcher.search(query, 5);
        return hits;
    }

    private  IndexSearcher createSearcher() throws IOException
    {
        Directory dir = FSDirectory.open(Paths.get(indexLocation));
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        return searcher;
    }

}
