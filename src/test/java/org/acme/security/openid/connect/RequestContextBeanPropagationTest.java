package org.acme.security.openid.connect;

import static org.hamcrest.Matchers.is;

import org.acme.security.openid.connect.client.Toto;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.keycloak.client.KeycloakTestClient;
import io.restassured.RestAssured;

import javax.inject.Inject;

@QuarkusTest
public class RequestContextBeanPropagationTest {
    @Inject
    @Channel("totoA")
    Emitter<Toto> totoAEmitter;

    @Inject
    @Channel("totoB")
    Emitter<Toto> totoBEmitter;

    @Test
    public void testConsumesWithOidc() throws InterruptedException {
        System.out.println("sending A");
        totoAEmitter.send(new Toto("totoA"));
        Thread.sleep(1000);
    }
    @Test
    public void testConsumesWithoutOidc() throws InterruptedException {
        System.out.println("sending B");
        totoBEmitter.send(new Toto("totoB"));
        Thread.sleep(1000);
    }
}
