package org.acme.security.openid.connect.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.client.reactive.filter.OidcClientRequestReactiveFilter;
import io.smallrye.mutiny.Uni;

@RegisterRestClient
@RegisterProvider(OidcClientRequestReactiveFilter.class)
@RegisterProvider(ClientLoggingFilter.class)
@Path("/")
public interface RestClientWithOidcClientFilter {

    @GET
    @Produces("text/plain")
    @Path("userName")
    Uni<String> getUserName();
}