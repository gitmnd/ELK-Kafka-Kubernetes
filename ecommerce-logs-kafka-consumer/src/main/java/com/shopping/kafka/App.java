package com.shopping.kafka;


import com.shopping.kafka.bean.Root;
import com.shopping.kafka.serializerdeserializer.SerdeHandler;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.Serialized;

import java.util.Properties;

public class App
{
    static final String OUTPUT_TOPIC = "OUTPUT_TOPIC";

    public static void main( String[] args )
    {
        KafkaStreams kafkaStreams = null;
        String topicName = "sampletopic";

        try{
            Properties properties = setPros(topicName);
            StreamsBuilder streamsBuilder = new StreamsBuilder();

            System.out.println("Reading from topic: " + topicName);

            //Filter selective API endpoint from message logs
            KStream<String, Root> inputStream = streamsBuilder
                    .stream(
                        topicName,
                        Consumed.with(Serdes.String(), new SerdeHandler())
                     )
                    .filter( (key, value) -> meetsCondition(value)
            );

            System.out.println("Selective API..");

            //Substring API endpoint name from message
            KStream<String, String> substringKStream = inputStream
                    .mapValues(jsonNode -> jsonNode.getMessage().substring(jsonNode.getMessage().indexOf("/") + 1)
                            .toUpperCase());

            System.out.println("Substring API ..");

            substringKStream.foreach((key, value) -> System.out.println("key:" +key +", value: "+ value));


            //Create new key,value pair adding value to the key for better identification
            KStream<String, String> compoundKStream = substringKStream.map(
                    (key,value) -> new KeyValue<>(key +""+ value, value)
            );

            compoundKStream.foreach((key, value) -> System.out.println("key:" +key +", value: "+ value));


            //Count number of occurrence of values per key
            //In our case, we get multiple values from same key
            KStream<String, Long> countStream = compoundKStream
                    .groupByKey(Serialized.with(Serdes.String(), Serdes.String()))
                    .count()
                    .toStream();

            countStream.foreach((key, value) -> System.out.println("key:" +key +", value: "+ value));


            //optional
            //Convert count datatype from long to  string while pushing the count value to another kafka topic
            countStream.mapValues(count -> longToString(count))
                    .to(topicName+OUTPUT_TOPIC, Produced.with(Serdes.String(), Serdes.String()));

            //Streams start
            try{
                kafkaStreams = new KafkaStreams(streamsBuilder.build(),properties);
                System.out.println(kafkaStreams.state());
                kafkaStreams.start();
                Thread.sleep(10000);
            }catch(Exception e){
                System.out.println("Error"+e);
                e.printStackTrace();
            }


            //hook
            Runtime.getRuntime().addShutdownHook(new Thread(kafkaStreams::close));
        }
        catch(Exception e){
            System.out.println("## Error in Kafka stream consumer ##");
            e.printStackTrace();
        }
    }

    private static String longToString(Long count) {
        return Long.toString(count);
    }

    private static boolean meetsCondition(Root value) {

        if(value.getMessage().contains("users") || value.getMessage().contains("location")){
            return true;
        } else {
            return true;
        }
    }

    private static Properties setPros(String topicName) {
        //Use Kafka service DNS here
        String desktopServer = "10.110.112.130:9092";
        String localhost = "localhost:31757";
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, topicName + "event-process");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, desktopServer);
        return properties;
    }
}
