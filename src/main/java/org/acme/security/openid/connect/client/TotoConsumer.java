package org.acme.security.openid.connect.client;

//import io.smallrye.reactive.messaging.annotations.Blocking;
import io.smallrye.common.annotation.Blocking;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.inject.Inject;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class TotoConsumer {

    @Inject
    RequestContextBean requestContextBean;

    @Inject
    @RestClient
    RestClientWithOidcClientFilter restClientWithOidcClientFilter;

    @Inject
    @RestClient
    RestClientWithoutOidcClientFilter restClientWithoutOidcClientFilter;

    @Incoming("totoA")
    @Blocking
    @ActivateRequestContext
    public CompletionStage<Void> consumeA(Message<Toto> msg) {
        System.out.println("consumesA");
        try{
            requestContextBean.put("name", msg.getPayload().getName());

            System.out.println(restClientWithOidcClientFilter.getUserName().await().indefinitely());
        } catch (Exception e){
            e.printStackTrace();
        }
        return msg.ack();
    }

    @Incoming("totoB")
    @Blocking
    @ActivateRequestContext
    public CompletionStage<Void> consumeB(Message<Toto> msg) {
        System.out.println("consumesB");
        try{
            requestContextBean.put("name", msg.getPayload().getName());

            System.out.println(restClientWithoutOidcClientFilter.getUserName().await().indefinitely());
        } catch (Exception e){
            e.printStackTrace();
        }
        return msg.ack();
    }
}
