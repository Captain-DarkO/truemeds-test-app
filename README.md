### Build
`mvnw clean package`

### Run
`java -jar target/test-anurag-0.0.1-SNAPSHOT.jar`

Note: default port is 8090

### API
To trigger the batch process service, do a POST request on following endpoint:

`/api/reduceStrings`

E.g.:

curl -X POST http://localhost:8090/api/reduceStrings

