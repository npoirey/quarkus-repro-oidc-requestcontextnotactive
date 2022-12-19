package org.acme.security.openid.connect.client;

import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RegisterRestClient
@RegisterProvider(ClientLoggingFilter.class)
@Path("/")
public interface RestClientWithoutOidcClientFilter {

    @GET
    @Produces("text/plain")
    @Path("userName")
    Uni<String> getUserName();
}
