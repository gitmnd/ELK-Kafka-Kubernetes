package com.shopping.kafka.serializerdeserializer;

import com.shopping.kafka.bean.Root;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class SerdeHandler implements Serde<Root> {

    private final LogEventDeserializer logEventDeserializer = new LogEventDeserializer();

    @Override
    public Serializer<Root> serializer() {
        return null;
    }

    @Override
    public Deserializer<Root> deserializer() {
        return logEventDeserializer;
    }
}
