package com.shopping.kafka.serializerdeserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.kafka.bean.Root;
import org.apache.kafka.common.serialization.Deserializer;

public class LogEventDeserializer implements Deserializer<Root> {

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public Root deserialize(String topic, byte[] data) {
        try{
            return objectMapper.readValue(data, Root.class);
        }
        catch (Exception e){
            throw new RuntimeException("Error de-ser",e);
        }
    }
}
