# Elastic Search Java Client

Simple Java application to process basic functionalities (Create Index, Indexing documents, Simple Query) and Parent-Chiild relationship of ElasticSearch. Furthemore it uses TcpTransport client (After ES 7.0v ES considering to remove TcpTransport client, so I recommend to use Hight rest client instead.) 

## Steps
-----
 * build `pom.xml` to install maven dependencies.
 * Install [ElasticSearch] (https://www.elastic.co/downloads).
 * Install the [Kibana] (https://www.elastic.co/downloads/kibana/) which is a web front end for ElasticSearch (to query or check indexed documents).
 * Run application.


### Parent-child relationship implementation
Queries and data samples

```json
PUT my_index
{
    "settings" : {
        "index" : {
            "number_of_shards" : 1,
            "number_of_replicas" : 0
        }
    },
    "mappings": {
    "tpin": {},
    "spin": {
      "_parent": {
        "type": "tpin"
      }
    }
  }
}
```
