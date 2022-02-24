# TextClassifier_OrtalBenHaroshAragau

1. to parse the json I used Jackson library 
2. to search inside  large file I used Lucene library.
   I decide to use Lucene cause it's not required upload server and simple then elastic search or Solr .
   in real world I believe that elastic search is the approach to handle it.

the code wrote in order to support :
1. changes in json structre - for instance add to each word a weight and calculate the score according to its weights.
2. all services also define as interface in order to support easy changes in the logic.
3. the only class that is not service is the LuceneApp - it must have all functionality under it.

big data examples took from : 
https://data.mendeley.com/datasets/9rw3vkcfy4/2/files/e0ed118e-529c-4e94-921e-9cdaeae7b7f8