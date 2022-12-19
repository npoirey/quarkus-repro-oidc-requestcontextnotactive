package org.acme.security.openid.connect.client;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class TotoDeserializer extends JsonbDeserializer<Toto> {
    public TotoDeserializer() {
        super(Toto.class);
    }
}