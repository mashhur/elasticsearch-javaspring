#Elastic Search Java Client
==========================
Simple Java application to connect to ElasticSearch, and do basic functionalities (Create Index, Indexing documents, Simple Query).

##Steps
-----
 * build `pom.xml` to install maven dependencies.
 * Install [ElasticSearch] (https://www.elastic.co/downloads).
 * Install the [Kibana] (https://www.elastic.co/downloads/kibana/) which is a web front end for ElasticSearch (to query or check indexed documents).
 * Run application.


## Parent-child relationship implementation
// queries and data samples
PUT tpin_temp
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

DELETE tpin_temp
GET tpin_temp/_mapping
GET tpin_temp/_search
GET tpin_temp/tpin/_search
GET tpin_temp/spin/_search

GET tpin_temp/_search
{
  "query": {
    "bool": {
      "must":[
        {
          "match": {
            "_type": "tpin"
          }
        }
        ]
    }
  }
}

GET tpin_temp/_search
{
  "query": {
    "bool": {
      "must":[
        {
          "match": {
            "_type": "spin"
          }
        }
        ]
    }
  }
}

GET tpin_temp/_search
{
  "query": {
    "bool": {
      "must":[
        {
          "match": {
            "tpinCategory.Depth1": 908
          }
        },
        {
          "match": {
            "tpinType": "standard"
          }
        }
      ]
    }
  }
}

GET tpin_temp/_search
{
  "query": {
    "bool": {
      "must":[
          {
            "match": {
              "tpinId": "TPIN494601"
            }
          },
          {
            "match": {
              "_type": "spin"
            }
          }
        ]
    }
  }
}

GET tpin_temp/_search
{
  "query": {
    "bool": {
      "must":[
        {
          "match": {
            "spinName": "250"
          }
        },
        {
          "more_like_this": {
            "boost": 1,
            "like": "250",
            "fields": [
              "inKeyword"
              ]
          }
        },
        {
          "has_parent": {
            "parent_type": "tpin",
            "query": {
              "bool": {
                "must": [
                  {
                    "match": {
                      "tpinCategory.Depth1": 918
                    }
                  },
                  {
                    "match": {
                      "tpinType": "standard"
                    }
                  }
                ]
              }
            }
          }
        }
      ]
    }
  }
}

PUT tpin_temp/tpin/TPIN494601
{
  "tpinName": "씨제이제일제당 명절 선물세트 스팸연어 J호",
  "tpinCategory": {
    "Depth2": 908104,
    "Depth1": 908,
    "Depth4": 908104104125,
    "Depth3": 908104104
  },
  "oldTpinId": "TP00208758",
  "updater": "김정아(mm187)",
  "tpinId": "TPIN494601",
  "specs": [
    {
      "useInSpin": false,
      "specValues": [
        "씨제이"
      ],
      "specNo": 1
    },
    {
      "useInSpin": false,
      "specValues": [
        "|null||0|null"
      ],
      "specNo": 3
    },
    {
      "useInSpin": false,
      "specNo": 761
    },
    {
      "useInSpin": false,
      "specNo": 762
    }
  ],
  "keyItem": false,
  "modelInfo": "",
  "from": "TPIN",
  "_class": "com.tmoncorp.domain.tpin.NewTpin",
  "tpinType": "standard"
}

PUT tpin_temp/tpin/TPIN354765
{
  "use": true,
  "tpinName": "아디다스 G95559",
  "tpinCategory": {
    "Depth2": 918102,
    "Depth1": 918,
    "Depth4": 918102103102,
    "Depth3": 918102103
  },
  "oldTpinId": "TP00151252",
  "updater": "이상준(마이디지털)(mm047sismint)",
  "tpinId": "TPIN354765",
  "specs": [
    {
      "useInSpin": false,
      "specValues": [
        "아디다스"
      ],
      "specNo": 1
    },
    {
      "useInSpin": false,
      "specNo": 761
    },
    {
      "useInSpin": false,
      "specValues": [
        "10|아디다스"
      ],
      "specNo": 2
    },
    {
      "useInSpin": false,
      "specNo": 762
    },
    {
      "useInSpin": true,
      "specNo": 253
    },
    {
      "useInSpin": false,
      "specNo": 837
    },
    {
      "specNo": 805,
      "valueReferenceKeys": [
        8
      ],
      "useInSpin": false,
      "specValues": [
        "기타"
      ]
    },
    {
      "specNo": 485,
      "valueReferenceKeys": [
        5
      ],
      "useInSpin": false,
      "specValues": [
        "워킹화"
      ]
    },
    {
      "useInSpin": false,
      "specNo": 3
    },
    {
      "specNo": 906,
      "valueReferenceKeys": [
        1
      ],
      "useInSpin": false,
      "specValues": [
        "Y"
      ]
    }
  ],
  "keyItem": true,
  "from": "TPIN",
  "tpinType": "standard"
}

PUT tpin_temp/spin/SPIN494603?parent=TPIN494601
{
     "inKeyword": "씨제이,스팸연어,J호",
      "spinId": "SPIN494603",
      "notKeyword": "",
      "use": true,
      "spinName": "기본",
      "oldTpinId": "TP00208758",
      "thumbnail3colImage": "",
      "tpinId": "TPIN494601",
      "specs": [
        {
          "useInSpin": false,
          "specValues": [
            "|mg|||mg"
          ],
          "specNo": 3
        },
        {
          "useInSpin": false,
          "specNo": 761
        },
        {
          "useInSpin": false,
          "specNo": 762
        }
      ],
      "useAutoMatch": false,
      "from": "TPIN",
      "oldSpinId": "SP00194790"
}

PUT tpin_temp/spin/SPIN354773?parent=TPIN354765
{
  "inKeyword": "G95559,250",
  "spinId": "SPIN354773",
  "notKeyword": "",
  "use": true,
  "spinName": "250",
  "oldTpinId": "TP00151252",
  "thumbnail3colImage": "",
  "tpinId": "TPIN354765",
  "specs": [
    {
      "specNo": 253,
      "valueReferenceKeys": [
        31
      ],
      "useInSpin": false,
      "specValues": [
        "250"
      ]
    },
    {
      "useInSpin": false,
      "specNo": 837
    },
    {
      "useInSpin": false,
      "specNo": 805
    },
    {
      "useInSpin": false,
      "specNo": 485
    },
    {
      "useInSpin": false,
      "specNo": 761
    },
    {
      "useInSpin": false,
      "specNo": 762
    },
    {
      "useInSpin": false,
      "specNo": 906
    }
  ],
  "useAutoMatch": false,
  "oldSpinId": "SP00151820"
}

PUT tpin_temp/spin/SPIN354775?parent=TPIN354765
{
  "inKeyword": "G95559,260",
  "spinId": "SPIN354775",
  "notKeyword": "",
  "use": true,
  "spinName": "260",
  "oldTpinId": "TP00151252",
  "thumbnail3colImage": "",
  "tpinId": "TPIN354765",
  "specs": [
    {
      "specNo": 253,
      "valueReferenceKeys": [
        33
      ],
      "useInSpin": false,
      "specValues": [
        "260"
      ]
    },
    {
      "useInSpin": false,
      "specNo": 837
    },
    {
      "useInSpin": false,
      "specNo": 805
    },
    {
      "useInSpin": false,
      "specNo": 485
    },
    {
      "useInSpin": false,
      "specNo": 761
    },
    {
      "useInSpin": false,
      "specNo": 762
    },
    {
      "useInSpin": false,
      "specNo": 906
    }
  ],
  "useAutoMatch": false,
  "oldSpinId": "SP00151821"
}

PUT tpin_temp/spin/SPIN354767?parent=TPIN354765
{
  "inKeyword": "G95559,220",
  "spinId": "SPIN354767",
  "notKeyword": "",
  "use": true,
  "spinName": "220",
  "oldTpinId": "TP00151252",
  "thumbnail3colImage": "",
  "tpinId": "TPIN354765",
  "specs": [
    {
      "specNo": 253,
      "valueReferenceKeys": [
        33
      ],
      "useInSpin": false,
      "specValues": [
        "260"
      ]
    },
    {
      "useInSpin": false,
      "specNo": 837
    },
    {
      "useInSpin": false,
      "specNo": 805
    },
    {
      "useInSpin": false,
      "specNo": 485
    },
    {
      "useInSpin": false,
      "specNo": 761
    },
    {
      "useInSpin": false,
      "specNo": 762
    },
    {
      "useInSpin": false,
      "specNo": 906
    }
  ],
  "useAutoMatch": false,
  "oldSpinId": "SP00142268"
}

PUT tpin_temp/spin/SPIN354771?parent=TPIN354765
{
  "inKeyword": "G95559,240",
  "spinId": "SPIN354771",
  "notKeyword": "",
  "use": true,
  "spinName": "240",
  "oldTpinId": "TP00151252",
  "thumbnail3colImage": "",
  "tpinId": "TPIN354765",
  "specs": [
    {
      "specNo": 253,
      "valueReferenceKeys": [
        29
      ],
      "useInSpin": false,
      "specValues": [
        "240"
      ]
    },
    {
      "useInSpin": false,
      "specNo": 837
    },
    {
      "useInSpin": false,
      "specNo": 805
    },
    {
      "useInSpin": false,
      "specNo": 485
    },
    {
      "useInSpin": false,
      "specNo": 761
    },
    {
      "useInSpin": false,
      "specNo": 762
    },
    {
      "useInSpin": false,
      "specNo": 906
    }
  ],
  "useAutoMatch": false,
  "oldSpinId": "SP00151818"
}

PUT tpin_temp/spin/SPIN354769?parent=TPIN354765
{
  "inKeyword": "G95559,270",
  "spinId": "SPIN354769",
  "notKeyword": "",
  "spinName": "270",
  "oldTpinId": "TP00151252",
  "thumbnail3colImage": "",
  "tpinId": "TPIN354765",
  "specs": [
    {
      "specNo": 253,
      "valueReferenceKeys": [
        35
      ],
      "useInSpin": false,
      "specValues": [
        "270"
      ]
    },
    {
      "useInSpin": false,
      "specNo": 837
    },
    {
      "useInSpin": false,
      "specNo": 805
    },
    {
      "useInSpin": false,
      "specNo": 485
    },
    {
      "useInSpin": false,
      "specNo": 761
    },
    {
      "useInSpin": false,
      "specNo": 762
    },
    {
      "useInSpin": false,
      "specNo": 906
    }
  ],
  "useAutoMatch": false,
  "oldSpinId": "SP00142271"
}