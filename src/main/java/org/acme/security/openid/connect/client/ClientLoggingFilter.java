package org.acme.security.openid.connect.client;

import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientRequestContext;
import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientRequestFilter;
import org.jboss.resteasy.reactive.client.spi.ResteasyReactiveClientResponseFilter;

import javax.inject.Inject;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.ext.Provider;

/**
 * Filter to log external API call results
 */
@Provider
public class ClientLoggingFilter implements ResteasyReactiveClientRequestFilter, ResteasyReactiveClientResponseFilter {

    @Inject
    RequestContextBean requestContextBean;

    @Override
    public void filter(ResteasyReactiveClientRequestContext requestContext) {
        requestContextBean.put("passed request filter", true);

        System.out.println("request filter " + requestContextBean);
    }

    @Override
    public void filter(ResteasyReactiveClientRequestContext requestContext, ClientResponseContext responseContext) {
        requestContextBean.put("passed response filter", true);

        System.out.println("response filter " + requestContextBean);
    }
}
