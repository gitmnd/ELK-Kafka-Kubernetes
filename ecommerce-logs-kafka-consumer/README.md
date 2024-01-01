- Kafka streams application that listen to kafka topic in which the logs are stored by ELK stack
- Streams application that reads data from topic, apply count logic based on api's.
- Count the occurrences of different times an API endpoint using Kafka stream 
- Send the output to a different topic

Assuming you have a Kafka topic named "inputTopic" with key-value pairs where the key is a String and the value is the data you want to count, you can count the occurrences of different values for each key.

**Create Jar**
   ```
   maven package
   ```

**Build docker image **
   ```
   docker build -t ecommerce-logs-kafka-consumer:latest .
   ```

```sh
 cd ecommerce-logs-kafka-consumer/kubernetes
```

``` 
   kubectl apply -f deployment.yaml
   kubectl apply -f service.yaml
```